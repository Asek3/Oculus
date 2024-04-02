package io.github.douira.glsl_transformer.ast.node.expression.unary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class BitwiseNotExpression extends UnaryExpression {
  public BitwiseNotExpression(Expression expression) {
    super(expression);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.BITWISE_NOT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitBitwiseNotExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterBitwiseNotExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitBitwiseNotExpression(this);
  }

  @Override
  public BitwiseNotExpression clone() {
    return new BitwiseNotExpression(clone(operand));
  }

  @Override
  public BitwiseNotExpression cloneInto(Root root) {
    return (BitwiseNotExpression) super.cloneInto(root);
  }
}
