package io.github.douira.glsl_transformer.ast.node.abstract_node;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;

public abstract class InnerASTNode extends ASTNode {
  public abstract void enterNode(ASTListener listener);

  public abstract void exitNode(ASTListener listener);

  @Override
  public abstract InnerASTNode clone();

  @Override
  public InnerASTNode cloneInto(Root root) {
    return (InnerASTNode) super.cloneInto(root);
  }
}
