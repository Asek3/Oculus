package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class GreaterThanExpression extends BinaryExpression {
  public GreaterThanExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.GREATER_THAN;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitGreaterThanExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterGreaterThanExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitGreaterThanExpression(this);
  }

  @Override
  public GreaterThanExpression clone() {
    return new GreaterThanExpression(clone(left), clone(right));
  }

  @Override
  public GreaterThanExpression cloneInto(Root root) {
    return (GreaterThanExpression) super.cloneInto(root);
  }
}
