package io.github.douira.glsl_transformer.ast.node.abstract_node;

import io.github.douira.glsl_transformer.ast.data.ChildNodeList;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.transform.ASTBuilder;
import io.github.douira.glsl_transformer.ast.transform.SourceLocation;
import io.github.douira.glsl_transformer.ast.transform.Template;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;
import io.github.douira.glsl_transformer.ast.traversal.ASTVoidVisitor;

import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * The AST node represents a node in the abstract syntax tree. Each AST node has
 * a reference to the shared root object that contains the indexes for querying
 * the tree.
 *
 * Invariants:
 * 1. The root must contain exactly the nodes that are accessible by
 * traversing the tree downwards at any time.
 * 2. Each contained node must have a reference to the root node it is part of.
 * 3. The node must have a reference to its parent if it's not the root of the
 * tree and it must have the same root reference as its parent.
 * 4. The selfReplacer function replaces the current node in the referenced
 * parent with a new one.
 * 5. An AST node may only ever be in a tree once. Attempting to insert it
 * multiple times will cause undefined behavior. Moving a node requires removing
 * it from one parent and then adding it to another.
 *
 * While it is possible to have a single node appear multiple times throughout
 * the tree (at which point the tree becomes a DAG), this is discuraged since it
 * violates common expectations like the fact that removing a node doesn't also
 * affect other parts of the tree.
 *
 * The tree is constructed from the buttom up in the {@link ASTBuilder}. The
 * roots are set on each of the nodes by getting the current active build root
 * from the {@link Root}'s global method.
 */
public abstract class ASTNode {
  private ASTNode parent;
  // the parent this node had before it was replaced, used for ensuring index
  // consistency during replacement of this node with another one in the parent.
  // In some cases, the index needs to look up the parent of this node even after
  // it has been replaced.
  private ASTNode lastParent;
  private Consumer<ASTNode> selfReplacer;
  private Root root = Root.getActiveBuildRoot();
  protected Template<?> template = null;
  protected SourceLocation sourceLocation = null;

  /**
   * Whether this node has been registered with the root. This is only used when
   * constructing nodes. The {@link #setParent(ASTNode)} method does not check
   * this recursively.
   */
  private boolean registered = false;

  public ASTNode() {
  }

  public abstract <R> R accept(ASTVisitor<R> visitor);

  public SourceLocation getSourceLocation() {
    return sourceLocation;
  }

  void setSourceLocation(SourceLocation sourceLocation) {
    this.sourceLocation = sourceLocation;
  }

  public ASTNode getParent() {
    return parent;
  }

  public ASTNode getLastParent() {
    return lastParent;
  }

  public boolean hasParent() {
    return parent != null;
  }

  public Consumer<ASTNode> getParentSetter() {
    return selfReplacer;
  }

  /**
   * Gets the nth parent of this node. The 0th parent is this node. The 1st parent
   * is the parent of this node.
   *
   * @param n the number of parents to go up
   * @return the nth parent of this node
   */
  public ASTNode getNthParent(int n) {
    ASTNode node = this;
    for (int i = 0; i < n; i++) {
      if (node == null) {
        return null;
      }
      node = node.getParent();
    }
    return node;
  }

  /**
   * Checks if there is an ancestor of this node that fulfills the given
   * predicate within a limited nubmer of steps after a number of steps skipped.
   * If the limit is 0, it will only check the current node.
   *
   * @param limit     the number of parents to check in total
   * @param skip      the number of parents to skip before checking the predicate
   * @param predicate the predicate to check
   * @return true if there is an ancestor of this node that fulfills the given
   *         predicate, false otherwise
   */
  public boolean hasAncestor(int limit, int skip, Predicate<ASTNode> predicate) {
    ASTNode node = this;
    for (int i = 0; i <= limit; i++) {
      if (node == null) {
        return false;
      }
      if (i >= skip && predicate.test(node)) {
        return true;
      }
      node = node.getParent();
    }
    return false;
  }

  /**
   * Checks if there is an ancestor of this node that fulfills the given
   * predicate.
   *
   * @param predicate the predicate to check
   * @return true if there is an ancestor of this node that fulfills the predicate
   */
  public boolean hasAncestor(Predicate<ASTNode> predicate) {
    return hasAncestor(Integer.MAX_VALUE, 0, predicate);
  }

  /**
   * Checks if there is an ancestor of this node that is an instance of the given
   * class.
   *
   * @param ancestorType the class to check
   * @return true if there is an ancestor that is an instance of the given class
   */
  public boolean hasAncestor(Class<? extends ASTNode> ancestorType) {
    return hasAncestor(ancestorType::isInstance);
  }

  /**
   * Checks if the given node is an ancestor of this node.
   *
   * @param node the node to check
   * @return true if the given node is an ancestor of this node
   */
  public boolean hasAncestor(ASTNode node) {
    return hasAncestor(node::equals);
  }

