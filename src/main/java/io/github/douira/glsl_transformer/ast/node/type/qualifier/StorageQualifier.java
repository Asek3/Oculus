package io.github.douira.glsl_transformer.ast.node.type.qualifier;

import java.util.stream.Stream;

import repack.antlr.v4.runtime.Token;

import io.github.douira.glsl_transformer.GLSLLexer;
import io.github.douira.glsl_transformer.ast.data.*;
import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class StorageQualifier extends TypeQualifierPart {
  public enum StorageType implements TokenTyped {
    CONST(GLSLLexer.CONST),
    IN(GLSLLexer.IN),
    OUT(GLSLLexer.OUT),
    INOUT(GLSLLexer.INOUT),
    CENTROID(GLSLLexer.CENTROID),
    PATCH(GLSLLexer.PATCH),
    SAMPLE(GLSLLexer.SAMPLE),
    UNIFORM(GLSLLexer.UNIFORM),
    VARYING(GLSLLexer.VARYING),
    ATTRIBUTE(GLSLLexer.ATTRIBUTE),
    BUFFER(GLSLLexer.BUFFER),
    SHARED(GLSLLexer.SHARED),
    RESTRICT(GLSLLexer.RESTRICT),
    VOLATILE(GLSLLexer.VOLATILE),
    COHERENT(GLSLLexer.COHERENT),
    READONLY(GLSLLexer.READONLY),
    WRITEONLY(GLSLLexer.WRITEONLY),
    SUBROUTINE(GLSLLexer.SUBROUTINE),
    DEVICECOHERENT(GLSLLexer.DEVICECOHERENT),
    QUEUEFAMILYCOHERENT(GLSLLexer.QUEUEFAMILYCOHERENT),
    WORKGROUPCOHERENT(GLSLLexer.WORKGROUPCOHERENT),
    SUBGROUPCOHERENT(GLSLLexer.SUBGROUPCOHERENT),
    NONPRIVATE(GLSLLexer.NONPRIVATE),
    RAY_PAYLOAD_EXT(GLSLLexer.RAY_PAYLOAD_EXT),
    RAY_PAYLOAD_IN_EXT(GLSLLexer.RAY_PAYLOAD_IN_EXT),
    HIT_ATTRIBUTE_EXT(GLSLLexer.HIT_ATTRIBUTE_EXT),
    CALLABLE_DATA_EXT(GLSLLexer.CALLABLE_DATA_EXT),
    CALLABLE_DATA_IN_EXT(GLSLLexer.CALLABLE_DATA_IN_EXT);

    public final int tokenType;

    private StorageType(int tokenType) {
      this.tokenType = tokenType;
    }

    @Override
    public int getTokenType() {
      return tokenType;
    }

    public static StorageType fromToken(Token token) {
      return TypeUtil.enumFromToken(StorageType.values(), token);
    }
  }

  protected ChildNodeList<Identifier> typeNames; // TODO: nullable (optional)
  public StorageType storageType;

  private StorageQualifier(Stream<Identifier> typeNames, StorageType storageType) {
    this.typeNames = ChildNodeList.collect(typeNames, this);
    this.storageType = storageType;
  }

  public StorageQualifier(Stream<Identifier> typeNames) {
    this.typeNames = ChildNodeList.collect(typeNames, this);
    this.storageType = StorageType.SUBROUTINE;
  }

  public StorageQualifier(StorageType storageType) {
    this.typeNames = null;
    this.storageType = storageType;
  }

  public ChildNodeList<Identifier> getTypeNames() {
    return typeNames;
  }

  @Override
  public QualifierType getQualifierType() {
    return QualifierType.STORAGE;
  }

  @Override
  public <R> R typeQualifierPartAccept(ASTVisitor<R> visitor) {
    return visitor.visitStorageQualifier(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterStorageQualifier(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitStorageQualifier(this);
  }

  @Override
  public StorageQualifier clone() {
    return new StorageQualifier(clone(typeNames), storageType);
  }

  @Override
  public StorageQualifier cloneInto(Root root) {
    return (StorageQualifier) super.cloneInto(root);
  }
}
