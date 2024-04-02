package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class SubtractionAssignmentExpression extends BinaryExpression {
  public SubtractionAssignmentExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.SUBTRACTION_ASSIGNMENT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitSubtractionAssignmentExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterSubtractionAssignmentExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitSubtractionAssignmentExpression(this);
  }

  @Override
  public SubtractionAssignmentExpression clone() {
    return new SubtractionAssignmentExpression(clone(left), clone(right));
  }

  @Override
  public SubtractionAssignmentExpression cloneInto(Root root) {
    return (SubtractionAssignmentExpression) super.cloneInto(root);
  }
}
