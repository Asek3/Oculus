package io.github.douira.glsl_transformer.ast.node.external_declaration;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class EmptyDeclaration extends ExternalDeclaration {
  @Override
  public ExternalDeclarationType getExternalDeclarationType() {
    return ExternalDeclarationType.EMPTY_DECLARATION;
  }

  @Override
  public <R> R externalDeclarationAccept(ASTVisitor<R> visitor) {
    return visitor.visitEmptyDeclaration(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    // terminal nodes have no children
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    // terminal nodes have no children
  }

  @Override
  public EmptyDeclaration clone() {
    return new EmptyDeclaration();
  }

  @Override
  public EmptyDeclaration cloneInto(Root root) {
    return (EmptyDeclaration) super.cloneInto(root);
  }
}
