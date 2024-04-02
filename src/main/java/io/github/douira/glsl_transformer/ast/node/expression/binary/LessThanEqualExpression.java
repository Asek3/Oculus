package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class LessThanEqualExpression extends BinaryExpression {
  public LessThanEqualExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.LESS_THAN_EQUAL;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitLessThanEqualExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterLessThanEqualExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitLessThanEqualExpression(this);
  }

  @Override
  public LessThanEqualExpression clone() {
    return new LessThanEqualExpression(clone(left), clone(right));
  }

  @Override
  public LessThanEqualExpression cloneInto(Root root) {
    return (LessThanEqualExpression) super.cloneInto(root);
  }
}
