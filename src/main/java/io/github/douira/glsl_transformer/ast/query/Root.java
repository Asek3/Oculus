package io.github.douira.glsl_transformer.ast.query;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

import io.github.douira.glsl_transformer.ast.node.*;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.expression.*;
import io.github.douira.glsl_transformer.ast.node.external_declaration.ExternalDeclaration;
import io.github.douira.glsl_transformer.ast.query.index.*;
import io.github.douira.glsl_transformer.ast.query.match.*;
import io.github.douira.glsl_transformer.ast.transform.ASTParser;
import io.github.douira.glsl_transformer.util.Passthrough;

/**
 * Each AST has a root referenced by all its members. This class manages the
 * indexes of the tree and is updated each time a node is added or removed from
 * the tree. It also contains methods for indexing nodes for building a tree and
 * for performing replacement operations on the tree using the stored indexes.
 */
public class Root {
  /**
   * The node index is used to query nodes by their type. There are various
   * available node index implementations that provide different trade-offs
   * between performance, memory consumption and query capabilities.
   */
  public final NodeIndex<?> nodeIndex;

  /**
   * The identifier index is used to query identifiers by their name or prefixes
   * on their name. There are various available identifier index implementations
   * that provide different trade-offs between performance, memory consumption and
   * query capabilities.
   */
  public final IdentifierIndex<?, ?> identifierIndex;

  /**
   * The external declaration index indexes the external declarations by their
   * name. Each node may appear multiple times if it contains multiple members
   * with different names.
   */
  public final ExternalDeclarationIndex<?, ?> externalDeclarationIndex;

  // internal utility state
  private static Deque<Root> activeBuildRoots = new ArrayDeque<>();
  private List<? extends ASTNode> nodeList;
  private boolean activity;

  /**
   * Constructs a new root with the given node and identifier indexes.
   * 
   * @param nodeIndex                The node index
   * @param identifierIndex          The identifier index
   * @param externalDeclarationIndex The external declaration index
   */
  public Root(NodeIndex<?> nodeIndex,
      IdentifierIndex<?, ?> identifierIndex,
      ExternalDeclarationIndex<?, ?> externalDeclarationIndex) {
    this.nodeIndex = nodeIndex;
    this.identifierIndex = identifierIndex;
    this.externalDeclarationIndex = externalDeclarationIndex;
  }

  /**
   * Returns the identifier index as a prefix identifier index if it is one.
   * Otherwise, it throws.
   * 
   * @return The prefix identifier index
   */
  public PrefixIdentifierIndex<?, ?> getPrefixIdentifierIndex() {
    if (identifierIndex instanceof PrefixIdentifierIndex<?, ?> index) {
      return index;
    } else {
      throw new IllegalStateException("The identifier index is not a prefix index");
    }
  }

  public PrefixExternalDeclarationIndex<?, ?> getPrefixExternalDeclarationIndex() {
    if (externalDeclarationIndex instanceof PrefixExternalDeclarationIndex<?, ?> index) {
      return index;
    } else {
      throw new IllegalStateException("The external declaration index is not a prefix index");
    }
  }

  /**
   * Registers the given node with this root.
   * 
   * @param node          The node to register
   * @param isSubtreeRoot Whether the node is the root of a subtree that is being
   *                      added
   */
  public void registerNode(ASTNode node, boolean isSubtreeRoot) {
    if (nodeIndex != null) {
      nodeIndex.add(node);
    }
    if (identifierIndex != null && node instanceof Identifier identifier) {
      identifierIndex.add(identifier);
    }
    if (externalDeclarationIndex != null) {
      if (node instanceof ExternalDeclaration externalDeclaration) {
        externalDeclarationIndex.add(externalDeclaration);
      } else if (isSubtreeRoot && !(node instanceof TranslationUnit)) {
        externalDeclarationIndex.notifySubtreeAdd(node);
      }
    }
  }

