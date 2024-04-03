package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class ModuloAssignmentExpression extends BinaryExpression {
  public ModuloAssignmentExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.MODULO_ASSIGNMENT;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitModuloAssignmentExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterModuloAssignmentExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitModuloAssignmentExpression(this);
  }

  @Override
  public ModuloAssignmentExpression clone() {
    return new ModuloAssignmentExpression(clone(left), clone(right));
  }

  @Override
  public ModuloAssignmentExpression cloneInto(Root root) {
    return (ModuloAssignmentExpression) super.cloneInto(root);
  }
}
