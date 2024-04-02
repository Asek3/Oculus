package io.github.douira.glsl_transformer.ast.node.expression.unary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class IncrementPostfixExpression extends UnaryExpression {
  public IncrementPostfixExpression(Expression expression) {
    super(expression);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.INCREMENT_POSTFIX;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitIncrementPostfixExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterIncrementPostfixExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitIncrementPostfixExpression(this);
  }

  @Override
  public IncrementPostfixExpression clone() {
    return new IncrementPostfixExpression(clone(operand));
  }

  @Override
  public IncrementPostfixExpression cloneInto(Root root) {
    return (IncrementPostfixExpression) super.cloneInto(root);
  }
}
