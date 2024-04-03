package io.github.douira.glsl_transformer.parser;

import io.github.douira.glsl_transformer.GLSLParser;
import io.github.douira.glsl_transformer.GLSLParser.*;
import io.github.douira.glsl_transformer.ast.node.TranslationUnit;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.external_declaration.ExternalDeclaration;
import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.node.type.FullySpecifiedType;
import io.github.douira.glsl_transformer.ast.query.RootSupplier;
import io.github.douira.glsl_transformer.ast.transform.ASTBuilder;
import io.github.douira.glsl_transformer.ast.transform.ASTParser;
import repack.antlr.v4.runtime.ParserRuleContext;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * A static data class that contains the information needed to parse and build a
 * specific type of node. Contains the class of the rule context, a method of
 * {@link GLSLParser} to parse this kind of rule context from a string, and a
 * method of {@link ASTBuilder} to build an AST node from a rule context.
 *
 * Usually the static pre-made instances of this class are sufficient but
 * additional specific instances can be created and should then be stored as a
 * static final field for reuse.
 */
public class ParseShape<C extends ParserRuleContext, N extends ASTNode> {
  public static final ParseShape<TranslationUnitContext, TranslationUnit> TRANSLATION_UNIT = new ParseShape<>(
      TranslationUnitContext.class,
      GLSLParser::translationUnit,
      ASTBuilder::visitTranslationUnit);
  public static final ParseShape<ExternalDeclarationContext, ExternalDeclaration> EXTERNAL_DECLARATION = new ParseShape<>(
      ExternalDeclarationContext.class,
      GLSLParser::externalDeclaration,
      ASTBuilder::visitExternalDeclaration);
  public static final ParseShape<StatementContext, Statement> STATEMENT = new ParseShape<>(
      StatementContext.class,
      GLSLParser::statement,
      ASTBuilder::visitStatement);
  public static final ParseShape<ExpressionContext, Expression> EXPRESSION = new ParseShape<>(
      ExpressionContext.class,
      GLSLParser::expression,
      ASTBuilder::visitExpression);
  public static final ParseShape<FullySpecifiedTypeContext, FullySpecifiedType> FULLY_SPECIFIED_TYPE = new ParseShape<>(
      FullySpecifiedTypeContext.class,
      GLSLParser::fullySpecifiedType,
      ASTBuilder::visitFullySpecifiedType);

  public final Class<C> ruleType;
  public final Function<GLSLParser, C> parseMethod;
  public final BiFunction<ASTBuilder, C, N> visitMethod;

  public ParseShape(Class<C> ruleType, Function<GLSLParser, C> parseMethod, BiFunction<ASTBuilder, C, N> visitMethod) {
    this.ruleType = ruleType;
    this.parseMethod = parseMethod;
    this.visitMethod = visitMethod;
  }

  public N _parseNodeSeparateInternal(String input) {
    return ASTParser._getInternalInstance().parseNodeSeparate(RootSupplier.DEFAULT, this, input);
  }
}
