package io.github.douira.glsl_transformer.ast.node.statement;

import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.transform.ASTBuilder;
import io.github.douira.glsl_transformer.ast.traversal.*;

public abstract class Statement extends InnerASTNode {
  public Statement() {
    sourceLocation = ASTBuilder.takeSourceLocation();
  }

  public enum StatementType {
    COMPOUND(StructureType.MANY), // many-ary
    DECLARATION(StructureType.SEMI_TERMINAL), // semi-terminal
    EXPRESSION(StructureType.SEMI_TERMINAL), // semi-terminal
    EMPTY(StructureType.TERMINAL), // terminal
    SELECTION(StructureType.MANY), // many-ary (if-else)
    SWITCH(StructureType.UNARY), // unary (nested compound statement)
    CASE(StructureType.SEMI_TERMINAL), // semi-terminal
    DEFAULT(StructureType.TERMINAL), // terminal
    FOR_LOOP(StructureType.UNARY), // unary
    WHILE_LOOP(StructureType.UNARY), // unary
    DO_WHILE_LOOP(StructureType.UNARY), // unary
    CONTINUE(StructureType.TERMINAL), // terminal
    BREAK(StructureType.TERMINAL), // terminal
    RETURN(StructureType.SEMI_TERMINAL), // semi-terminal
    DISCARD(StructureType.TERMINAL), // terminal
    DEMOTE(StructureType.TERMINAL), // terminal
    IGNORE_INTERSECTION(StructureType.TERMINAL), // terminal
    TERMINATE_RAY(StructureType.TERMINAL); // terminal

    public enum StructureType {
      SEMI_TERMINAL, // no nested statements but not a terminal AST node
      TERMINAL, // no nested statements or AST nodes
      UNARY, // one nested statement
      MANY // a list of nested statements
    }

    public final StructureType structureType;

    StatementType(StructureType structureType) {
      this.structureType = structureType;
    }
  }

  public abstract StatementType getStatementType();

  public abstract <R> R statementAccept(ASTVisitor<R> visitor);

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitStatement(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitStatement(this);
  }

  @Override
  public abstract Statement clone();

  @Override
  public Statement cloneInto(Root root) {
    return (Statement) super.cloneInto(root);
  }
}
