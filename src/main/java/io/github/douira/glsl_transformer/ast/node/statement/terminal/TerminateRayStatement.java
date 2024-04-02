package io.github.douira.glsl_transformer.ast.node.statement.terminal;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class TerminateRayStatement extends TerminalStatement {
  public TerminateRayStatement() {
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.TERMINATE_RAY;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitTerminateRayStatement(this);
  }

  @Override
  public TerminateRayStatement clone() {
    return new TerminateRayStatement();
  }

  @Override
  public TerminateRayStatement cloneInto(Root root) {
    return (TerminateRayStatement) super.cloneInto(root);
  }
}
