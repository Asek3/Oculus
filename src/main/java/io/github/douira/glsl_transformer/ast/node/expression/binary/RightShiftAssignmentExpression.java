package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class RightShiftAssignmentExpression extends BinaryExpression {
  public RightShiftAssignmentExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.RIGHT_SHIFT_ASSIGNMENT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitRightShiftAssignmentExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterRightShiftAssignmentExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitRightShiftAssignmentExpression(this);
  }

  @Override
  public RightShiftAssignmentExpression clone() {
    return new RightShiftAssignmentExpression(clone(left), clone(right));
  }

  @Override
  public RightShiftAssignmentExpression cloneInto(Root root) {
    return (RightShiftAssignmentExpression) super.cloneInto(root);
  }
}
