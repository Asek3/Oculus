package io.github.douira.glsl_transformer.ast.node.type.specifier;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;
import io.github.douira.glsl_transformer.util.Type;

public class BuiltinNumericTypeSpecifier extends TypeSpecifier {
  public Type type;

  public BuiltinNumericTypeSpecifier(Type type) {
    this.type = type;
  }

  public BuiltinNumericTypeSpecifier(Type type, ArraySpecifier arraySpecifier) {
    super(arraySpecifier);
    this.type = type;
  }

  @Override
  public SpecifierType getSpecifierType() {
    return SpecifierType.BUILTIN_NUMERIC;
  }

  @Override
  public <R> R typeSpecifierAccept(ASTVisitor<R> visitor) {
    return visitor.visitBuiltinNumericTypeSpecifier(this);
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
  public BuiltinNumericTypeSpecifier clone() {
    return new BuiltinNumericTypeSpecifier(type, clone(arraySpecifier));
  }

  @Override
  public BuiltinNumericTypeSpecifier cloneInto(Root root) {
    return (BuiltinNumericTypeSpecifier) super.cloneInto(root);
  }
}
