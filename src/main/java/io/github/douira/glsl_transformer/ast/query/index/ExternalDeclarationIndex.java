package io.github.douira.glsl_transformer.ast.query.index;

import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.declaration.*;
import io.github.douira.glsl_transformer.ast.node.external_declaration.*;
import io.github.douira.glsl_transformer.ast.node.type.specifier.FunctionPrototype;
import io.github.douira.glsl_transformer.ast.query.index.ExternalDeclarationIndex.DeclarationEntry;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class ExternalDeclarationIndex<S extends Set<DeclarationEntry>, I extends Map<String, S>>
    extends StringKeyedIndex<DeclarationEntry, ExternalDeclaration, S, I> {
  public ExternalDeclarationIndex(I index, Supplier<S> setFactory) {
    super(index, setFactory);
  }

  public static record DeclarationEntry(ExternalDeclaration declaration, ASTNode keyMember) {
  }

  @Override
  protected ExternalDeclaration getNode(DeclarationEntry entry) {
    return entry.declaration;
  }

  private void iterateKeyMembers(ExternalDeclaration node, BiConsumer<ASTNode, String> memberConsumer) {
    if (node instanceof DeclarationExternalDeclaration declarationExternalDeclaration) {
      Declaration declaration = declarationExternalDeclaration.getDeclaration();
      if (declaration instanceof TypeAndInitDeclaration typeAndInitDeclaration) {
        for (var member : typeAndInitDeclaration.getMembers()) {
          memberConsumer.accept(member, member.getName().getName());
        }
      } else if (declaration instanceof FunctionDeclaration functionDeclaration) {
        memberConsumer.accept(node, functionDeclaration.getFunctionPrototype().getName().getName());
      } else if (declaration instanceof InterfaceBlockDeclaration interfaceBlockDeclaration) {
        memberConsumer.accept(node, interfaceBlockDeclaration.getBlockName().getName());
      } else if (declaration instanceof VariableDeclaration variableDeclaration) {
        for (var name : variableDeclaration.getNames()) {
          memberConsumer.accept(name, name.getName());
        }
      }

      // skips PrecisionDeclaration
    } else if (node instanceof FunctionDefinition functionDefinition) {
      memberConsumer.accept(node, functionDefinition.getFunctionPrototype().getName().getName());
    } else if (node instanceof ExtensionDirective extensionDirective) {
      memberConsumer.accept(node, extensionDirective.getName());
    } else if (node instanceof CustomDirective customDirective) {
      memberConsumer.accept(node, customDirective.getContent());
    } else if (node instanceof IncludeDirective includeDirective) {
      memberConsumer.accept(node, includeDirective.getContent());
    }

    // skips PragmaDirective, LayoutDefaults, EmptyDeclaration
  }

  private void addEntry(ExternalDeclaration node, ASTNode keyMember, String key) {
    var set = index.get(key);
    if (set == null) {
      set = setFactory.get();
      index.put(key, set);
    }
    set.add(new DeclarationEntry(node, keyMember));
  }

  private void removeEntry(ExternalDeclaration node, ASTNode keyMember, String key) {
    var set = index.get(key);
    if (set == null) {
      return;
    }
    set.remove(new DeclarationEntry(node, keyMember));
    if (set.isEmpty()) {
      index.remove(key);
    }
  }

  @Override
  public void add(ExternalDeclaration node) {
    iterateKeyMembers(node, (keyMember, key) -> {
      addEntry(node, keyMember, key);
    });
  }

  @Override
  public void remove(ExternalDeclaration node) {
    iterateKeyMembers(node, (keyMember, key) -> {
      removeEntry(node, keyMember, key);
    });
  }

  private void iterateSubtreeEntries(
      ASTNode node,
      ASTNode nodeParent,
      BiConsumer<ASTNode, String> memberConsumer) {
    // only some nodes are interesting since most other types of nodes don't
    // influence the key of an external declaration entry
    if (node == null) {
      return;
    }

    // if the modified node is a parent that can have children, they need to be
    // iterated
    if (node instanceof TypeAndInitDeclaration typeAndInitDeclaration) {
      for (var member : typeAndInitDeclaration.getMembers()) {
        memberConsumer.accept(member, member.getName().getName());
      }
      return;
    }
    if (node instanceof VariableDeclaration variableDeclaration) {
      for (var name : variableDeclaration.getNames()) {
        memberConsumer.accept(name, name.getName());
      }
      return;
    }

    // from this point on, only a singe key member will be generated

    // the key member needs to be tracked separately since in the case of
    // identifiers and declaration members changing the parent isn't the key member
    // that's stored in the index since they're part of declarations that can have
    // multiple entries, one for each member
    String singleKey = null;
    ASTNode keyMember = node;
    if (node instanceof Identifier identifier) {
      singleKey = identifier.getName();
      keyMember = node;
      node = node.getParent();
    }

    // step up through the various admissable node types
    if (node instanceof DeclarationMember) {
      keyMember = node;
      node = node.getParent();
    }
    if (node instanceof FunctionPrototype) {
      node = node.getParent();
    }
    if (node instanceof FunctionDefinition) {
      memberConsumer.accept(node, singleKey);
      return;
    }
    if (node instanceof VariableDeclaration
        || node instanceof TypeAndInitDeclaration) {
      node = node.getParent();
    } else if (node instanceof FunctionDeclaration
        || node instanceof InterfaceBlockDeclaration) {
      node = node.getParent();

      // set the parent back to the parent because for these types of declarations
      // there are no specific key members and the ED is the key member itself
      keyMember = node;
    }
    if (node instanceof DeclarationExternalDeclaration) {
      memberConsumer.accept(keyMember, singleKey);
      return;
    }
  }

  /**
   * Run when some other node is added. This is necessary to keep track
   * of the key members since their names determine the keys of the external
   * declarations stored in this index.
   *
   * This method should only be called on the root node of the subtree being
   * registered to avoid complication of repeatedly adding parts of the same
   * subtree.
   *
   * @param subtreeRoot the node that was added, not an external declaration
   */
  public void notifySubtreeAdd(ASTNode subtreeRoot) {
    if (subtreeRoot instanceof ExternalDeclaration externalDeclaration) {
      add(externalDeclaration);
    }

    iterateSubtreeEntries(subtreeRoot, subtreeRoot.getParent(), (keyMember, key) -> {
      addEntry(keyMember.getAncestor(ExternalDeclaration.class), keyMember, key);
    });
  }

  /**
   * Method to notify of a node being removed. For notification of a subtree
   * change so that the external declaration index can be updated, see
   * {@link #notifySubtreeAdd(ASTNode)}.
   *
   * @param subtreeRoot the node that was removed, not an external declaration
   */
  public void notifySubtreeRemove(ASTNode subtreeRoot) {
    if (subtreeRoot instanceof ExternalDeclaration externalDeclaration) {
      remove(externalDeclaration);
    }

    // when the node is unregistered, the parent has already been removed. The last
    // parent (the one that was just removed) must be used instead.
    iterateSubtreeEntries(subtreeRoot, subtreeRoot.getLastParent(), (keyMember, key) -> {
      removeEntry(keyMember.getAncestor(ExternalDeclaration.class), keyMember, key);
    });
  }

  public static ExternalDeclarationIndex<HashSet<DeclarationEntry>, HashMap<String, HashSet<DeclarationEntry>>> withOnlyExact() {
    return new ExternalDeclarationIndex<>(new HashMap<>(), HashSet::new);
  }

  public static ExternalDeclarationIndex<LinkedHashSet<DeclarationEntry>, HashMap<String, LinkedHashSet<DeclarationEntry>>> withOnlyExactOrdered() {
    return new ExternalDeclarationIndex<>(new HashMap<>(), LinkedHashSet::new);
  }

  public static <R extends Set<DeclarationEntry>> ExternalDeclarationIndex<R, HashMap<String, R>> withOnlyExact(
      Supplier<R> setFactory) {
    return new ExternalDeclarationIndex<>(new HashMap<>(), setFactory);
  }
}
