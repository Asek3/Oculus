package io.github.douira.glsl_transformer.ast.transform;

import io.github.douira.glsl_transformer.ast.node.TranslationUnit;

import java.util.EnumMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class EnumASTTransformer<J extends JobParameters, E extends Enum<E>>
    extends GroupedASTTransformer<J, E, EnumMap<E, String>, EnumMap<E, TranslationUnit>> {
  public EnumASTTransformer(Consumer<EnumMap<E, TranslationUnit>> transformation, Class<E> enumClass) {
    super(transformation, () -> new EnumMap<>(enumClass), () -> new EnumMap<>(enumClass));
  }

  public EnumASTTransformer(Class<E> enumClass) {
    super(() -> new EnumMap<>(enumClass), () -> new EnumMap<>(enumClass));
  }

  @Override
  public void setTuMapSupplier(Supplier<EnumMap<E, TranslationUnit>> tuMapSupplier) {
    throw new UnsupportedOperationException("The enum map suppliers may not be changed individually.");
  }

  @Override
  public void setResultMapSupplier(Supplier<EnumMap<E, String>> resultMapSupplier) {
    throw new UnsupportedOperationException("The enum map suppliers may not be changed individually.");
  }

  public void setEnumType(Class<E> enumClass) {
    super.setTuMapSupplier(() -> new EnumMap<>(enumClass));
    super.setResultMapSupplier(() -> new EnumMap<>(enumClass));
  }
}
