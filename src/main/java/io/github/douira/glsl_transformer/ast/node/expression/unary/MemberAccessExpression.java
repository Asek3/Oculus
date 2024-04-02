package io.github.douira.glsl_transformer.ast.node.expression.unary;

import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.*;

public class MemberAccessExpression extends UnaryExpression {
  protected Identifier member;

  public MemberAccessExpression(Expression expression, Identifier member) {
    super(expression);
    this.member = setup(member, this::setMember);
  }

  public Identifier getMember() {
    return member;
  }

  public void setMember(Identifier member) {
    updateParents(this.member, member, this::setMember);
    this.member = member;
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.MEMBER_ACCESS;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitMemberAccessExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterMemberAccessExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitMemberAccessExpression(this);
  }

  @Override
  public MemberAccessExpression clone() {
    return new MemberAccessExpression(clone(operand), clone(member));
  }

  @Override
  public MemberAccessExpression cloneInto(Root root) {
    return (MemberAccessExpression) super.cloneInto(root);
  }
}
