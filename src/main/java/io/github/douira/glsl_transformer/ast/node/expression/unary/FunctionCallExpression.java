package io.github.douira.glsl_transformer.ast.node.expression.unary;

import io.github.douira.glsl_transformer.ast.data.ChildNodeList;
import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.expression.TerminalExpression;
import io.github.douira.glsl_transformer.ast.node.type.specifier.TypeSpecifier;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

import java.util.stream.Stream;

public class FunctionCallExpression extends TerminalExpression {
  public enum FunctionReferenceType {
    NAME,
    TYPE_SPECIFIER
  }

  protected Identifier functionName;
  protected TypeSpecifier functionSpecifier;
  protected FunctionReferenceType referenceType;

  protected ChildNodeList<Expression> parameters;

  private FunctionCallExpression(Identifier functionName,
      TypeSpecifier functionSpecifier,
      FunctionReferenceType referenceType,
      Stream<Expression> parameters) {
    this.functionName = setup(functionName, this::setFunctionName);
    this.functionSpecifier = setup(functionSpecifier, this::setFunctionSpecifier);
    this.referenceType = referenceType;
    this.parameters = ChildNodeList.collect(parameters, this);
  }

  public FunctionCallExpression(Identifier functionName) {
    this.functionName = setup(functionName, this::setFunctionName);
    referenceType = FunctionReferenceType.NAME;
    parameters = new ChildNodeList<>(this);
  }

  public FunctionCallExpression(TypeSpecifier functionSpecifier) {
    this.functionSpecifier = setup(functionSpecifier, this::setFunctionSpecifier);
    referenceType = FunctionReferenceType.TYPE_SPECIFIER;
    parameters = new ChildNodeList<>(this);
  }

  public FunctionCallExpression(
      Identifier functionName,
      Stream<Expression> parameters) {
    this(functionName);
    this.parameters = ChildNodeList.collect(parameters, this);
  }

  public FunctionCallExpression(
      TypeSpecifier functionSpecifier,
      Stream<Expression> parameters) {
    this(functionSpecifier);
    this.parameters = ChildNodeList.collect(parameters, this);
  }

  public Identifier getFunctionName() {
    return functionName;
  }

  protected void setFunctionName(Identifier functionName) {
    updateParents(this.functionName, functionName, this::setFunctionName);
    this.functionName = functionName;
  }

  public void useFunctionName(Identifier functionName) {
    setFunctionName(functionName);
    referenceType = FunctionReferenceType.NAME;
    setFunctionSpecifier(null);
  }

  public TypeSpecifier getFunctionSpecifier() {
    return functionSpecifier;
  }

  protected void setFunctionSpecifier(TypeSpecifier functionSpecifier) {
    updateParents(this.functionSpecifier, functionSpecifier, this::setFunctionSpecifier);
    this.functionSpecifier = functionSpecifier;
  }

  public void useFunctionSpecifier(TypeSpecifier functionSpecifier) {
    setFunctionSpecifier(functionSpecifier);
    referenceType = FunctionReferenceType.TYPE_SPECIFIER;
    setFunctionName(null);
  }

  public FunctionReferenceType getReferenceType() {
    return referenceType;
  }

  public ASTNode getReference() {
    return referenceType == FunctionReferenceType.NAME ? functionName : functionSpecifier;
  }

  public ChildNodeList<Expression> getParameters() {
    return parameters;
  }

  @Override
  public ExpressionType getExpressionType() {
    return ExpressionType.FUNCTION_CALL;
  }

  @Override
  public <R> R expressionAccept(ASTVisitor<R> visitor) {
    return visitor.visitFunctionCallExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterFunctionCallExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitFunctionCallExpression(this);
  }

  @Override
  public FunctionCallExpression clone() {
    return new FunctionCallExpression(clone(functionName), clone(functionSpecifier), referenceType, clone(parameters));
  }

  @Override
  public FunctionCallExpression cloneInto(Root root) {
    return (FunctionCallExpression) super.cloneInto(root);
  }
}
