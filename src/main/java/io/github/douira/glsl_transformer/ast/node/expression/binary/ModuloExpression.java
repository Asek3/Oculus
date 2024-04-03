package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class ModuloExpression extends BinaryExpression {
  public ModuloExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.MODULO;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitModuloExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterModuloExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitModuloExpression(this);
  }

  @Override
  public ModuloExpression clone() {
    return new ModuloExpression(clone(left), clone(right));
  }

  @Override
  public ModuloExpression cloneInto(Root root) {
    return (ModuloExpression) super.cloneInto(root);
  }
}
