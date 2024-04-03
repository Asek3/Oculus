package io.github.douira.glsl_transformer.ast.print;

import io.github.douira.glsl_transformer.GLSLLexer;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.print.token.*;
import io.github.douira.glsl_transformer.ast.transform.SourceLocation;
import io.github.douira.glsl_transformer.ast.traversal.ASTListenerVisitor;
import io.github.douira.glsl_transformer.token_filter.TokenChannel;

import java.util.List;

public abstract class ASTPrinterBase extends ASTListenerVisitor<Void> {
  private PrintToken lastToken;
  private ASTNode currentNode;
  private TokenProcessor tokenProcessor;

  protected ASTPrinterBase(TokenProcessor tokenProcessor) {
    this.tokenProcessor = tokenProcessor;
  }

  protected String generateString() {
    return tokenProcessor.generateString();
  }

  protected void appendToken(PrintToken token) {
    tokenProcessor.appendToken(token);
  }

  public void replaceToken(PrintToken replacement) {
    lastToken = replacement;
  }

  protected void emitToken(PrintToken token) {
    token.setSource(currentNode);
    if (token instanceof ReplaceToken replaceToken) {
      if (lastToken == null) {
        return;
      }
      replaceToken.replace(lastToken, this);
      return;
    }

    if (lastToken != null) {
      appendToken(lastToken);
    }
    lastToken = token;
  }

  protected void finalizePrinting() {
    if (lastToken != null) {
      appendToken(lastToken);
      lastToken = null;
    }
  }

  protected void emitTokens(PrintToken... tokens) {
    for (PrintToken t : tokens) {
      emitToken(t);
    }
  }

  protected void emitLiteral(TokenRole role, String literal) {
    emitToken(new LiteralToken(role, literal));
  }

  protected void emitLiteral(String literal) {
    emitToken(new LiteralToken(literal));
  }

  protected void emitLiteralSafe(String literal) {
    if (literal != null) {
      emitLiteral(literal);
    }
  }

  protected void emitLiterals(TokenRole role, String... literals) {
    for (String l : literals) {
      emitLiteral(role, l);
    }
  }

  protected void emitLiterals(String... literals) {
    emitLiterals(TokenRole.DEFAULT, literals);
  }

  protected void emitType(TokenRole role, int type) {
    emitToken(new ParserToken(role, type));
  }

  protected void emitType(int type) {
    emitType(TokenRole.DEFAULT, type);
  }

  protected void emitType(TokenRole role, int... types) {
    for (int t : types) {
      emitType(role, t);
    }
  }

  protected void emitType(int... types) {
    emitType(TokenRole.DEFAULT, types);
  }

  protected void emitWhitespace(TokenRole role, String whitespace) {
    emitToken(new LiteralToken(TokenChannel.WHITESPACE, role, whitespace));
  }

  protected void emitExactWhitespace(String whitespace) {
    emitWhitespace(TokenRole.EXACT, whitespace);
  }

  private void emitSpace(TokenRole role) {
    emitWhitespace(role, " ");
  }

  protected void emitExactSpace() {
    emitSpace(TokenRole.EXACT);
  }

  protected void emitExtendableSpace() {
    emitSpace(TokenRole.EXTENDABLE_SPACE);
  }

  protected void emitBreakableSpace() {
    emitSpace(TokenRole.BREAKABLE_SPACE);
  }

  private void emitNewline(TokenRole role) {
    emitWhitespace(role, "\n");
  }

  protected void emitExactNewline() {
    emitNewline(TokenRole.EXACT);
  }

  protected void emitCommonNewline() {
    emitNewline(TokenRole.COMMON_FORMATTING);
  }

  protected void emitStatementEnd() {
    emitType(GLSLLexer.SEMICOLON);
    emitCommonNewline();
  }

  protected void emitLineDirective(SourceLocation location) {
    if (location == null) {
      return;
    }
    if (!location.hasLine()) {
      throw new IllegalArgumentException("Location must have line to be printed!");
    }
    emitToken(new LineDirectiveMarker(location));
  }

  protected void indent() {
    emitToken(IndentMarker.indent());
  }

  protected void unindent() {
    emitToken(IndentMarker.unindent());
  }

  protected void compactCommonNewline() {
    compactCommonNewline(ASTNode.class);
  }

  protected void compactCommonNewline(Class<? extends ASTNode> sourceClass) {
    emitToken(ReplaceToken.fromMatchAndNodeCondition(
        new LiteralToken(TokenRole.COMMON_FORMATTING, " "),
        "\n",
        node -> sourceClass.isAssignableFrom(node.getClass())));
  }

  protected void visitWithSeparator(List<? extends ASTNode> nodes, Runnable emitter) {
    for (int i = 0, size = nodes.size(); i < size; i++) {
      var node = nodes.get(i);
      if (node == null) {
        continue;
      }
      visit(node);
      if (i < size - 1) {
        emitter.run();
      }
    }
  }

  protected void visitCommaSpaced(List<? extends ASTNode> nodes) {
    visitWithSeparator(nodes, () -> {
      emitType(GLSLLexer.COMMA);
      emitBreakableSpace();
    });
  }

  protected ASTNode getCurrentNode() {
    return currentNode;
  }

  protected void setCurrentNode(ASTNode currentNode) {
    this.currentNode = currentNode;
  }

  protected boolean visitSafe(ASTNode node) {
    if (node != null) {
      visit(node);
      return true;
    }
    return false;
  }

  @Override
  public void enterContext(ASTNode node) {
    setCurrentNode(node);
  }

  @Override
  public Void visit(ASTNode node) {
    super.visit(node);
    return null;
  }

  @Override
  public Void initialResult() {
    return null;
  }

  @Override
  public Void superNodeTypeResult() {
    return null;
  }

  @Override
  public Void visitData(Object data) {
    return null;
  }

  @Override
  public Void defaultResult() {
    throw new IllegalStateException("The default value should never be used and all nodes should be printed properly!");
  }
}
