package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class DivisionAssignmentExpression extends BinaryExpression {
  public DivisionAssignmentExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.DIVISION_ASSIGNMENT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitDivisionAssignmentExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterDivisionAssignmentExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitDivisionAssignmentExpression(this);
  }

  @Override
  public DivisionAssignmentExpression clone() {
    return new DivisionAssignmentExpression(clone(left), clone(right));
  }

  @Override
  public DivisionAssignmentExpression cloneInto(Root root) {
    return (DivisionAssignmentExpression) super.cloneInto(root);
  }
}
