package io.github.douira.glsl_transformer.ast.node.expression.unary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class DecrementPostfixExpression extends UnaryExpression {
  public DecrementPostfixExpression(Expression expression) {
    super(expression);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.DECREMENT_POSTFIX;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitDecrementPostfixExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterDecrementPostfixExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitDecrementPostfixExpression(this);
  }

  @Override
  public DecrementPostfixExpression clone() {
    return new DecrementPostfixExpression(clone(operand));
  }

  @Override
  public DecrementPostfixExpression cloneInto(Root root) {
    return (DecrementPostfixExpression) super.cloneInto(root);
  }
}
