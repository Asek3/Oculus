package io.github.douira.glsl_transformer.ast.node.type.specifier;

import io.github.douira.glsl_transformer.GLSLLexer;
import io.github.douira.glsl_transformer.ast.data.TokenTyped;
import io.github.douira.glsl_transformer.ast.data.TypeUtil;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;
import repack.antlr.v4.runtime.Token;

public class BuiltinFixedTypeSpecifier extends TypeSpecifier {
  public enum BuiltinType implements TokenTyped {
    VOID(GLSLLexer.VOID, TypeKind.VOID),
    ATOMIC_UINT(GLSLLexer.ATOMIC_UINT, TypeKind.ATOMIC_UINT),
    SAMPLER2D(GLSLLexer.SAMPLER2D, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLER3D(GLSLLexer.SAMPLER3D, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLERCUBE(GLSLLexer.SAMPLERCUBE, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLER2DSHADOW(GLSLLexer.SAMPLER2DSHADOW, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLERCUBESHADOW(GLSLLexer.SAMPLERCUBESHADOW, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLER2DARRAY(GLSLLexer.SAMPLER2DARRAY, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLER2DARRAYSHADOW(GLSLLexer.SAMPLER2DARRAYSHADOW, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLERCUBEARRAY(GLSLLexer.SAMPLERCUBEARRAY, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLERCUBEARRAYSHADOW(GLSLLexer.SAMPLERCUBEARRAYSHADOW, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    ISAMPLER2D(GLSLLexer.ISAMPLER2D, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    ISAMPLER3D(GLSLLexer.ISAMPLER3D, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    ISAMPLERCUBE(GLSLLexer.ISAMPLERCUBE, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    ISAMPLER2DARRAY(GLSLLexer.ISAMPLER2DARRAY, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    ISAMPLERCUBEARRAY(GLSLLexer.ISAMPLERCUBEARRAY, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    USAMPLER2D(GLSLLexer.USAMPLER2D, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    USAMPLER3D(GLSLLexer.USAMPLER3D, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    USAMPLERCUBE(GLSLLexer.USAMPLERCUBE, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    USAMPLER2DARRAY(GLSLLexer.USAMPLER2DARRAY, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    USAMPLERCUBEARRAY(GLSLLexer.USAMPLERCUBEARRAY, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    SAMPLER1D(GLSLLexer.SAMPLER1D, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLER1DSHADOW(GLSLLexer.SAMPLER1DSHADOW, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLER1DARRAY(GLSLLexer.SAMPLER1DARRAY, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLER1DARRAYSHADOW(GLSLLexer.SAMPLER1DARRAYSHADOW, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    ISAMPLER1D(GLSLLexer.ISAMPLER1D, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    ISAMPLER1DARRAY(GLSLLexer.ISAMPLER1DARRAY, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    USAMPLER1D(GLSLLexer.USAMPLER1D, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    USAMPLER1DARRAY(GLSLLexer.USAMPLER1DARRAY, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    SAMPLER2DRECT(GLSLLexer.SAMPLER2DRECT, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    SAMPLER2DRECTSHADOW(GLSLLexer.SAMPLER2DRECTSHADOW, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    ISAMPLER2DRECT(GLSLLexer.ISAMPLER2DRECT, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    USAMPLER2DRECT(GLSLLexer.USAMPLER2DRECT, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    SAMPLERBUFFER(GLSLLexer.SAMPLERBUFFER, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    ISAMPLERBUFFER(GLSLLexer.ISAMPLERBUFFER, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    USAMPLERBUFFER(GLSLLexer.USAMPLERBUFFER, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    SAMPLER2DMS(GLSLLexer.SAMPLER2DMS, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    ISAMPLER2DMS(GLSLLexer.ISAMPLER2DMS, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    USAMPLER2DMS(GLSLLexer.USAMPLER2DMS, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    SAMPLER2DMSARRAY(GLSLLexer.SAMPLER2DMSARRAY, TypeKind.SAMPLER, ValueFormat.FLOATING_POINT),
    ISAMPLER2DMSARRAY(GLSLLexer.ISAMPLER2DMSARRAY, TypeKind.SAMPLER, ValueFormat.SIGNED_INTEGER),
    USAMPLER2DMSARRAY(GLSLLexer.USAMPLER2DMSARRAY, TypeKind.SAMPLER, ValueFormat.UNSIGNED_INTEGER),
    IMAGE2D(GLSLLexer.IMAGE2D, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGE2D(GLSLLexer.IIMAGE2D, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGE2D(GLSLLexer.UIMAGE2D, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGE3D(GLSLLexer.IMAGE3D, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGE3D(GLSLLexer.IIMAGE3D, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGE3D(GLSLLexer.UIMAGE3D, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGECUBE(GLSLLexer.IMAGECUBE, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGECUBE(GLSLLexer.IIMAGECUBE, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGECUBE(GLSLLexer.UIMAGECUBE, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGEBUFFER(GLSLLexer.IMAGEBUFFER, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGEBUFFER(GLSLLexer.IIMAGEBUFFER, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGEBUFFER(GLSLLexer.UIMAGEBUFFER, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGE1D(GLSLLexer.IMAGE1D, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGE1D(GLSLLexer.IIMAGE1D, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGE1D(GLSLLexer.UIMAGE1D, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGE1DARRAY(GLSLLexer.IMAGE1DARRAY, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGE1DARRAY(GLSLLexer.IIMAGE1DARRAY, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGE1DARRAY(GLSLLexer.UIMAGE1DARRAY, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGE2DRECT(GLSLLexer.IMAGE2DRECT, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGE2DRECT(GLSLLexer.IIMAGE2DRECT, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGE2DRECT(GLSLLexer.UIMAGE2DRECT, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGE2DARRAY(GLSLLexer.IMAGE2DARRAY, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGE2DARRAY(GLSLLexer.IIMAGE2DARRAY, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGE2DARRAY(GLSLLexer.UIMAGE2DARRAY, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGECUBEARRAY(GLSLLexer.IMAGECUBEARRAY, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGECUBEARRAY(GLSLLexer.IIMAGECUBEARRAY, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGECUBEARRAY(GLSLLexer.UIMAGECUBEARRAY, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGE2DMS(GLSLLexer.IMAGE2DMS, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGE2DMS(GLSLLexer.IIMAGE2DMS, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGE2DMS(GLSLLexer.UIMAGE2DMS, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    IMAGE2DMSARRAY(GLSLLexer.IMAGE2DMSARRAY, TypeKind.IMAGE, ValueFormat.FLOATING_POINT),
    IIMAGE2DMSARRAY(GLSLLexer.IIMAGE2DMSARRAY, TypeKind.IMAGE, ValueFormat.SIGNED_INTEGER),
    UIMAGE2DMSARRAY(GLSLLexer.UIMAGE2DMSARRAY, TypeKind.IMAGE, ValueFormat.UNSIGNED_INTEGER),
    ACCELERATION_STRUCTURE(GLSLLexer.ACCELERATION_STRUCTURE_EXT, TypeKind.ACCELERATION_STRUCTURE);

    public enum TypeKind {
      VOID,
      ATOMIC_UINT,
      SAMPLER,
      IMAGE,
      ACCELERATION_STRUCTURE;
    }

    public enum ValueFormat {
      FLOATING_POINT,
      SIGNED_INTEGER,
      UNSIGNED_INTEGER
    }

    public final int tokenType;
    public final TypeKind kind;
    public final ValueFormat valueFormat; // only for number-related types

    private BuiltinType(int tokenType, TypeKind kind, ValueFormat valueFormat) {
      this.tokenType = tokenType;
      this.kind = kind;
      this.valueFormat = valueFormat;
    }

    private BuiltinType(int tokenType, TypeKind kind) {
      this(tokenType, kind, null);
    }

    @Override
    public int getTokenType() {
      return tokenType;
    }

    public static BuiltinType fromToken(Token token) {
      return TypeUtil.enumFromToken(BuiltinType.values(), token);
    }
  }

  public BuiltinType type;

  public BuiltinFixedTypeSpecifier(BuiltinType type) {
    this.type = type;
  }

  public BuiltinFixedTypeSpecifier(BuiltinType type, ArraySpecifier arraySpecifier) {
    super(arraySpecifier);
    this.type = type;
  }

  @Override
  public SpecifierType getSpecifierType() {
    return SpecifierType.BULTIN_FIXED;
  }

  @Override
  public <R> R typeSpecifierAccept(ASTVisitor<R> visitor) {
    return visitor.visitBuiltinFixedTypeSpecifier(this);
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
  public BuiltinFixedTypeSpecifier clone() {
    return new BuiltinFixedTypeSpecifier(type, clone(arraySpecifier));
  }

  @Override
  public BuiltinFixedTypeSpecifier cloneInto(Root root) {
    return (BuiltinFixedTypeSpecifier) super.cloneInto(root);
  }
}
