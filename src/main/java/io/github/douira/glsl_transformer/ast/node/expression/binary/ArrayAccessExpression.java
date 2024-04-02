package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class ArrayAccessExpression extends BinaryExpression {
  public ArrayAccessExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.ARRAY_ACCESS;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitArrayAccessExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterArrayAccessExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitArrayAccessExpression(this);
  }

  @Override
  public ArrayAccessExpression clone() {
    return new ArrayAccessExpression(clone(left), clone(right));
  }

  @Override
  public ArrayAccessExpression cloneInto(Root root) {
    return (ArrayAccessExpression) super.cloneInto(root);
  }
}
