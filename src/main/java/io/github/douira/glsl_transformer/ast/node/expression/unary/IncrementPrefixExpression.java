package io.github.douira.glsl_transformer.ast.node.expression.unary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class IncrementPrefixExpression extends UnaryExpression {
  public IncrementPrefixExpression(Expression expression) {
    super(expression);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.INCREMENT_PREFIX;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitIncrementPrefixExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterIncrementPrefixExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitIncrementPrefixExpression(this);
  }

  @Override
  public IncrementPrefixExpression clone() {
    return new IncrementPrefixExpression(clone(operand));
  }

  @Override
  public IncrementPrefixExpression cloneInto(Root root) {
    return (IncrementPrefixExpression) super.cloneInto(root);
  }
}
