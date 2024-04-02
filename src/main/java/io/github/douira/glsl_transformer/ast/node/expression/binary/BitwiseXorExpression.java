package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class BitwiseXorExpression extends BinaryExpression {
  public BitwiseXorExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.BITWISE_XOR;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitBitwiseXorExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterBitwiseXorExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitBitwiseXorExpression(this);
  }

  @Override
  public BitwiseXorExpression clone() {
    return new BitwiseXorExpression(clone(left), clone(right));
  }

  @Override
  public BitwiseXorExpression cloneInto(Root root) {
    return (BitwiseXorExpression) super.cloneInto(root);
  }
}
