package io.github.douira.glsl_transformer.ast.node.statement.selection;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.node.statement.terminal.SemiTerminalStatement;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class SelectionStatement extends SemiTerminalStatement {
  protected Expression condition;
  protected Statement ifTrue;
  protected Statement ifFalse; // TODO: nullable

  public SelectionStatement(Expression condition, Statement ifTrue, Statement ifFalse) {
    this.condition = setup(condition, this::setCondition);
    this.ifTrue = setup(ifTrue, this::setIfTrue);
    this.ifFalse = setup(ifFalse, this::setIfFalse);
  }

  public SelectionStatement(Expression condition, Statement ifTrue) {
    this.condition = setup(condition, this::setCondition);
    this.ifTrue = setup(ifTrue, this::setIfTrue);
  }

  public Expression getCondition() {
    return condition;
  }

  public void setCondition(Expression condition) {
    updateParents(this.condition, condition, this::setCondition);
    this.condition = condition;
  }

  public Statement getIfTrue() {
    return ifTrue;
  }

  public void setIfTrue(Statement ifTrue) {
    updateParents(this.ifTrue, ifTrue, this::setIfTrue);
    this.ifTrue = ifTrue;
  }

  public Statement getIfFalse() {
    return ifFalse;
  }

  public void setIfFalse(Statement ifFalse) {
    updateParents(this.ifFalse, ifFalse, this::setIfFalse);
    this.ifFalse = ifFalse;
  }

  public boolean hasIfFalse() {
    return ifFalse != null;
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.SELECTION;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitSelectionStatement(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterSelectionStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitSelectionStatement(this);
  }

  @Override
  public SelectionStatement clone() {
    return new SelectionStatement(clone(condition), clone(ifTrue), clone(ifFalse));
  }

  @Override
  public SelectionStatement cloneInto(Root root) {
    return (SelectionStatement) super.cloneInto(root);
  }
}
