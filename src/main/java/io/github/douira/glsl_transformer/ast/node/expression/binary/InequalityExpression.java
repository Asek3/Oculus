package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class InequalityExpression extends BinaryExpression {
  public InequalityExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.NOT_EQUAL;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitInequalityExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterInequalityExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitInequalityExpression(this);
  }

  @Override
  public InequalityExpression clone() {
    return new InequalityExpression(clone(left), clone(right));
  }

  @Override
  public InequalityExpression cloneInto(Root root) {
    return (InequalityExpression) super.cloneInto(root);
  }
}