  /**
   * Returns the first ancestor that fulfills the given predicate, limited to a
   * certain number of steps. If the limit is 0, it will only check the current
   * node.
   *
   * @param limit     the number of parents to check in total
   * @param skip      the number of steps to skip before checking the predicate
   * @param predicate the predicate to check
   * @return the first ancestor that fulfills the given predicate, or null
   *         otherwise
   */
  public ASTNode getAncestor(int limit, int skip, Predicate<ASTNode> predicate) {
    ASTNode node = this;
    for (int i = 0; i <= limit; i++) {
      if (node == null) {
        return null;
      }
      if (i >= skip && predicate.test(node)) {
        return node;
      }
      node = node.getParent();
    }
    return null;
  }

  /**
   * Returns the first ancestor that fulfills the given predicate.
   *
   * @param predicate the predicate to check
   * @return the first ancestor that fulfills the given predicate, or null
   *         otherwise
   */
  public ASTNode getAncestor(Predicate<ASTNode> predicate) {
    return getAncestor(Integer.MAX_VALUE, 0, predicate);
  }

  /**
   * Returns the first ancestor that is an instance of the given class.
   *
   * @param ancestorType the class to check
   * @return the first ancestor that is an instance of the given class, or null
   *         otherwise
   */
  public <N extends ASTNode> N getAncestor(Class<N> ancestorType) {
    return ancestorType.cast(getAncestor(ancestorType::isInstance));
  }

  public ASTNode getBranchAncestor(int limit, int skip, BiPredicate<ASTNode, ASTNode> predicate) {
    ASTNode node = this;
    ASTNode last = null;
    for (int i = 0; i <= limit; i++) {
      if (node == null) {
        return null;
      }
      if (i >= skip && predicate.test(node, last)) {
        return node;
      }
      last = node;
      node = node.getParent();
    }
    return null;
  }

  @SuppressWarnings("unchecked")
  public <N extends ASTNode> N getBranchAncestor(int limit, int skip, Class<N> branchClass,
      Function<N, ? extends ASTNode> branchGetter) {
    return (N) getBranchAncestor(limit, skip, (node, last) -> {
      if (!branchClass.isInstance(node)) {
        return false;
      }
      return branchGetter.apply(branchClass.cast(node)) == last;
    });
  }

  public <N extends ASTNode> N getBranchAncestor(Class<N> branchClass,
      Function<N, ? extends ASTNode> branchGetter) {
    return getBranchAncestor(Integer.MAX_VALUE, 0, branchClass, branchGetter);
  }

  public <N extends ASTNode, R extends ASTNode> R getBranchAncestorContinue(Class<N> branchClass,
      Function<N, ? extends ASTNode> branchGetter, Class<R> continueClass) {
    N result = getBranchAncestor(branchClass, branchGetter);
    return result == null ? null : result.getAncestor(continueClass);
  }

  /**
   * Returns a lazy stream of all ancestors of this node.
   *
   * @return a stream of the ancestors
   */
  public Stream<ASTNode> getAncestors() {
    return Stream.iterate(this, ASTNode::hasParent, ASTNode::getParent);
  }

  /**
   * Returns the root of this node.
   *
   * @return the root
   */
  public Root getRoot() {
    return root;
  }

  private void setRoot(Root root, boolean isSubtreeRoot) {
    if (this.root == root) {
      return;
    }
    if (registered) {
      unregister(isSubtreeRoot);
    }
    this.root = root;
    register(isSubtreeRoot);
  }

  private void unregister(boolean isSubtreeRoot) {
    root.unregisterNode(this, isSubtreeRoot);
    registered = false;
  }

  private void register(boolean isSubtreeRoot) {
    root.registerNode(this, isSubtreeRoot);
    registered = true;
  }

  /**
   * Sets the parent of this node and handles registration and unregistration of
   * the subtree with the new parent.
   *
   * @param parent The parent value to set, cannot be null.
   * @return {@code true} if the parent was changed, {@code false} otherwise.
   */
  @SuppressWarnings("unchecked") // we rely on our construction doing the right thing
  public boolean setParent(ASTNode parent, Consumer<? extends ASTNode> setter) {
    Objects.requireNonNull(parent);

    // always set the self replacer since the node might have moved inside its
    // parent without changing the parent
    this.selfReplacer = (Consumer<ASTNode>) setter;

    // if the parent doesn't change, nothing has to be done
    if (this.parent == parent) {
      return false;
    }

    // if the roots are the same, no change in registration is necessary
    // this is the normal case for building the AST or moving nodes around
    if (root == parent.root) {
      this.lastParent = this.parent;
      this.parent = parent;

      // when the root node of a newly built subtree that already has the same root
      // references is added to the main tree, only the root node isn't registered yet
      if (!registered) {
        // this node is the root of a subtree if the parent is already registered
        // otherwise its part of a construction process and isn't the root of a subtree
        // as nodes are registered from the bottom up
        register(parent.registered);
      }
    } else {
      // set the parent to the given parent and re-register the subtree in the new
      // root by unregistering and registering in the new root
      this.lastParent = this.parent;
      this.parent = parent;
      changeRootRecursive(parent.root);
    }
    return true;
  }

  private class ChangeRootVisitor extends ASTVoidVisitor {
    private Root rootToSet;

    ChangeRootVisitor(Root rootToSet) {
      this.rootToSet = rootToSet;
    }

