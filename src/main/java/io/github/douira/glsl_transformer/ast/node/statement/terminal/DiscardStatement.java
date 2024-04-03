package io.github.douira.glsl_transformer.ast.node.statement.terminal;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class DiscardStatement extends TerminalStatement {
  public DiscardStatement() {
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.DISCARD;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitDiscardStatement(this);
  }

  @Override
  public DiscardStatement clone() {
    return new DiscardStatement();
  }

  @Override
  public DiscardStatement cloneInto(Root root) {
    return (DiscardStatement) super.cloneInto(root);
  }
}
