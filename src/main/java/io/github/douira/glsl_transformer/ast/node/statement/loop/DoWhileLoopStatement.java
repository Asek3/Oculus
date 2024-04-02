package io.github.douira.glsl_transformer.ast.node.statement.loop;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class DoWhileLoopStatement extends ConditionLoopStatement {
  public DoWhileLoopStatement(Statement statement, Expression condition) {
    super(statement, condition);
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.DO_WHILE_LOOP;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitDoWhileLoopStatement(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterDoWhileLoopStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitDoWhileLoopStatement(this);
  }

  @Override
  public DoWhileLoopStatement clone() {
    return new DoWhileLoopStatement(clone(statement), clone(condition));
  }

  @Override
  public DoWhileLoopStatement cloneInto(Root root) {
    return (DoWhileLoopStatement) super.cloneInto(root);
  }
}
