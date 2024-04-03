package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class RightShiftExpression extends BinaryExpression {
  public RightShiftExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.SHIFT_RIGHT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitRightShiftExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterRightShiftExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitRightShiftExpression(this);
  }

  @Override
  public RightShiftExpression clone() {
    return new RightShiftExpression(clone(left), clone(right));
  }

  @Override
  public RightShiftExpression cloneInto(Root root) {
    return (RightShiftExpression) super.cloneInto(root);
  }
}
