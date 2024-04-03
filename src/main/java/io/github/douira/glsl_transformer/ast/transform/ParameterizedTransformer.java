package io.github.douira.glsl_transformer.ast.transform;

public interface ParameterizedTransformer<J, V> extends ParameterHolder<J>, Transformer<V> {
  default V transform(V input, J parameters) {
    return withJobParameters(parameters, () -> transform(input));
  }
}
