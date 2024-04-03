package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class GreaterThanEqualExpression extends BinaryExpression {
  public GreaterThanEqualExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.GREATER_THAN_EQUAL;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitGreaterThanEqualExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterGreaterThanEqualExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitGreaterThanEqualExpression(this);
  }

  @Override
  public GreaterThanEqualExpression clone() {
    return new GreaterThanEqualExpression(clone(left), clone(right));
  }

  @Override
  public GreaterThanEqualExpression cloneInto(Root root) {
    return (GreaterThanEqualExpression) super.cloneInto(root);
  }
}
