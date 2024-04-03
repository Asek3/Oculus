package io.github.douira.glsl_transformer.ast.node.statement.terminal;

import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public abstract class CaseLabelStatement extends Statement {
  public enum CaseLabelType {
    CASE,
    DEFAULT
  }

  public abstract CaseLabelType getCaseLabelType();

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        super.accept(visitor),
        visitor.visitCaseLabelStatement(this),
        statementAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterCaseLabelStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitCaseLabelStatement(this);
  }

  @Override
  public abstract CaseLabelStatement clone();

  @Override
  public CaseLabelStatement cloneInto(Root root) {
    return (CaseLabelStatement) super.cloneInto(root);
  }
}
