package io.github.douira.glsl_transformer.ast.node.external_declaration;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class IncludeDirective extends ExternalDeclaration {
  private String content;
  public boolean isAngleBrackets;

  public IncludeDirective(String content, boolean isAngleBrackets) {
    this.content = content;
    this.isAngleBrackets = isAngleBrackets;
  }

  public IncludeDirective(String content) {
    this(content, false);
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
    return ExternalDeclarationType.INCLUDE_DIRECTIVE;
  }

  @Override
  public <R> R externalDeclarationAccept(ASTVisitor<R> visitor) {
    return visitor.visitIncludeDirective(this);
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
  public IncludeDirective clone() {
    return new IncludeDirective(content, isAngleBrackets);
  }

  @Override
  public IncludeDirective cloneInto(Root root) {
    return (IncludeDirective) super.cloneInto(root);
  }
}
