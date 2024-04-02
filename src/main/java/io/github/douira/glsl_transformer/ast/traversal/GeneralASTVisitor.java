package io.github.douira.glsl_transformer.ast.traversal;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ListNode;

import java.util.List;

public interface GeneralASTVisitor<R> {
  default R startVisit(ASTNode node) {
    return visit(node);
  }

  R visit(ASTNode node);

  default R visitData(Object data) {
    return defaultResult();
  }

  default R visitData(R previousResult, Object data) {
    return aggregateResult(previousResult, visitData(data));
  }

  default R visit(R previousResult, ASTNode node) {
    return aggregateResult(previousResult, visit(node));
  }

  default R visitSafe(R previousResult, ASTNode node) {
    return node == null ? previousResult : visit(previousResult, node);
  }

  default R visitChildren(R previousResult, List<? extends ASTNode> children) {
    if (children != null) {
      for (var child : children) {
        previousResult = visitSafe(previousResult, child);
      }
    }
    return previousResult;
  }

  default R visitChildren(R previousResult, ListNode<? extends ASTNode> node) {
    return visitChildren(previousResult, node.getChildren());
  }

  default R visitChildren(List<? extends ASTNode> children) {
    return visitChildren(initialResult(), children);
  }

  default R visitChildren(ListNode<? extends ASTNode> node) {
    return visitChildren(node.getChildren());
  }

  default R visitTwoChildren(ASTNode left, ASTNode right) {
    var result = initialResult();
    result = visitSafe(result, left);
    result = visitSafe(result, right);
    return result;
  }

  default R visitThreeChildren(ASTNode first, ASTNode second, ASTNode third) {
    var result = initialResult();
    result = visitSafe(result, first);
    result = visitSafe(result, second);
    result = visitSafe(result, third);
    return result;
  }

  R initialResult();

  R superNodeTypeResult();

  R defaultResult();

  R aggregateResult(R aggregate, R nextResult);

  default R aggregateResult(R aggregate, R firstResult, R secondResult) {
    return aggregateResult(aggregateResult(aggregate, firstResult), secondResult);
  }
}
