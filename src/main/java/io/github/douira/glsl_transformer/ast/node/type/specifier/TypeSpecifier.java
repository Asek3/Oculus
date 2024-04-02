package io.github.douira.glsl_transformer.ast.node.type.specifier;

import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public abstract class TypeSpecifier extends InnerASTNode {
  public enum SpecifierType {
    BUILTIN_NUMERIC, // like int32, f32mat3x3 etc
    BULTIN_FIXED, // like sampler2D, image1d etc
    STRUCT, // like struct { float x; float y; }
    REFERENCE // custom type references
  }

  public abstract SpecifierType getSpecifierType();

  protected ArraySpecifier arraySpecifier; // TODO: nullable

  public TypeSpecifier() {
  }

  public TypeSpecifier(ArraySpecifier arraySpecifier) {
    this.arraySpecifier = setup(arraySpecifier, this::setArraySpecifier);
  }

  public ArraySpecifier getArraySpecifier() {
    return arraySpecifier;
  }

  public void setArraySpecifier(ArraySpecifier arraySpecifier) {
    updateParents(this.arraySpecifier, arraySpecifier, this::setArraySpecifier);
    this.arraySpecifier = arraySpecifier;
  }

  public abstract <R> R typeSpecifierAccept(ASTVisitor<R> visitor);

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.aggregateResult(
        visitor.visitTypeSpecifier(this),
        typeSpecifierAccept(visitor));
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterTypeSpecifier(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitTypeSpecifier(this);
  }

  @Override
  public abstract TypeSpecifier clone();

  @Override
  public TypeSpecifier cloneInto(Root root) {
    return (TypeSpecifier) super.cloneInto(root);
  }
}
