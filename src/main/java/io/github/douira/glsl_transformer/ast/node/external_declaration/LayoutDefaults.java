package io.github.douira.glsl_transformer.ast.node.external_declaration;

import repack.antlr.v4.runtime.Token;

import io.github.douira.glsl_transformer.GLSLLexer;
import io.github.douira.glsl_transformer.ast.data.*;
import io.github.douira.glsl_transformer.ast.node.type.qualifier.LayoutQualifier;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class LayoutDefaults extends ExternalDeclaration {
  public enum LayoutMode implements TokenTyped {
    UNIFORM(GLSLLexer.UNIFORM),
    IN(GLSLLexer.IN),
    OUT(GLSLLexer.OUT),
    BUFFER(GLSLLexer.BUFFER);

    public final int tokenType;

    private LayoutMode(int tokenType) {
      this.tokenType = tokenType;
    }

    @Override
    public int getTokenType() {
      return tokenType;
    }

    public static LayoutMode fromToken(Token token) {
      return TypeUtil.enumFromToken(LayoutMode.values(), token);
    }
  }

  protected LayoutQualifier qualifier;
  public LayoutMode mode;

  public LayoutDefaults(LayoutQualifier qualifier, LayoutMode mode) {
    this.qualifier = setup(qualifier, this::setQualifier);
    this.mode = mode;
  }

  public LayoutQualifier getQualifier() {
    return qualifier;
  }

  public void setQualifier(LayoutQualifier qualifier) {
    updateParents(this.qualifier, qualifier, this::setQualifier);
    this.qualifier = qualifier;
  }

  @Override
  public ExternalDeclarationType getExternalDeclarationType() {
    return ExternalDeclarationType.LAYOUT_DEFAULTS;
  }

  @Override
  public <R> R externalDeclarationAccept(ASTVisitor<R> visitor) {
    return visitor.visitLayoutDefaults(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterLayoutDefaults(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitLayoutDefaults(this);
  }

  @Override
  public LayoutDefaults clone() {
    return new LayoutDefaults(clone(qualifier), mode);
  }

  @Override
  public LayoutDefaults cloneInto(Root root) {
    return (LayoutDefaults) super.cloneInto(root);
  }
}
