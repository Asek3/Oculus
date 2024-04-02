package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class AdditionAssignmentExpression extends BinaryExpression {
  public AdditionAssignmentExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.ADDITION_ASSIGNMENT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitAdditionAssignmentExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterAdditionAssignmentExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitAdditionAssignmentExpression(this);
  }

  @Override
  public AdditionAssignmentExpression clone() {
    return new AdditionAssignmentExpression(clone(left), clone(right));
  }

  @Override
  public AdditionAssignmentExpression cloneInto(Root root) {
    return (AdditionAssignmentExpression) super.cloneInto(root);
  }
}