  /**
   * Unregisters the given node from this root.
   * 
   * @param node          The node to unregister
   * @param isSubtreeRoot Whether the node is the root of a subtree that is being
   *                      removed
   */
  public void unregisterNode(ASTNode node, boolean isSubtreeRoot) {
    if (nodeIndex != null) {
      nodeIndex.remove(node);
    }
    if (identifierIndex != null && node instanceof Identifier identifier) {
      identifierIndex.remove(identifier);
    }
    if (externalDeclarationIndex != null) {
      if (node instanceof ExternalDeclaration externalDeclaration) {
        externalDeclarationIndex.remove(externalDeclaration);
      } else if (isSubtreeRoot && !(node instanceof TranslationUnit)) {
        externalDeclarationIndex.notifySubtreeRemove(node);
      }
    }
  }

  public void unregisterIdentifierRename(Identifier identifier) {
    if (identifierIndex != null) {
      identifierIndex.remove(identifier);
    }
    unregisterFastRename(identifier);
  }

  public void unregisterFastRename(ASTNode identifier) {
    if (externalDeclarationIndex != null) {
      externalDeclarationIndex.notifySubtreeRemove(identifier);
    }
  }

  public void registerIdentifierRename(Identifier identifier) {
    if (identifierIndex != null) {
      identifierIndex.add(identifier);
    }
    registerFastRename(identifier);
  }

  public void registerFastRename(ASTNode identifier) {
    if (externalDeclarationIndex != null) {
      externalDeclarationIndex.notifySubtreeAdd(identifier);
    }
  }

  private void ensureEmptyNodeList() {
    if (nodeList == null) {
      nodeList = new ArrayList<>();
    } else {
      nodeList.clear();
    }
  }

  /**
   * Returns the currently active build root. When nodes are constructed within a
   * build session, this method returns the root of the build session. Nodes can't
   * be constructed with children if they have no root since the children must be
   * registered with the root.
   * 
   * @return the currently active build root
   */
  public static Root getActiveBuildRoot() {
    return activeBuildRoots.peekFirst();
  }

  /**
   * Runs the given consumer with the given root as the active build root.
   * 
   * @param <R>          The return type of the consumer
   * @param rootConsumer The consumer to run
   * @return The return value of the consumer
   */
  protected final <R> R withActiveBuildRoot(
      Function<Root, R> rootConsumer) {
    activeBuildRoots.push(this);
    try {
      return rootConsumer.apply(this);
    } finally {
      activeBuildRoots.pop();
    }
  }

  /**
   * Runs the given builder supplier with the given root as the active build root
   * and then registers the returned node with the root. This is necessary since
   * the node will have the correct root but will not be registered until it is
   * either manually registered as it is being done here or added as a child to
   * another node with the root.
   * 
   * @param <N>      The type of the node to build
   * @param builder  The builder to run
   * @return The built and registered node
   */
  public <N extends ASTNode> N indexNodes(Supplier<N> builder) {
    return withActiveBuildRoot(root -> {
      var result = builder.get();
      root.registerNode(result, true);
      return result;
    });
  }

  /**
   * Runs a given runnable with the given root as the active build root. This is
   * used for constructing nodes with children without registering the constructed
   * root node with the root or for registering it manually.
   * 
   * @param session  The runnable to run
   */
  public void indexBuildSession(Runnable session) {
    withActiveBuildRoot(root -> {
      session.run();
      return null;
    });
  }

  public void indexBuildSession(Consumer<Root> session) {
    withActiveBuildRoot(root -> {
      session.accept(root);
      return null;
    });
  }

  /**
   * Runs the given consumer of a registration pass-through function with the
   * given root as the active build root. The consumer receives a pass-through
   * function that takes a constructed node and registers it with the root. This
   * is helpful for constructing trees manually and registering them inline.
   * 
   * @param <N>                The type of the nodes to register
   * @param registererConsumer The consumer to run
   */
  public <N extends ASTNode> void indexSeparateTrees(Consumer<Passthrough<N>> registererConsumer) {
    withActiveBuildRoot(root -> {
      registererConsumer.accept(node -> {
        root.registerNode(node, true);
        return node;
      });
      return null;
    });
  }

