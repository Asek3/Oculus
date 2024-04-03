package io.github.douira.glsl_transformer.ast.node.statement.terminal;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class ContinueStatement extends TerminalStatement {
  public ContinueStatement() {
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.CONTINUE;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitContinueStatement(this);
  }

  @Override
  public ContinueStatement clone() {
    return new ContinueStatement();
  }

  @Override
  public ContinueStatement cloneInto(Root root) {
    return (ContinueStatement) super.cloneInto(root);
  }
}
