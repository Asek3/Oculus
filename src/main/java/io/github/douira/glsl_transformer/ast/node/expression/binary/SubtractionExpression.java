package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class SubtractionExpression extends BinaryExpression {
  public SubtractionExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.SUBTRACTION;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitSubtractionExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterSubtractionExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitSubtractionExpression(this);
  }

  @Override
  public SubtractionExpression clone() {
    return new SubtractionExpression(clone(left), clone(right));
  }

  @Override
  public SubtractionExpression cloneInto(Root root) {
    return (SubtractionExpression) super.cloneInto(root);
  }
}
