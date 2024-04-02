package io.github.douira.glsl_transformer.ast.node.statement.terminal;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class EmptyStatement extends SemiTerminalStatement {
  public EmptyStatement() {
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.EMPTY;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitEmptyStatement(this);
  }

  @Override
  public EmptyStatement clone() {
    return new EmptyStatement();
  }

  @Override
  public EmptyStatement cloneInto(Root root) {
    return (EmptyStatement) super.cloneInto(root);
  }
}
