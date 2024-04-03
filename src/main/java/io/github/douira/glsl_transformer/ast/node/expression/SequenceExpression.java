package io.github.douira.glsl_transformer.ast.node.expression;

import java.util.stream.Stream;

import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class SequenceExpression extends ManyExpression {
  public SequenceExpression(Stream<Expression> expressions) {
    super(expressions);
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.SEQUENCE;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitSequenceExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterSequenceExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitSequenceExpression(this);
  }

  @Override
  public SequenceExpression clone() {
    return new SequenceExpression(clone(expressions));
  }

  @Override
  public SequenceExpression cloneInto(Root root) {
    return (SequenceExpression) super.cloneInto(root);
  }
}
