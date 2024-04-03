package io.github.douira.glsl_transformer.ast.node.type.specifier;

import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class TypeReference extends TypeSpecifier {
  protected Identifier reference;

  public TypeReference(Identifier reference) {
    this.reference = setup(reference, this::setReference);
  }

  public TypeReference(Identifier reference, ArraySpecifier arraySpecifier) {
    super(arraySpecifier);
    this.reference = setup(reference, this::setReference);
  }

  public Identifier getReference() {
    return reference;
  }

  public void setReference(Identifier reference) {
    updateParents(this.reference, reference, this::setReference);
    this.reference = reference;
  }

  @Override
  public SpecifierType getSpecifierType() {
    return SpecifierType.REFERENCE;
  }

  @Override
  public <R> R typeSpecifierAccept(ASTVisitor<R> visitor) {
    return visitor.visitTypeReference(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterTypeReference(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitTypeReference(this);
  }

  @Override
  public TypeReference clone() {
    return new TypeReference(clone(reference), clone(arraySpecifier));
  }

  @Override
  public TypeReference cloneInto(Root root) {
    return (TypeReference) super.cloneInto(root);
  }
}
