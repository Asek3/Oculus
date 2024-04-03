package io.github.douira.glsl_transformer.ast.node;

import java.util.*;
import java.util.stream.Stream;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ListASTNode;
import io.github.douira.glsl_transformer.ast.node.external_declaration.*;
import io.github.douira.glsl_transformer.ast.node.statement.*;
import io.github.douira.glsl_transformer.ast.print.OutputOptions;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.transform.*;
import io.github.douira.glsl_transformer.ast.traversal.*;

/**
 * The translation unit is the entry point of a program and represents a single
 * file of source code.
 */
public class TranslationUnit extends ListASTNode<ExternalDeclaration> {
  protected VersionStatement versionStatement;
  public final OutputOptions outputOptions;

  public TranslationUnit(VersionStatement versionStatement, Stream<ExternalDeclaration> children,
      OutputOptions outputOptions) {
    super(children);
    this.versionStatement = setup(versionStatement, this::setVersionStatement);
    this.outputOptions = outputOptions;
  }

  public TranslationUnit(VersionStatement versionStatement, Stream<ExternalDeclaration> children) {
    super(children);
    this.versionStatement = setup(versionStatement, this::setVersionStatement);
    this.outputOptions = new OutputOptions();
  }

  public TranslationUnit(Stream<ExternalDeclaration> children) {
    super(children);
    this.outputOptions = new OutputOptions();
  }

  public VersionStatement getVersionStatement() {
    return versionStatement;
  }

  public void setVersionStatement(VersionStatement versionStatement) {
    updateParents(this.versionStatement, versionStatement, this::setVersionStatement);
    this.versionStatement = versionStatement;
  }

  public void injectNode(ASTInjectionPoint injectionPoint, ExternalDeclaration node) {
    getChildren().add(injectionPoint.getInjectionIndex(this), node);
  }

  public void injectNodes(
      ASTInjectionPoint injectionPoint,
      Collection<ExternalDeclaration> nodes) {
    getChildren().addAll(injectionPoint.getInjectionIndex(this), nodes);
  }

  public void injectNodes(
      ASTInjectionPoint injectionPoint,
      Stream<ExternalDeclaration> nodes) {
    nodes.reduce(injectionPoint.getInjectionIndex(this), (index, node) -> {
      getChildren().add(index, node);
      return index + 1;
    }, Integer::sum);
  }

  public void parseAndInjectNodes(
      ASTParser t,
      ASTInjectionPoint injectionPoint,
      Stream<String> externalDeclarations) {
    injectNodes(injectionPoint,
        externalDeclarations.map(str -> t.parseExternalDeclaration(getRoot(), str)));
  }

  /**
   * Injects an external declaration parsed from the given string into the
   * translation unit at the given injection point. Note that if the external
   * declaration begins with a # sign, it must be terminated by a newline.
   * 
   * @param t                   The parser to use
   * @param injectionPoint      The injection point
   * @param externalDeclaration The external declarations to parse and inject
   */
  public void parseAndInjectNode(
      ASTParser t,
      ASTInjectionPoint injectionPoint,
      String externalDeclaration) {
    getChildren().add(injectionPoint.getInjectionIndex(this),
        t.parseExternalDeclaration(
            getRoot(),
            externalDeclaration));
  }

  /**
   * Injects the external declarations parsed from the given strings into the
   * translation unit at the given injection point. Note that if an external
   * declaration begins with a # sign, it must be terminated by a newline.
   * 
   * @param t                    The parser to use
   * @param injectionPoint       The injection point
   * @param externalDeclarations The external declarations to parse and inject
   */
  public void parseAndInjectNodes(
      ASTParser t,
      ASTInjectionPoint injectionPoint,
      String... externalDeclarations) {
    injectNodes(injectionPoint, t.parseExternalDeclarations(getRoot(), externalDeclarations));
  }

  public Optional<CompoundStatement> getOneFunctionDefinitionBodyOptional(String functionName) {
    return getRoot().identifierIndex.getStream(functionName)
        .map(id -> id.getBranchAncestor(FunctionDefinition.class, FunctionDefinition::getFunctionPrototype))
        .filter(Objects::nonNull).findAny().map(FunctionDefinition::getBody);
  }

  public CompoundStatement getOneFunctionDefinitionBody(String functionName) {
    return getOneFunctionDefinitionBodyOptional(functionName)
        .orElseThrow(TransformationException.supplier("No function definition found for '" + functionName + "'"));
  }

  public CompoundStatement getOneMainDefinitionBody() {
    return getOneFunctionDefinitionBody("main");
  }

  public void prependFunctionBody(String functionName, Statement statement) {
    getOneFunctionDefinitionBody(functionName).getStatements().add(0, statement);
  }

  public void prependFunctionBody(String functionName, Collection<Statement> statements) {
    getOneFunctionDefinitionBody(functionName).getStatements().addAll(0, statements);
  }

  public void appendFunctionBody(String functionName, Statement statement) {
    getOneFunctionDefinitionBody(functionName).getStatements().add(statement);
  }

  public void appendFunctionBody(String functionName, Collection<Statement> statements) {
    getOneFunctionDefinitionBody(functionName).getStatements().addAll(statements);
  }

  public void prependMainFunctionBody(Statement statement) {
    prependFunctionBody("main", statement);
  }

  public void prependMainFunctionBody(Collection<Statement> statements) {
    prependFunctionBody("main", statements);
  }

  public void appendMainFunctionBody(Statement statement) {
    appendFunctionBody("main", statement);
  }

  public void appendMainFunctionBody(Collection<Statement> statements) {
    appendFunctionBody("main", statements);
  }

  public void prependMainFunctionBody(ASTParser t, String... statements) {
    prependMainFunctionBody(t.parseStatements(getRoot(), statements));
  }

  public void prependMainFunctionBody(ASTParser t, String statement) {
    prependMainFunctionBody(t.parseStatement(getRoot(), statement));
  }

  public void appendMainFunctionBody(ASTParser t, String... statements) {
    appendMainFunctionBody(t.parseStatements(getRoot(), statements));
  }

  public void appendMainFunctionBody(ASTParser t, String statement) {
    appendMainFunctionBody(t.parseStatement(getRoot(), statement));
  }

  public void ensureVersionStatement() {
    if (versionStatement == null) {
      setVersionStatement(VersionStatement.getDefault());
    }
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitTranslationUnit(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterTranslationUnit(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitTranslationUnit(this);
  }

  @Override
  public TranslationUnit clone() {
    return new TranslationUnit(clone(versionStatement), getClonedChildren(), outputOptions.clone());
  }

  @Override
  public TranslationUnit cloneInto(Root root) {
    return (TranslationUnit) super.cloneInto(root);
  }
}
