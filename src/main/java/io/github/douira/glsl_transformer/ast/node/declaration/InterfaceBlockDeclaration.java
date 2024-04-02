package io.github.douira.glsl_transformer.ast.node.declaration;

import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.type.qualifier.TypeQualifier;
import io.github.douira.glsl_transformer.ast.node.type.specifier.ArraySpecifier;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructBody;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class InterfaceBlockDeclaration extends Declaration {
  protected TypeQualifier typeQualifier;
  protected Identifier blockName;
  protected StructBody structBody;
  protected Identifier variableName; // TODO: nullable
  protected ArraySpecifier arraySpecifier; // TODO: nullable

  public InterfaceBlockDeclaration(
      TypeQualifier typeQualifier,
      Identifier blockName,
      StructBody structBody,
      Identifier variableName,
      ArraySpecifier arraySpecifier) {
    this(typeQualifier, blockName, structBody, variableName);
    this.arraySpecifier = setup(arraySpecifier, this::setArraySpecifier);
  }

  public InterfaceBlockDeclaration(
      TypeQualifier typeQualifier,
      Identifier blockName,
      StructBody structBody,
      Identifier variableName) {
    this(typeQualifier, blockName, structBody);
    this.variableName = setup(variableName, this::setVariableName);
  }

  public InterfaceBlockDeclaration(
      TypeQualifier typeQualifier,
      Identifier blockName,
      StructBody structBody) {
    this.typeQualifier = setup(typeQualifier, this::setTypeQualifier);
    this.blockName = setup(blockName, this::setBlockName);
    this.structBody = setup(structBody, this::setStructBody);
  }

  public TypeQualifier getTypeQualifier() {
    return typeQualifier;
  }

  public void setTypeQualifier(TypeQualifier typeQualifier) {
    updateParents(this.typeQualifier, typeQualifier, this::setTypeQualifier);
    this.typeQualifier = typeQualifier;
  }

  public Identifier getBlockName() {
    return blockName;
  }

  public void setBlockName(Identifier blockName) {
    updateParents(this.blockName, blockName, this::setBlockName);
    this.blockName = blockName;
  }

  public StructBody getStructBody() {
    return structBody;
  }

  public void setStructBody(StructBody structBody) {
    updateParents(this.structBody, structBody, this::setStructBody);
    this.structBody = structBody;
  }

  public Identifier getVariableName() {
    return variableName;
  }

  public void setVariableName(Identifier variableName) {
    updateParents(this.variableName, variableName, this::setVariableName);
    this.variableName = variableName;
  }

  public ArraySpecifier getArraySpecifier() {
    return arraySpecifier;
  }

  public void setArraySpecifier(ArraySpecifier arraySpecifier) {
    updateParents(this.arraySpecifier, arraySpecifier, this::setArraySpecifier);
    this.arraySpecifier = arraySpecifier;
  }

  @Override
  public DeclarationType getDeclarationType() {
    return DeclarationType.INTERFACE_BLOCK;
  }

  @Override
  public <R> R declarationAccept(ASTVisitor<R> visitor) {
    return visitor.visitInterfaceBlockDeclaration(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterInterfaceBlockDeclaration(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitInterfaceBlockDeclaration(this);
  }

  @Override
  public InterfaceBlockDeclaration clone() {
    return new InterfaceBlockDeclaration(
        clone(typeQualifier),
        clone(blockName),
        clone(structBody),
        clone(variableName),
        clone(arraySpecifier));
  }

  @Override
  public InterfaceBlockDeclaration cloneInto(Root root) {
    return (InterfaceBlockDeclaration) super.cloneInto(root);
  }
}
