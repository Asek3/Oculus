package io.github.douira.glsl_transformer.ast.node.type.struct;

import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.node.type.specifier.ArraySpecifier;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class StructDeclarator extends InnerASTNode {
  protected Identifier name;
  protected ArraySpecifier arraySpecifier; // TODO: nullable

  public StructDeclarator(Identifier name, ArraySpecifier arraySpecifier) {
    this.name = setup(name, this::setName);
    this.arraySpecifier = setup(arraySpecifier, this::setArraySpecifier);
  }

  public StructDeclarator(Identifier name) {
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

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitStructDeclarator(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterStructDeclarator(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitStructDeclarator(this);
  }

  @Override
  public StructDeclarator clone() {
    return new StructDeclarator(clone(name), clone(arraySpecifier));
  }

  @Override
  public StructDeclarator cloneInto(Root root) {
    return (StructDeclarator) super.cloneInto(root);
  }
}