    @Override
    public void visitVoid(ASTNode node) {
      node.setRoot(rootToSet, node == ASTNode.this);
    }
  };

  private void changeRootRecursive(Root root) {
    new ChangeRootVisitor(root).visit(this);
  }

  /**
   * Uses the stored replacer function to remove this node from the parent and
   * remove the parent from this node. It does not unregister the
   * subtree but it does detach it.
   *
   * @param replacement The node to replace this node with
   * @return {@code true} if the parent was changed, {@code false} otherwise.
   */
  public boolean replaceBy(ASTNode replacement) {
    if (selfReplacer != null) {
      selfReplacer.accept(replacement);
      return true;
    }
    return false;
  }

  /**
   * Replaces this node in the parent by the given node and unregisters the
   * subtree. This fully removes the node from the tree.
   *
   * @param replacement The node to replace this node with
   * @return {@code true} if the parent was changed, {@code false} otherwise.
   */
  public boolean replaceByAndDelete(ASTNode replacement) {
    if (replaceBy(replacement)) {
      unregisterSubtree();
      return true;
    }
    return false;
  }

  /**
   * Detaches a node from its parent by using the stored self replacer function
   * and also removes the parent from this node. Does not unregister the subtree.
   *
   * @return {@code true} if the node was removed, {@code false} otherwise.
   */
  public boolean detach() {
    // the parent is removed from this node through updateParents()
    return replaceBy(null);
  }

  /**
   * Removes this node in the parent and unregisters the subtree.
   *
   * @return {@code true} if the parent was changed, {@code false} otherwise.
   */
  public boolean detachAndDelete() {
    return replaceByAndDelete(null);
  }

  /**
   * Removes the parent from this node. This is useful if the node has already
   * been (efficiently) removed from the parent.
   */
  public void detachParent() {
    lastParent = parent;
    parent = null;
    selfReplacer = null;
  }

  private class UnregisterVisitor extends ASTVoidVisitor {
    @Override
    public void visitVoid(ASTNode node) {
      node.unregister(node == ASTNode.this);
    }
  };

  /**
   * Detaches the node from the parent, then unregisters this node and all its
   * children from its root.
   */
  public void unregisterSubtree() {
    detachParent();
    new UnregisterVisitor().visit(this);
  }

  /**
   * Swaps two nodes in their parents. Throws if the nodes or their parents are
   * null in which case calling this method is pointless.
   *
   * @param a The first node to swap
   * @param b The second node to swap
   * @return {@code true} if the nodes were swapped, {@code false} otherwise.
   */
  public static boolean swap(ASTNode a, ASTNode b) {
    Objects.requireNonNull(a);
    Objects.requireNonNull(b);
    var bParent = b.getParent();
    var aParent = a.getParent();
    Objects.requireNonNull(aParent);
    Objects.requireNonNull(bParent);
    if (aParent == b || bParent == a) {
      return false;
    }
    var bReplacer = b.selfReplacer;
    a.replaceBy(b);
    bReplacer.accept(a);
    return true;
  }

  /**
   * Adds a newly constructed node to this node as the parent. The node will
   * already have a reference to the current root but will not be registered to it
   * yet.
   *
   * @param <N>    Type of the node for passthrough
   * @param node   The node to add
   * @param setter The setter to replace the node in this parent
   * @return The node itself
   */
  public <N extends ASTNode> N setup(N node, Consumer<? extends N> setter) {
    if (node != null) {
      node.setParent(this, setter);
    }
    return node;
  }

  /**
   * Updates the parents of two nodes where one is replacing the other in this
   * node. Both of them may be null if either the existing value is being removed
   * or a new value is being set.
   *
   * @param <N>         The type of the nodes for pass-through
   * @param currentNode The current node
   * @param newNode     The new node
   * @param setter      The setter to replace the node in this parent (this is
   *                    usually a method reference to a setter method of the
   *                    parent, this node)
   */
  public <N extends ASTNode> void updateParents(
      N currentNode, N newNode, Consumer<? extends N> setter) {
    if (currentNode == newNode && newNode.getParent() == this) {
      return;
    }

    if (currentNode != null) {
      currentNode.detachParent();
    }

    if (newNode != null) {
      newNode.setParent(this, setter);
    }
  }

  public void markTemplate(Template<?> template) {
    this.template = template;
  }

  @Override
  protected abstract ASTNode clone();

  public ASTNode cloneInto(Root root) {
    return root.indexNodes(this::clone);
  }

  @SuppressWarnings("unchecked") // the nodes clone themselves correctly
  public static <N extends ASTNode> N clone(N node) {
    if (node == null) {
      return null;
    }
    N clone;
    if (node.template == null) {
      clone = (N) node.clone();
    } else {
      N replacement = node.template.getReplacement(node);
      clone = replacement == null ? (N) node.clone() : replacement;
    }
    clone.setSourceLocation(node.getSourceLocation());
    return clone;
  }

  public static <N extends ASTNode> Stream<N> clone(ChildNodeList<N> nodes) {
    return nodes == null ? null : nodes.getClonedStream();
  }
}
