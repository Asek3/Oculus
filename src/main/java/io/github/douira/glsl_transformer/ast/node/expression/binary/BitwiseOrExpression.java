package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class BitwiseOrExpression extends BinaryExpression {
  public BitwiseOrExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.BITWISE_OR;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitBitwiseOrExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterBitwiseOrExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitBitwiseOrExpression(this);
  }

  @Override
  public BitwiseOrExpression clone() {
    return new BitwiseOrExpression(clone(left), clone(right));
  }

  @Override
  public BitwiseOrExpression cloneInto(Root root) {
    return (BitwiseOrExpression) super.cloneInto(root);
  }
}
