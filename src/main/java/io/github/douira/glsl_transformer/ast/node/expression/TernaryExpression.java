package io.github.douira.glsl_transformer.ast.node.expression;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public abstract class TernaryExpression extends Expression {
  protected Expression first;
  protected Expression second;
  protected Expression third;

  public TernaryExpression(Expression first, Expression second, Expression third) {
    this.first = setup(first, this::setFirst);
    this.second = setup(second, this::setSecond);
    this.third = setup(third, this::setThird);
  }

  public Expression getFirst() {
    return first;
  }

  public void setFirst(Expression first) {
    updateParents(this.first, first, this::setFirst);
    this.first = first;
  }

  public Expression getSecond() {
    return second;
  }

  public void setSecond(Expression second) {
    updateParents(this.second, second, this::setSecond);
    this.second = second;
  }

  public Expression getThird() {
    return third;
  }

  public void setThird(Expression third) {
    updateParents(this.third, third, this::setThird);
    this.third = third;
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        super.accept(visitor),
        visitor.visitTernaryExpression(this),
        expressionAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterTernaryExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitTernaryExpression(this);
  }

  @Override
  public abstract TernaryExpression clone();

  @Override
  public TernaryExpression cloneInto(Root root) {
    return (TernaryExpression) super.cloneInto(root);
  }
}
