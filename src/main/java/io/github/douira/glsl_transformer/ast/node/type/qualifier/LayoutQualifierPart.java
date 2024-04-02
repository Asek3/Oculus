package io.github.douira.glsl_transformer.ast.node.type.qualifier;

import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public abstract class LayoutQualifierPart extends InnerASTNode {
  public enum LayoutQualifierType {
    NAMED,
    SHARED
  }

  public abstract LayoutQualifierType getLayoutQualifierType();

  public abstract <R> R layoutQualifierPartAccept(ASTVisitor<R> visitor);

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        visitor.visitLayoutQualifierPart(this),
        layoutQualifierPartAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterLayoutQualifierPart(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitLayoutQualifierPart(this);
  }

  @Override
  public abstract LayoutQualifierPart clone();

  @Override
  public LayoutQualifierPart cloneInto(Root root) {
    return (LayoutQualifierPart) super.cloneInto(root);
  }
}
