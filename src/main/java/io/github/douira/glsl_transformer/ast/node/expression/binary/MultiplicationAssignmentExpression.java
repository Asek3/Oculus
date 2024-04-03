package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class MultiplicationAssignmentExpression extends BinaryExpression {
  public MultiplicationAssignmentExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.MULTIPLICATION_ASSIGNMENT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitMultiplicationAssignmentExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterMultiplicationAssignmentExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitMultiplicationAssignmentExpression(this);
  }

  @Override
  public MultiplicationAssignmentExpression clone() {
    return new MultiplicationAssignmentExpression(clone(left), clone(right));
  }

  @Override
  public MultiplicationAssignmentExpression cloneInto(Root root) {
    return (MultiplicationAssignmentExpression) super.cloneInto(root);
  }
}
