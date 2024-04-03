package io.github.douira.glsl_transformer.ast.transform;

import java.util.function.*;

import io.github.douira.glsl_transformer.ast.node.TranslationUnit;
import io.github.douira.glsl_transformer.ast.print.ASTPrinter;
import io.github.douira.glsl_transformer.ast.query.*;
import io.github.douira.glsl_transformer.util.TriConsumer;

/**
 * The AST transformer takes parses a string, turns it into an AST, transforms
 * it with the given transformation and then prints it back.
 */
public class SingleASTTransformer<J extends JobParameters> extends ASTTransformer<J, String> {
  public static final Consumer<TranslationUnit> IDENTITY_TRANSFORMATION = (tu) -> {
  };

  private Consumer<TranslationUnit> transformation;

  public SingleASTTransformer() {
  }

  public SingleASTTransformer(Consumer<TranslationUnit> transformation) {
    super();
    setTransformation(transformation);
  }

  public SingleASTTransformer(BiConsumer<TranslationUnit, Root> transformation) {
    super();
    setTransformation(transformation);
  }

  public SingleASTTransformer(TriConsumer<TranslationUnit, Root, J> transformation) {
    super();
    setTransformation(transformation);
  }

  public void setTransformation(Consumer<TranslationUnit> transformation) {
    this.transformation = transformation;
  }

  public void setTransformation(BiConsumer<TranslationUnit, Root> transformation) {
    this.transformation = wrapTransformation(this, transformation);
  }

  public void setTransformation(TriConsumer<TranslationUnit, Root, J> transformation) {
    this.transformation = wrapTransformation(this, transformation);
  }

  public static <T, R> Consumer<TranslationUnit> wrapTransformation(ParameterizedTransformer<T, R> transformer,
      TriConsumer<TranslationUnit, Root, T> transformation) {
    return translationUnit -> transformation.accept(
        translationUnit,
        translationUnit.getRoot(),
        transformer.getJobParameters());
  }

  public static <R> Consumer<TranslationUnit> wrapTransformation(
      ParameterizedTransformer<?, R> transformer,
      BiConsumer<TranslationUnit, Root> transformation) {
    return translationUnit -> transformation.accept(
        translationUnit,
        translationUnit.getRoot());
  }

  @Override
  public String transform(RootSupplier rootSupplier, String str) {
    var translationUnit = parseTranslationUnit(rootSupplier, str);
    transformation.accept(translationUnit);
    return ASTPrinter.print(getPrintType(), translationUnit);
  }
}
