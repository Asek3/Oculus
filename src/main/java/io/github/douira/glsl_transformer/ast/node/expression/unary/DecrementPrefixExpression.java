package io.github.douira.glsl_transformer.ast.node.expression.unary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class DecrementPrefixExpression extends UnaryExpression {
  public DecrementPrefixExpression(Expression expression) {
    super(expression);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.DECREMENT_PREFIX;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitDecrementPrefixExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterDecrementPrefixExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitDecrementPrefixExpression(this);
  }

  @Override
  public DecrementPrefixExpression clone() {
    return new DecrementPrefixExpression(clone(operand));
  }

  @Override
  public DecrementPrefixExpression cloneInto(Root root) {
    return (DecrementPrefixExpression) super.cloneInto(root);
  }
}
