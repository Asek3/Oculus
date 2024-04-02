package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class BitwiseAndAssignmentExpression extends BinaryExpression {
  public BitwiseAndAssignmentExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.BITWISE_AND_ASSIGNMENT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitBitwiseAndAssignmentExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterBitwiseAndAssignmentExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitBitwiseAndAssignmentExpression(this);
  }

  @Override
  public BitwiseAndAssignmentExpression clone() {
    return new BitwiseAndAssignmentExpression(clone(left), clone(right));
  }

  @Override
  public BitwiseAndAssignmentExpression cloneInto(Root root) {
    return (BitwiseAndAssignmentExpression) super.cloneInto(root);
  }
}
