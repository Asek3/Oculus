package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class LeftShiftAssignmentExpression extends BinaryExpression {
  public LeftShiftAssignmentExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.LEFT_SHIFT_ASSIGNMENT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitLeftShiftAssignmentExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterLeftShiftAssignmentExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitLeftShiftAssignmentExpression(this);
  }

  @Override
  public LeftShiftAssignmentExpression clone() {
    return new LeftShiftAssignmentExpression(clone(left), clone(right));
  }

  @Override
  public LeftShiftAssignmentExpression cloneInto(Root root) {
    return (LeftShiftAssignmentExpression) super.cloneInto(root);
  }
}
