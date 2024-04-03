package io.github.douira.glsl_transformer.ast.node.expression;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public abstract class TerminalExpression extends Expression {
  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        super.accept(visitor),
        visitor.visitTerminalExpression(this),
        expressionAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    // terminal expressions have no children
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    // terminal expressions have no children
  }

  @Override
  public abstract TerminalExpression clone();

  @Override
  public TerminalExpression cloneInto(Root root) {
    return (TerminalExpression) super.cloneInto(root);
  }
}
