package io.github.douira.glsl_transformer.ast.node.type;

import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.node.type.qualifier.TypeQualifier;
import io.github.douira.glsl_transformer.ast.node.type.specifier.TypeSpecifier;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class FullySpecifiedType extends InnerASTNode {
  protected TypeQualifier typeQualifier; // TODO: nullable
  protected TypeSpecifier typeSpecifier;

  public FullySpecifiedType(TypeQualifier typeQualifier, TypeSpecifier typeSpecifier) {
    this.typeQualifier = setup(typeQualifier, this::setTypeQualifier);
    this.typeSpecifier = setup(typeSpecifier, this::setTypeSpecifier);
  }

  public FullySpecifiedType(TypeSpecifier typeSpecifier) {
    this.typeSpecifier = setup(typeSpecifier, this::setTypeSpecifier);
  }

  public TypeQualifier getTypeQualifier() {
    return typeQualifier;
  }

  public void setTypeQualifier(TypeQualifier typeQualifier) {
    updateParents(this.typeQualifier, typeQualifier, this::setTypeQualifier);
    this.typeQualifier = typeQualifier;
  }

  public TypeSpecifier getTypeSpecifier() {
    return typeSpecifier;
  }

  public void setTypeSpecifier(TypeSpecifier typeSpecifier) {
    updateParents(this.typeSpecifier, typeSpecifier, this::setTypeSpecifier);
    this.typeSpecifier = typeSpecifier;
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitFullySpecifiedType(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterFullySpecifiedType(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitFullySpecifiedType(this);
  }

  @Override
  public FullySpecifiedType clone() {
    return new FullySpecifiedType(clone(typeQualifier), clone(typeSpecifier));
  }

  @Override
  public FullySpecifiedType cloneInto(Root root) {
    return (FullySpecifiedType) super.cloneInto(root);
  }
}
