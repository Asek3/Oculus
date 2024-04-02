package io.github.douira.glsl_transformer.ast.node.type.qualifier;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class InvariantQualifier extends TypeQualifierPart {
  @Override
  public QualifierType getQualifierType() {
    return QualifierType.INVARIANT;
  }

  @Override
  public <R> R typeQualifierPartAccept(ASTVisitor<R> visitor) {
    return visitor.visitInvariantQualifier(this);
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
  public InvariantQualifier clone() {
    return new InvariantQualifier();
  }

  @Override
  public InvariantQualifier cloneInto(Root root) {
    return (InvariantQualifier) super.cloneInto(root);
  }
}