  /**
   * Renames all identifiers with the given old name to the given new name.
   * 
   * @param oldName The old name
   * @param newName The new name
   * @return Whether anything was renamed
   */
  public boolean rename(String oldName, String newName) {
    return identifierIndex.rename(oldName, newName);
  }

  /**
   * Processes all target nodes from the given stream with the given consumer.
   * This method ensures there is no concurrent modification of the node index by
   * collecting the stream into a shared list.
   * 
   * @param <N>      The type of the target nodes
   * @param targets  The stream of target nodes to process
   * @param replacer The consumer to process the target nodes with
   * @return Whether anything was processed
   */
  @SuppressWarnings("unchecked")
  public <N extends ASTNode> boolean process(Stream<? extends N> targets, Consumer<? super N> replacer) {
    ensureEmptyNodeList();
    if (targets == null) {
      return false;
    }
    var typedList = (List<N>) nodeList;
    targets.forEach(typedList::add);
    var activity = false;
    for (N node : typedList) {
      if (node != null) {
        replacer.accept(node);
        activity = true;
      }
    }
    return activity;
  }

  /**
   * Processes all identifiers with the given name with the given consumer.
   * 
   * @param name     The name of the identifiers to process
   * @param replacer The consumer to process the identifiers with
   * @return Whether anything was processed
   */
  public boolean process(String name, Consumer<Identifier> replacer) {
    return process(identifierIndex.getStream(name), replacer);
  }

  /**
   * Replaces all reference expressions containing identifiers with the given name
   * with the given replacement expression. Identifiers that are not part of a
   * reference expression are not replaced since an expression would be impossible
   * as a replacement.
   * 
   * @param t          The AST transformer
   * @param name       The name of the identifiers to target
   * @param expression The content of the replacement expression
   */
  public void replaceReferenceExpressions(
      ASTParser t,
      String name,
      String expression) {
    replaceReferenceExpressions(
        t,
        identifierIndex.getStream(name),
        expression);
  }

  /**
   * Replaces all reference expressions containing identifiers with the given name
   * with the given replacement expression. Identifiers that are not part of a
   * reference expression are not replaced since an expression would be impossible
   * as a replacement.
   * 
   * @param t          The AST transformer
   * @param name       The name of the identifiers to target
   * @param expression The content of the replacement expression
   * @return Whether any replacements were made
   */
  public boolean replaceReferenceExpressionsReport(
      ASTParser t,
      String name,
      String expression) {
    return replaceReferenceExpressionsReport(
        t,
        identifierIndex.getStream(name),
        expression);
  }

  /**
   * Replaces all reference expressions containing the given identifiers from the
   * given stream with the given replacement expression.
   * 
   * @param t          The AST transformer
   * @param targets    The stream of identifiers to target
   * @param expression The content of the replacement expression
   */
  public void replaceReferenceExpressions(
      ASTParser t,
      Stream<Identifier> targets,
      String expression) {
    process(targets, identifier -> {
      var parent = identifier.getParent();
      if (!(parent instanceof ReferenceExpression)) {
        return;
      }
      parent.replaceByAndDelete(
          t.parseExpression(identifier.getRoot(), expression));
    });
  }

  /**
   * Replaces all reference expressions containing the given identifiers from the
   * given stream with the given replacement expression.
   * 
   * @param t          The AST transformer
   * @param targets    The stream of identifiers to target
   * @param expression The content of the replacement expression
   * @return Whether any replacements were made
   */
  public boolean replaceReferenceExpressionsReport(
      ASTParser t,
      Stream<Identifier> targets,
      String expression) {
    activity = false;
    process(targets, identifier -> {
      var parent = identifier.getParent();
      if (!(parent instanceof ReferenceExpression)) {
        return;
      }
      parent.replaceByAndDelete(
          t.parseExpression(identifier.getRoot(), expression));
      activity = true;
    });
    return activity;
  }

