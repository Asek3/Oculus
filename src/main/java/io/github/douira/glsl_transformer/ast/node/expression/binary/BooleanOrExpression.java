package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class BooleanOrExpression extends BinaryExpression {
  public BooleanOrExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.BOOLEAN_OR;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitBooleanOrExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterBooleanOrExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitBooleanOrExpression(this);
  }

  @Override
  public BooleanOrExpression clone() {
    return new BooleanOrExpression(clone(left), clone(right));
  }

  @Override
  public BooleanOrExpression cloneInto(Root root) {
    return (BooleanOrExpression) super.cloneInto(root);
  }
}
