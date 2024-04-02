package io.github.douira.glsl_transformer.ast.node.expression.unary;

import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class LengthAccessExpression extends UnaryExpression {
  public LengthAccessExpression(Expression operand) {
    super(operand);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.LENGTH_ACCESS;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitLengthAccessExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterLengthAccessExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitLengthAccessExpression(this);
  }

  @Override
  public LengthAccessExpression clone() {
    return new LengthAccessExpression(clone(operand));
  }

  @Override
  public LengthAccessExpression cloneInto(Root root) {
    return (LengthAccessExpression) super.cloneInto(root);
  }
}
