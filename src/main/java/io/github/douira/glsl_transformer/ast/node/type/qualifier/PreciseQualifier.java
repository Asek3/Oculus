package io.github.douira.glsl_transformer.ast.node.type.qualifier;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class PreciseQualifier extends TypeQualifierPart {
  @Override
  public QualifierType getQualifierType() {
    return QualifierType.PRECISE;
  }

  @Override
  public <R> R typeQualifierPartAccept(ASTVisitor<R> visitor) {
    return visitor.visitPreciseQualifier(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    // terminal nodes have no children
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    // terminal nodes have no children
  }

  @Override
  public PreciseQualifier clone() {
    return new PreciseQualifier();
  }

  @Override
  public PreciseQualifier cloneInto(Root root) {
    return (PreciseQualifier) super.cloneInto(root);
  }
}
