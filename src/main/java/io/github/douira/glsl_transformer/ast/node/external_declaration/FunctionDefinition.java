package io.github.douira.glsl_transformer.ast.node.external_declaration;

import io.github.douira.glsl_transformer.ast.node.statement.CompoundStatement;
import io.github.douira.glsl_transformer.ast.node.type.specifier.FunctionPrototype;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class FunctionDefinition extends ExternalDeclaration {
  protected FunctionPrototype functionPrototype;
  protected CompoundStatement body;

  public FunctionDefinition(FunctionPrototype functionPrototype, CompoundStatement body) {
    this.functionPrototype = setup(functionPrototype, this::setFunctionPrototype);
    this.body = setup(body, this::setBody);
  }

  public FunctionPrototype getFunctionPrototype() {
    return functionPrototype;
  }

  public void setFunctionPrototype(FunctionPrototype functionPrototype) {
    updateParents(this.functionPrototype, functionPrototype, this::setFunctionPrototype);
    this.functionPrototype = functionPrototype;
  }

  public CompoundStatement getBody() {
    return body;
  }

  public void setBody(CompoundStatement body) {
    updateParents(this.body, body, this::setBody);
    this.body = body;
  }

  @Override
  public ExternalDeclarationType getExternalDeclarationType() {
    return ExternalDeclarationType.FUNCTION_DEFINITION;
  }

  @Override
  public <R> R externalDeclarationAccept(ASTVisitor<R> visitor) {
    return visitor.visitFunctionDefinition(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterFunctionDefinition(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitFunctionDefinition(this);
  }

  @Override
  public FunctionDefinition clone() {
    return new FunctionDefinition(clone(functionPrototype), clone(body));
  }

  @Override
  public FunctionDefinition cloneInto(Root root) {
    return (FunctionDefinition) super.cloneInto(root);
  }
}
