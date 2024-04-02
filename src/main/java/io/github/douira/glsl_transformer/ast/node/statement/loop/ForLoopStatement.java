package io.github.douira.glsl_transformer.ast.node.statement.loop;

import io.github.douira.glsl_transformer.ast.node.IterationConditionInitializer;
import io.github.douira.glsl_transformer.ast.node.declaration.Declaration;
import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public class ForLoopStatement extends LoopStatement {
  protected Expression initExpression; // TODO: nullable
  protected Declaration initDeclaration; // TODO: nullable
  protected Expression condition; // TODO: nullable
  protected IterationConditionInitializer iterationConditionInitializer; // TODO: nullable
  protected Expression incrementer; // TODO: nullable

  public ForLoopStatement(
      Statement statement,
      Expression initExpression,
      Expression condition,
      Expression incrementer) {
    super(statement);
    this.initExpression = setup(initExpression, this::setInitExpression);
    this.condition = setup(condition, this::setCondition);
    this.incrementer = setup(incrementer, this::setIncrementer);
  }

  public ForLoopStatement(
      Statement statement,
      Declaration initDeclaration,
      Expression condition,
      Expression incrementer) {
    super(statement);
    this.initDeclaration = setup(initDeclaration, this::setInitDeclaration);
    this.condition = setup(condition, this::setCondition);
    this.incrementer = setup(incrementer, this::setIncrementer);
  }

  public ForLoopStatement(
      Statement statement,
      Expression initExpression,
      IterationConditionInitializer iterationConditionInitializer,
      Expression incrementer) {
    super(statement);
    this.initExpression = setup(initExpression, this::setInitExpression);
    this.iterationConditionInitializer = setup(iterationConditionInitializer, this::setIterationConditionInitializer);
    this.incrementer = setup(incrementer, this::setIncrementer);
  }

  public ForLoopStatement(
      Statement statement,
      Declaration initDeclaration,
      IterationConditionInitializer iterationConditionInitializer,
      Expression incrementer) {
    super(statement);
    this.initDeclaration = setup(initDeclaration, this::setInitDeclaration);
    this.iterationConditionInitializer = setup(iterationConditionInitializer, this::setIterationConditionInitializer);
    this.incrementer = setup(incrementer, this::setIncrementer);
  }

  public ForLoopStatement(Statement statement) {
    super(statement);
  }

  public ForLoopStatement(
      Expression initExpression,
      Declaration initDeclaration,
      Expression condition,
      IterationConditionInitializer iterationConditionInitializer,
      Expression incrementer,
      Statement statement) {
    super(statement);
    this.initExpression = setup(initExpression, this::setInitExpression);
    this.initDeclaration = setup(initDeclaration, this::setInitDeclaration);
    this.condition = setup(condition, this::setCondition);
    this.iterationConditionInitializer = setup(iterationConditionInitializer, this::setIterationConditionInitializer);
    this.incrementer = setup(incrementer, this::setIncrementer);
  }

  public Expression getInitExpression() {
    return initExpression;
  }

  public void setInitExpression(Expression initExpression) {
    updateParents(this.initExpression, initExpression, this::setInitExpression);
    this.initExpression = initExpression;
  }

  public Declaration getInitDeclaration() {
    return initDeclaration;
  }

  public void setInitDeclaration(Declaration initDeclaration) {
    updateParents(this.initDeclaration, initDeclaration, this::setInitDeclaration);
    this.initDeclaration = initDeclaration;
  }

  public Expression getCondition() {
    return condition;
  }

  public void setCondition(Expression condition) {
    updateParents(this.condition, condition, this::setCondition);
    this.condition = condition;
  }

  public IterationConditionInitializer getIterationConditionInitializer() {
    return iterationConditionInitializer;
  }

  public void setIterationConditionInitializer(IterationConditionInitializer iterationConditionInitializer) {
    updateParents(this.iterationConditionInitializer, iterationConditionInitializer,
        this::setIterationConditionInitializer);
    this.iterationConditionInitializer = iterationConditionInitializer;
  }

  public Expression getIncrementer() {
    return incrementer;
  }

  public void setIncrementer(Expression incrementer) {
    updateParents(this.incrementer, incrementer, this::setIncrementer);
    this.incrementer = incrementer;
  }

  @Override
  public StatementType getStatementType() {
    return StatementType.FOR_LOOP;
  }

  @Override
  public <R> R statementAccept(ASTVisitor<R> visitor) {
    return visitor.visitForLoopStatement(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    super.enterNode(listener);
    listener.enterForLoopStatement(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    super.exitNode(listener);
    listener.exitForLoopStatement(this);
  }

  @Override
  public ForLoopStatement clone() {
    return new ForLoopStatement(
        clone(initExpression),
        clone(initDeclaration),
        clone(condition),
        clone(iterationConditionInitializer),
        clone(incrementer),
        clone(statement));
  }

  @Override
  public ForLoopStatement cloneInto(Root root) {
    return (ForLoopStatement) super.cloneInto(root);
  }
}
