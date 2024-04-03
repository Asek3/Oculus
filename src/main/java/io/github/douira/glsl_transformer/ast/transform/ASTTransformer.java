package io.github.douira.glsl_transformer.ast.transform;

import io.github.douira.glsl_transformer.ast.node.TranslationUnit;
import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.external_declaration.ExternalDeclaration;
import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.print.PrintType;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.query.RootSupplier;
import io.github.douira.glsl_transformer.token_filter.TokenFilter;

import java.util.Objects;

/**
 * The ast transformer transforms some representation of an input and returns
 * the same kind of output. The implementations of this class determine how it
 * works in detail.
 */
public abstract class ASTTransformer<J extends JobParameters, V> extends ASTParser
    implements ParameterizedTransformer<J, V> {
  private J jobParameters;
  private PrintType printType = PrintType.COMPACT;
  private RootSupplier rootSupplier = RootSupplier.DEFAULT;

  @Override
  public J getJobParameters() {
    return jobParameters;
  }

  @Override
  public void setJobParameters(J parameters) {
    jobParameters = parameters;
  }

  public PrintType getPrintType() {
    return printType;
  }

  public void setPrintType(PrintType printType) {
    this.printType = printType;
  }

  @Override
  @SuppressWarnings("unchecked")
  public void setTokenFilter(TokenFilter<?> tokenFilter) {
    super.setTokenFilter(tokenFilter);
    ((TokenFilter<J>) tokenFilter).setJobParametersSupplier(this::getJobParameters);
  }

  public RootSupplier getRootSupplier() {
    return rootSupplier;
  }

  public void setRootSupplier(RootSupplier rootSupplier) {
    Objects.requireNonNull(rootSupplier);
    this.rootSupplier = rootSupplier;
  }

  public Root supplyRoot() {
    return rootSupplier.get();
  }

  @Override
  public V transform(V input) {
    return transform(rootSupplier, input);
  }

  /**
   * Transforms the given input and returns the result using a root supplier. This
   * method adds the root supplier parameter so that downstream transformers can
   * pass it on to the parser. This class implements the generic version of this
   * method by calling this method with the stored root supplier.
   *
   * @param rootSupplier The root supplier to use
   * @param input        The input to transform
   * @return The transformed input
   */
  public abstract V transform(RootSupplier rootSupplier, V input);

  public TranslationUnit parseSeparateTranslationUnit(String input) {
    return parseTranslationUnit(rootSupplier, input);
  }

  public ExternalDeclaration parseSeparateExternalDeclaration(String input) {
    return parseExternalDeclaration(rootSupplier, input);
  }

  public Expression parseSeparateExpression(String input) {
    return parseExpression(rootSupplier, input);
  }

  public Statement parseSeparateStatement(String input) {
    return parseStatement(rootSupplier, input);
  }
}
