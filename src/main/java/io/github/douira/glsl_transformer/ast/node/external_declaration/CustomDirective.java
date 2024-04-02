package io.github.douira.glsl_transformer.ast.node.external_declaration;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class CustomDirective extends ExternalDeclaration {
  private String content;

  public CustomDirective(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    getRoot().unregisterFastRename(this);
    this.content = content;
    getRoot().registerFastRename(this);
  }

  @Override
  public ExternalDeclarationType getExternalDeclarationType() {
    return ExternalDeclarationType.CUSTOM_DIRECTIVE;
  }

  @Override
  public <R> R externalDeclarationAccept(ASTVisitor<R> visitor) {
    return visitor.visitCustomDirective(this);
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
  public CustomDirective clone() {
    return new CustomDirective(content);
  }

  @Override
  public CustomDirective cloneInto(Root root) {
    return (CustomDirective) super.cloneInto(root);
  }
}
