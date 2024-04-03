package io.github.douira.glsl_transformer.ast.transform;

/**
 * A transformer takes a value, does something with it and returns a value of
 * the same type. It's similar to a {@code Passthrough}.
 */
public interface Transformer<V> {
  V transform(V input);
}
