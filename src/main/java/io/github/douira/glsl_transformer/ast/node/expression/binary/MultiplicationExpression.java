package io.github.douira.glsl_transformer.ast.node.expression.binary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class MultiplicationExpression extends BinaryExpression {
  public MultiplicationExpression(Expression left, Expression right) {
    super(left, right);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.MULTIPLICATION;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitMultiplicationExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterMultiplicationExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitMultiplicationExpression(this);
  }

  @Override
  public MultiplicationExpression clone() {
    return new MultiplicationExpression(clone(left), clone(right));
  }

  @Override
  public MultiplicationExpression cloneInto(Root root) {
    return (MultiplicationExpression) super.cloneInto(root);
  }
}
