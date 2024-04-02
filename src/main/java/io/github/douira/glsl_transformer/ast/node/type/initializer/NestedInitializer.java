package io.github.douira.glsl_transformer.ast.node.type.initializer;

import java.util.stream.Stream;

import io.github.douira.glsl_transformer.ast.data.ChildNodeList;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class NestedInitializer extends Initializer {
  protected ChildNodeList<Initializer> initializers;

  public NestedInitializer(Stream<Initializer> initializers) {
    this.initializers = ChildNodeList.collect(initializers, this);
  }

  public NestedInitializer() {
    this.initializers = new ChildNodeList<>(this);
  }

  public ChildNodeList<Initializer> getInitializers() {
    return initializers;
  }

  @Override
  public InitializerType getInitializerType() {
    return InitializerType.NESTED;
  }

  @Override
  public <R> R initializerAccept(ASTVisitor<R> visitor) {
    return visitor.visitNestedInitializer(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterNestedInitializer(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitNestedInitializer(this);
  }

  @Override
  public NestedInitializer clone() {
    return new NestedInitializer(clone(initializers));
  }

  @Override
  public NestedInitializer cloneInto(Root root) {
    return (NestedInitializer) super.cloneInto(root);
  }
}
