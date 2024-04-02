package io.github.douira.glsl_transformer.ast.node.external_declaration;

import io.github.douira.glsl_transformer.ast.node.declaration.Declaration;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class DeclarationExternalDeclaration extends ExternalDeclaration {
  protected Declaration declaration;

  public DeclarationExternalDeclaration(Declaration declaration) {
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
  public ExternalDeclarationType getExternalDeclarationType() {
    return ExternalDeclarationType.DECLARATION;
  }

  @Override
  public <R> R externalDeclarationAccept(ASTVisitor<R> visitor) {
    return visitor.visitDeclarationExternalDeclaration(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterDeclarationExternalDeclaration(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitDeclarationExternalDeclaration(this);
  }

  @Override
  public DeclarationExternalDeclaration clone() {
    return new DeclarationExternalDeclaration(clone(declaration));
  }

  @Override
  public DeclarationExternalDeclaration cloneInto(Root root) {
    return (DeclarationExternalDeclaration) super.cloneInto(root);
  }
}
