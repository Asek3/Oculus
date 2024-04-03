package io.github.douira.glsl_transformer.ast.node.statement.selection;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.statement.*;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class SwitchStatement extends Statement {
  protected Expression expression;
  protected CompoundStatement statement;

  public SwitchStatement(Expression expression, CompoundStatement statement) {
    this.expression = setup(expression, this::setExpression);
    this.statement = setup(statement, this::setStatement);
  }

  public Expression getExpression() {
    return expression;
  }

  public void setExpression(Expression expression) {
    updateParents(this.expression, expression, this::setExpression);
    this.expression = expression;
  }

  public CompoundStatement getStatement() {
    return statement;
  }

  public void setStatement(CompoundStatement statement) {
    updateParents(this.statement, statement, this::setStatement);
    this.statement = statement;
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.SWITCH;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitSwitchStatement(this);
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        super.accept(visitor),
        statementAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterSwitchStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitSwitchStatement(this);
  }

  @Override
  public SwitchStatement clone() {
    return new SwitchStatement(clone(expression), clone(statement));
  }

  @Override
  public SwitchStatement cloneInto(Root root) {
    return (SwitchStatement) super.cloneInto(root);
  }
}
