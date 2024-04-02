package io.github.douira.glsl_transformer.ast.traversal;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;

public class ASTWalker<R> extends ASTBaseVisitor<R> {
  protected ASTListener listener;

  protected ASTWalker() {
  }

  private ASTWalker(ASTListener listener) {
    this.listener = listener;
  }

  public static <R> R walk(ASTListener listener, ASTNode node) {
    return new ASTWalker<R>(listener).startVisit(node);
  }

  @Override
  public R visit(ASTNode node) {
    if (node instanceof InnerASTNode innerNode) {
      var previousContext = context;
      setContext(node);
      enterNode(listener, innerNode);
      var result = visitRaw(node);
      exitNode(listener, innerNode);
      enterContext(previousContext);
      return result;
    } else {
      return super.visit(node);
    }
  }

  protected void enterNode(ASTListener listener, InnerASTNode node) {
    listener.enterEveryNode(node);
    node.enterNode(listener);
    listener.afterEnterEveryNode(node);
  }

  protected void exitNode(ASTListener listener, InnerASTNode node) {
    listener.beforeExitEveryNode(node);
    node.exitNode(listener);
    listener.exitEveryNode(node);
  }

  @Override
  public void enterContext(ASTNode node) {
    listener.enterContext(node);
  }
}
