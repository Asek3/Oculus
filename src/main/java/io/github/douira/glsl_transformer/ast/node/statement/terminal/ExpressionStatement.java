package io.github.douira.glsl_transformer.ast.node.statement.terminal;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class ExpressionStatement extends SemiTerminalStatement {
  protected Expression expression;

  public ExpressionStatement(Expression expression) {
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
  public StatementType getStatementType() {
    return StatementType.EXPRESSION;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitExpressionStatement(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterExpressionStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitExpressionStatement(this);
  }

  @Override
  public ExpressionStatement clone() {
    return new ExpressionStatement(clone(expression));
  }

  @Override
  public ExpressionStatement cloneInto(Root root) {
    return (ExpressionStatement) super.cloneInto(root);
  }
}
