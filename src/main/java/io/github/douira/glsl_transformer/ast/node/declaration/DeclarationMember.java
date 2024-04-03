package io.github.douira.glsl_transformer.ast.node.declaration;

import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.node.type.initializer.Initializer;
import io.github.douira.glsl_transformer.ast.node.type.specifier.ArraySpecifier;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class DeclarationMember extends InnerASTNode {
  protected Identifier name;
  protected ArraySpecifier arraySpecifier; // TODO: nullable
  protected Initializer initializer; // TODO: nullable

  public DeclarationMember(Identifier name, ArraySpecifier arraySpecifier, Initializer initializer) {
    this.name = setup(name, this::setName);
    this.arraySpecifier = setup(arraySpecifier, this::setArraySpecifier);
    this.initializer = setup(initializer, this::setInitializer);
  }

  public DeclarationMember(Identifier name, Initializer initializer) {
    this.name = setup(name, this::setName);
    this.initializer = setup(initializer, this::setInitializer);
  }

  public DeclarationMember(Identifier name, ArraySpecifier arraySpecifier) {
    this.name = setup(name, this::setName);
    this.arraySpecifier = setup(arraySpecifier, this::setArraySpecifier);
  }

  public DeclarationMember(Identifier name) {
    this.name = setup(name, this::setName);
  }

  public Identifier getName() {
    return name;
  }

  public void setName(Identifier name) {
    updateParents(this.name, name, this::setName);
    this.name = name;
  }

  public ArraySpecifier getArraySpecifier() {
    return arraySpecifier;
  }

  public void setArraySpecifier(ArraySpecifier arraySpecifier) {
    updateParents(this.arraySpecifier, arraySpecifier, this::setArraySpecifier);
    this.arraySpecifier = arraySpecifier;
  }

  public Initializer getInitializer() {
    return initializer;
  }

  public void setInitializer(Initializer initializer) {
    updateParents(this.initializer, initializer, this::setInitializer);
    this.initializer = initializer;
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitDeclarationMember(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterDeclarationMember(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitDeclarationMember(this);
  }

  @Override
  public DeclarationMember clone() {
    return new DeclarationMember(clone(name), clone(arraySpecifier), clone(initializer));
  }

  @Override
  public DeclarationMember cloneInto(Root root) {
    return (DeclarationMember) super.cloneInto(root);
  }
}
