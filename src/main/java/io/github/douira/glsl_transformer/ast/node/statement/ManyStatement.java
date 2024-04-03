package io.github.douira.glsl_transformer.ast.node.statement;

import java.util.stream.Stream;

import io.github.douira.glsl_transformer.ast.data.ChildNodeList;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ListNode;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public abstract class ManyStatement extends Statement implements ListNode<Statement> {
  protected ChildNodeList<Statement> statements;

  public ManyStatement(Stream<Statement> statements) {
    this.statements = ChildNodeList.collect(statements, this);
  }

  @Override
  public ChildNodeList<Statement> getChildren() {
    return statements;
  }

  public ChildNodeList<Statement> getStatements() {
    return statements;
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        super.accept(visitor),
        visitor.visitManyStatement(this),
        statementAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterManyStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitManyStatement(this);
  }

  @Override
  public abstract ManyStatement clone();

  @Override
  public ManyStatement cloneInto(Root root) {
    return (ManyStatement) super.cloneInto(root);
  }
}
