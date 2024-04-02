package io.github.douira.glsl_transformer.ast.node.statement.terminal;

import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public abstract class TerminalStatement extends Statement {
  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        super.accept(visitor),
        visitor.visitTerminalStatement(this),
        statementAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    // terminal statements have no children
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    // terminal statements have no children
  }

  @Override
  public abstract TerminalStatement clone();

  @Override
  public TerminalStatement cloneInto(Root root) {
    return (TerminalStatement) super.cloneInto(root);
  }
}
