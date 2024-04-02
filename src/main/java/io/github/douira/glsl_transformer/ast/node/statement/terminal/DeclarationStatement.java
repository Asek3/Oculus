package io.github.douira.glsl_transformer.ast.node.statement.terminal;

import io.github.douira.glsl_transformer.ast.node.declaration.Declaration;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class DeclarationStatement extends SemiTerminalStatement {
  protected Declaration declaration;

  public DeclarationStatement(Declaration declaration) {
    this.declaration = setup(declaration, this::setDeclaration);
  }

  public Declaration getDeclaration() {
    return declaration;
  }

  public void setDeclaration(Declaration declaration) {
    updateParents(this.declaration, declaration, this::setDeclaration);
    this.declaration = declaration;
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.DECLARATION;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitDeclarationStatement(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterDeclarationStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitDeclarationStatement(this);
  }

  @Override
  public DeclarationStatement clone() {
    return new DeclarationStatement(clone(declaration));
  }

  @Override
  public DeclarationStatement cloneInto(Root root) {
    return (DeclarationStatement) super.cloneInto(root);
  }
}
