package io.github.douira.glsl_transformer.ast.node.type.specifier;

import io.github.douira.glsl_transformer.ast.node.abstract_node.ListASTNode;
import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

import java.util.List;
import java.util.stream.Stream;

//TODO: any of these expressions can be null
public class ArraySpecifier extends ListASTNode<Expression> {
  public ArraySpecifier(Stream<Expression> children) {
    super(children);
  }

  public List<Expression> getDimensions() {
    return getChildren();
  }

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitArraySpecifier(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterArraySpecifier(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitArraySpecifier(this);
  }

  @Override
  public ArraySpecifier clone() {
    return new ArraySpecifier(getClonedChildren());
  }

  @Override
  public ArraySpecifier cloneInto(Root root) {
    return (ArraySpecifier) super.cloneInto(root);
  }
}
