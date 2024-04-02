package io.github.douira.glsl_transformer.ast.node.external_declaration;

import io.github.douira.glsl_transformer.GLSLLexer;
import io.github.douira.glsl_transformer.ast.data.TokenTyped;
import io.github.douira.glsl_transformer.ast.data.TypeUtil;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;
import repack.antlr.v4.runtime.Token;

public class ExtensionDirective extends ExternalDeclaration {
  public enum ExtensionBehavior implements TokenTyped {
    DEBUG(GLSLLexer.NR_REQUIRE),
    ENABLE(GLSLLexer.NR_ENABLE),
    WARN(GLSLLexer.NR_WARN),
    DISABLE(GLSLLexer.NR_DISABLE);

    public final int tokenType;

    private ExtensionBehavior(int tokenType) {
      this.tokenType = tokenType;
    }

    @Override
    public int getTokenType() {
      return tokenType;
    }

    public static ExtensionBehavior fromToken(Token token) {
      return TypeUtil.enumFromToken(ExtensionBehavior.values(), token);
    }
  }

  private String name;
  public ExtensionBehavior behavior; // TODO: nullable

  public ExtensionDirective(String name, ExtensionBehavior behavior) {
    this.name = name;
    this.behavior = behavior;
  }

  public ExtensionDirective(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    getRoot().unregisterFastRename(this);
    this.name = name;
    getRoot().registerFastRename(this);
  }

  @Override
  public ExternalDeclarationType getExternalDeclarationType() {
    return ExternalDeclarationType.EXTENSION_DIRECTIVE;
  }

  @Override
  public <R> R externalDeclarationAccept(ASTVisitor<R> visitor) {
    return visitor.visitExtensionDirective(this);
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
  public ExtensionDirective clone() {
    return new ExtensionDirective(name, behavior);
  }

  @Override
  public ExtensionDirective cloneInto(Root root) {
    return (ExtensionDirective) super.cloneInto(root);
  }
}