  /**
   * Replaces all expressions from the given stream with the given replacement
   * expression.
   * 
   * @param t          The AST transformer
   * @param targets    The stream of expressions to target
   * @param expression The content of the replacement expression
   * @return Whether any replacements were made
   */
  public boolean replaceExpressions(
      ASTParser t,
      Stream<? extends Expression> targets,
      String expression) {
    return process(targets, node -> {
      node.replaceByAndDelete(
          t.parseExpression(node.getRoot(), expression));
    });
  }

  /**
   * Replaces all expressions from the given list with the given replacement
   * expression but without storing the targets in an intermediary list under the
   * assumption that this list will not be modified by the replacement.
   * 
   * @param t          The AST transformer
   * @param targets    The list of expressions to target
   * @param expression The content of the replacement expression
   * @return Whether any replacements were made
   */
  public static boolean replaceExpressionsConcurrent(
      ASTParser t,
      List<? extends Expression> targets,
      String expression) {
    for (var node : targets) {
      node.replaceByAndDelete(
          t.parseExpression(node.getRoot(), expression));
    }
    return !targets.isEmpty();
  }

  /**
   * Processes all matches of nodes from the given stream matched with the given
   * matcher.
   * 
   * @param <N>                 The type of the matched nodes
   * @param t                   The AST transformer
   * @param matchTargetChildren The stream of nodes to match
   * @param matcher             The matcher to match the nodes with
   * @param replacer            The consumer to process the matched nodes with
   * @return Whether anything was processed
   */
  public <N extends ASTNode> boolean processMatches(
      ASTParser t,
      Stream<? extends ASTNode> matchTargetChildren,
      Matcher<N> matcher,
      Consumer<? super N> replacer) {
    var matchClass = matcher.getPatternClass();
    return process(matchTargetChildren
        .map(node -> node.getAncestor(matchClass))
        .distinct()
        .filter(matcher::matches),
        replacer);
  }

  /**
   * Processes all matches of nodes in the tree that match the given hinted
   * matcher. The hint is used to identify the nodes to match.
   * 
   * @param <N>           The type of the matched nodes
   * @param t             The AST transformer
   * @param hintedMatcher The matcher to match the nodes with
   * @param replacer      The consumer to process the matched nodes with
   * @return Whether anything was processed
   */
  public <N extends ASTNode> boolean processMatches(
      ASTParser t,
      HintedMatcher<N> hintedMatcher,
      Consumer<? super N> replacer) {
    return processMatches(t,
        identifierIndex.getStream(hintedMatcher.getHint()), hintedMatcher, replacer);
  }

  /**
   * Replaces expressions from the given stream that match the given matcher with
   * new expressions created from the given string.
   * 
   * @param <N>                 The type of the matched expression nodes
   * @param t                   The AST transformer
   * @param matchTargetChildren The stream of nodes to match
   * @param matcher             The matcher to match the nodes with
   * @param expression          The content of the replacement expression
   * @return Whether anything was processed
   */
  public <N extends Expression> boolean replaceExpressionMatches(
      ASTParser t,
      Stream<? extends ASTNode> matchTargetChildren,
      Matcher<N> matcher,
      String expression) {
    var matchClass = matcher.getPatternClass();
    return replaceExpressions(t,
        matchTargetChildren
            .map(node -> node.getAncestor(matchClass))
            .distinct()
            .filter(matcher::matches),
        expression);
  }

  /**
   * Replaces expressions all matches of expression nodes in the tree that match
   * the given hinted matcher with new expressions created from the given string.
   * 
   * @param <N>           The type of the matched expression nodes
   * @param t             The AST transformer
   * @param hintedMatcher The matcher to match the nodes with
   * @param expression    The content of the replacement expression
   * @return Whether anything was processed
   */
  public <N extends Expression> boolean replaceExpressionMatches(
      ASTParser t,
      HintedMatcher<N> hintedMatcher,
      String expression) {
    return replaceExpressionMatches(t,
        identifierIndex.getStream(hintedMatcher.getHint()), hintedMatcher, expression);
  }
}
