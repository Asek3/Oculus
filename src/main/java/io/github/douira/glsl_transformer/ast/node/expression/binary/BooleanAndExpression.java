package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class BooleanAndExpression extends BinaryExpression {
  public BooleanAndExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.BOOLEAN_AND;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitBooleanAndExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterBooleanAndExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitBooleanAndExpression(this);
  }

  @Override
  public BooleanAndExpression clone() {
    return new BooleanAndExpression(clone(left), clone(right));
  }

  @Override
  public BooleanAndExpression cloneInto(Root root) {
    return (BooleanAndExpression) super.cloneInto(root);
  }
}
