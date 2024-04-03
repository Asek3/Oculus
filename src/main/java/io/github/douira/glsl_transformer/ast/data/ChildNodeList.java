package io.github.douira.glsl_transformer.ast.data;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * A child list that notifies the given parent of child additions.
 *
 * Implementation of the more complex RemovalProxyArray list isn't necessary
 * because each child notifies its previous parent of the parent change.
 */
public class ChildNodeList<Child extends ASTNode> extends ProxyArrayList<Child> {
  private InnerASTNode parent;

  public ChildNodeList(InnerASTNode parent) {
    this.parent = parent;
  }

  public ChildNodeList(int initialCapacity, InnerASTNode parent) {
    super(initialCapacity);
    this.parent = parent;
  }

  protected ChildNodeList(Collection<? extends Child> c, InnerASTNode parent) {
    super(c, false);
    this.parent = parent;
    for (var child : this) {
      if (child != null) {
        parent.setup(child, makeChildReplacer(this, child));
      }
    }
  }

  @Override
  protected void notifyAddition(Child added) {
    added.setParent(parent, makeChildReplacer(this, added));
  }

  @Override
  protected void notifyRemoval(Child removed) {
    removed.detachParent();
  }

  /**
   * Returns true if the list is empty or contains only null elements.
   *
   * @return true if the list is empty or contains only null elements
   */
  public boolean isNullEmpty() {
    if (isEmpty()) {
      return true;
    }
    for (var child : this) {
      if (child != null) {
        return false;
      }
    }
    return true;
  }

  protected static <Child extends ASTNode> Consumer<Child> makeChildReplacer(ChildNodeList<Child> list, Child child) {
    return newNode -> {
      if (newNode == child) {
        return;
      }
      list.parent.updateParents(child, newNode, makeChildReplacer(list, newNode));
      if (newNode == null) {
        list.remove(child);
      } else {
        list.set(list.indexOf(child), newNode);
      }
    };
  }

  public static <Child extends ASTNode> ChildNodeList<Child> collect(
      Stream<Child> stream, InnerASTNode parent) {
    if (stream == null) {
      return null;
    }
    return stream.collect(
        () -> new ChildNodeList<Child>(parent),
        (list, child) -> {
          // this null check is necessary to exluce nulls from the stream that were
          // introduced by, for example, the line directive returning null from its visit
          // method
          if (child != null) {
            // parent.setup(child, makeChildReplacer(list, child));
            parent.setup(child, null);
          }
          list.add(child);
        },
        ChildNodeList::addAll);
  }

  public Stream<Child> getClonedStream() {
    return (Stream<Child>) stream().map(node -> ASTNode.clone(node));
  }
}
