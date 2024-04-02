package io.github.douira.glsl_transformer.ast.node;

import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.node.type.FullySpecifiedType;
import io.github.douira.glsl_transformer.ast.node.type.initializer.Initializer;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class IterationConditionInitializer extends InnerASTNode {
  protected FullySpecifiedType type;
  protected Identifier name;
  protected Initializer initializer;

  public IterationConditionInitializer(FullySpecifiedType type, Identifier name, Initializer initializer) {
    this.type = setup(type, this::setType);
    this.name = setup(name, this::setName);
    this.initializer = setup(initializer, this::setInitializer);
  }

  public FullySpecifiedType getType() {
    return type;
  }

  public void setType(FullySpecifiedType type) {
    updateParents(this.type, type, this::setType);
    this.type = type;
  }

  public Identifier getName() {
    return name;
  }

  public void setName(Identifier name) {
    updateParents(this.name, name, this::setName);
    this.name = name;
  }

  public Initializer getInitializer() {
    return initializer;
  }

  public void setInitializer(Initializer initializer) {
    updateParents(this.initializer, initializer, this::setInitializer);
    this.initializer = initializer;
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitIterationConditionInitializer(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterIterationConditionInitializer(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitIterationConditionInitializer(this);
  }

  @Override
  public IterationConditionInitializer clone() {
    return new IterationConditionInitializer(clone(type), clone(name), clone(initializer));
  }

  @Override
  public IterationConditionInitializer cloneInto(Root root) {
    return (IterationConditionInitializer) super.cloneInto(root);
  }
}
