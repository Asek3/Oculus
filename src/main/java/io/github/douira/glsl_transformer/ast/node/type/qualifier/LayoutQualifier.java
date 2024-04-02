package io.github.douira.glsl_transformer.ast.node.type.qualifier;

import java.util.stream.Stream;

import io.github.douira.glsl_transformer.ast.data.ChildNodeList;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class LayoutQualifier extends TypeQualifierPart {
  protected ChildNodeList<LayoutQualifierPart> parts;

  public LayoutQualifier(Stream<LayoutQualifierPart> parts) {
    this.parts = ChildNodeList.collect(parts, this);
  }

  public ChildNodeList<LayoutQualifierPart> getParts() {
    return parts;
  }

  @Override
  public QualifierType getQualifierType() {
    return QualifierType.LAYOUT;
  }

  @Override
  public <R> R typeQualifierPartAccept(ASTVisitor<R> visitor) {
    return visitor.visitLayoutQualifier(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterLayoutQualifier(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitLayoutQualifier(this);
  }

  @Override
  public LayoutQualifier clone() {
    return new LayoutQualifier(clone(parts));
  }

  @Override
  public LayoutQualifier cloneInto(Root root) {
    return (LayoutQualifier) super.cloneInto(root);
  }
}
