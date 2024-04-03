package io.github.douira.glsl_transformer.ast.node.type.qualifier;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class SharedLayoutQualifierPart extends LayoutQualifierPart {
  @Override
  public LayoutQualifierType getLayoutQualifierType() {
    return LayoutQualifierType.SHARED;
  }

  @Override
  public <R> R layoutQualifierPartAccept(ASTVisitor<R> visitor) {
    return visitor.visitSharedLayoutQualifierPart(this);
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
  public SharedLayoutQualifierPart clone() {
    return new SharedLayoutQualifierPart();
  }

  @Override
  public SharedLayoutQualifierPart cloneInto(Root root) {
    return (SharedLayoutQualifierPart) super.cloneInto(root);
  }
}
