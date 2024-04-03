package io.github.douira.glsl_transformer.ast.node.external_declaration;

import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.transform.ASTBuilder;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public abstract class ExternalDeclaration extends InnerASTNode {
  public ExternalDeclaration() {
    sourceLocation = ASTBuilder.takeSourceLocation();
  }

  public enum ExternalDeclarationType {
    FUNCTION_DEFINITION,
    DECLARATION,
    PRAGMA_DIRECTIVE,
    EXTENSION_DIRECTIVE,
    CUSTOM_DIRECTIVE,
    INCLUDE_DIRECTIVE,
    LAYOUT_DEFAULTS,
    EMPTY_DECLARATION
  }

  public abstract ExternalDeclarationType getExternalDeclarationType();

  public abstract <R> R externalDeclarationAccept(ASTVisitor<R> visitor);

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        visitor.visitExternalDeclaration(this),
        externalDeclarationAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterExternalDeclaration(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitExternalDeclaration(this);
  }

  @Override
  public abstract ExternalDeclaration clone();

  @Override
  public ExternalDeclaration cloneInto(Root root) {
    return (ExternalDeclaration) super.cloneInto(root);
  }
}
