package io.github.douira.glsl_transformer.ast.node.type.initializer;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class ExpressionInitializer extends Initializer {
  protected Expression expression;

  public ExpressionInitializer(Expression expression) {
    this.expression = setup(expression, this::setExpression);
  }

  public Expression getExpression() {
    return expression;
  }

  public void setExpression(Expression expression) {
    updateParents(this.expression, expression, this::setExpression);
    this.expression = expression;
  }

  @Override
  public InitializerType getInitializerType() {
    return InitializerType.EXPRESSION;
  }

  @Override
  public <R> R initializerAccept(ASTVisitor<R> visitor) {
    return visitor.visitExpressionInitializer(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterExpressionInitializer(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitExpressionInitializer(this);
  }

  @Override
  public ExpressionInitializer clone() {
    return new ExpressionInitializer(clone(expression));
  }

  @Override
  public ExpressionInitializer cloneInto(Root root) {
    return (ExpressionInitializer) super.cloneInto(root);
  }
}
