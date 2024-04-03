package io.github.douira.glsl_transformer.ast.query.index;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;

public interface Index<N extends ASTNode> {
  void add(N node);

  void remove(N node);
}
