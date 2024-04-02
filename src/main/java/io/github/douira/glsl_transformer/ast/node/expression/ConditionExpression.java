package io.github.douira.glsl_transformer.ast.node.expression;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class ConditionExpression extends TernaryExpression {
  public ConditionExpression(Expression condition, Expression trueExpression, Expression falseExpression) {
    super(condition, trueExpression, falseExpression);
  }

  public Expression getCondition() {
    return first;
  }

  public Expression getTrueExpression() {
    return second;
  }

  public Expression getFalseExpression() {
    return third;
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.CONDITION;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitConditionExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterConditionExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitConditionExpression(this);
  }

  @Override
  public ConditionExpression clone() {
    return new ConditionExpression(clone(first), clone(second), clone(third));
  }

  @Override
  public ConditionExpression cloneInto(Root root) {
    return (ConditionExpression) super.cloneInto(root);
  }
}
