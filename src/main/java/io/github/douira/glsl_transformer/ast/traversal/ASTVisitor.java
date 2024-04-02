package io.github.douira.glsl_transformer.ast.traversal;

import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.IterationConditionInitializer;
import io.github.douira.glsl_transformer.ast.node.TranslationUnit;
import io.github.douira.glsl_transformer.ast.node.VersionStatement;
import io.github.douira.glsl_transformer.ast.node.declaration.*;
import io.github.douira.glsl_transformer.ast.node.expression.*;
import io.github.douira.glsl_transformer.ast.node.expression.binary.*;
import io.github.douira.glsl_transformer.ast.node.expression.unary.*;
import io.github.douira.glsl_transformer.ast.node.external_declaration.*;
import io.github.douira.glsl_transformer.ast.node.statement.CompoundStatement;
import io.github.douira.glsl_transformer.ast.node.statement.ManyStatement;
import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.node.statement.loop.DoWhileLoopStatement;
import io.github.douira.glsl_transformer.ast.node.statement.loop.ForLoopStatement;
import io.github.douira.glsl_transformer.ast.node.statement.loop.LoopStatement;
import io.github.douira.glsl_transformer.ast.node.statement.loop.WhileLoopStatement;
import io.github.douira.glsl_transformer.ast.node.statement.selection.SelectionStatement;
import io.github.douira.glsl_transformer.ast.node.statement.selection.SwitchStatement;
import io.github.douira.glsl_transformer.ast.node.statement.terminal.*;
import io.github.douira.glsl_transformer.ast.node.type.FullySpecifiedType;
import io.github.douira.glsl_transformer.ast.node.type.initializer.ExpressionInitializer;
import io.github.douira.glsl_transformer.ast.node.type.initializer.Initializer;
import io.github.douira.glsl_transformer.ast.node.type.initializer.NestedInitializer;
import io.github.douira.glsl_transformer.ast.node.type.qualifier.*;
import io.github.douira.glsl_transformer.ast.node.type.specifier.*;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructBody;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructDeclarator;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructMember;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructSpecifier;

/**
 * The AST visitor knows how to traverse the AST and visit each node.
 * Information about the order and structure of each node is encoded in this
 * visitor.
 */
public interface ASTVisitor<R> extends GeneralASTVisitor<R> {
  default R visitTranslationUnit(TranslationUnit node) {
    var result = initialResult();
    result = visitSafe(result, node.getVersionStatement());
    visitChildren(result, node);
    return result;
  }

  default R visitVersionStatement(VersionStatement node) {
    return visitData(node.profile);
  }

  default R visitExternalDeclaration(ExternalDeclaration node) {
    return superNodeTypeResult();
  }

  default R visitFunctionDefinition(FunctionDefinition node) {
    return visitTwoChildren(node.getFunctionPrototype(), node.getBody());
  }

  default R visitEmptyDeclaration(EmptyDeclaration node) {
    return defaultResult();
  }

  default R visitPragmaDirective(PragmaDirective node) {
    var result = visitData(node.stdGL);
    result = visitData(result, node.type);
    result = visitData(result, node.getCustomName());
    return visitData(result, node.state);
  }

  default R visitExtensionDirective(ExtensionDirective node) {
    var result = visitData(superNodeTypeResult(), node.getName());
    return visitData(result, node.behavior);
  }

  default R visitCustomDirective(CustomDirective node) {
    return visitData(node.getContent());
  }

  default R visitIncludeDirective(IncludeDirective node) {
    return visitData(node.getContent());
  }

  default R visitDeclarationExternalDeclaration(DeclarationExternalDeclaration node) {
    return visit(node.getDeclaration());
  }

  default R visitLayoutDefaults(LayoutDefaults node) {
    var result = visit(node.getQualifier());
    result = aggregateResult(result, visitData(node.mode));
    return result;
  }

  default R visitExpression(Expression node) {
    return superNodeTypeResult();
  }

  default R visitUnaryExpression(UnaryExpression node) {
    return superNodeTypeResult();
  }

  default R visitBitwiseNotExpression(BitwiseNotExpression node) {
    return visit(node.getOperand());
  }

  default R visitBooleanNotExpression(BooleanNotExpression node) {
    return visit(node.getOperand());
  }

  default R visitDecrementPostfixExpression(DecrementPostfixExpression node) {
    return visit(node.getOperand());
  }

  default R visitDecrementPrefixExpression(DecrementPrefixExpression node) {
    return visit(node.getOperand());
  }

  default R visitFunctionCallExpression(FunctionCallExpression node) {
    var result = visitTwoChildren(
        node.getFunctionName(),
        node.getFunctionSpecifier());
    return visitChildren(result, node.getParameters());
  }

  default R visitGroupingExpression(GroupingExpression node) {
    return visit(node.getOperand());
  }

  default R visitIncrementPostfixExpression(IncrementPostfixExpression node) {
    return visit(node.getOperand());
  }

  default R visitIncrementPrefixExpression(IncrementPrefixExpression node) {
    return visit(node.getOperand());
  }

  default R visitMemberAccessExpression(MemberAccessExpression node) {
    return visitTwoChildren(node.getOperand(), node.getMember());
  }

  default R visitLengthAccessExpression(LengthAccessExpression node) {
    return visit(node.getOperand());
  }

  default R visitNegationExpression(NegationExpression node) {
    return visit(node.getOperand());
  }

  default R visitIdentityExpression(IdentityExpression node) {
    return visit(node.getOperand());
  }

  default R visitBinaryExpression(BinaryExpression node) {
    return superNodeTypeResult();
  }

  default R visitArrayAccessExpression(ArrayAccessExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitMultiplicationExpression(MultiplicationExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitDivisionExpression(DivisionExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitModuloExpression(ModuloExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitAdditionExpression(AdditionExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitSubtractionExpression(SubtractionExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitLeftShiftExpression(LeftShiftExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitRightShiftExpression(RightShiftExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitLessThanExpression(LessThanExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitGreaterThanExpression(GreaterThanExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitLessThanEqualExpression(LessThanEqualExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitGreaterThanEqualExpression(GreaterThanEqualExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitEqualityExpression(EqualityExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitInequalityExpression(InequalityExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBitwiseAndExpression(BitwiseAndExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBitwiseXorExpression(BitwiseXorExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBitwiseOrExpression(BitwiseOrExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBooleanAndExpression(BooleanAndExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBooleanXorExpression(BooleanXorExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBooleanOrExpression(BooleanOrExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitAssignmentExpression(AssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitMultiplicationAssignmentExpression(MultiplicationAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitDivisionAssignmentExpression(DivisionAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitModuloAssignmentExpression(ModuloAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitAdditionAssignmentExpression(AdditionAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitSubtractionAssignmentExpression(SubtractionAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitLeftShiftAssignmentExpression(LeftShiftAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitRightShiftAssignmentExpression(RightShiftAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBitwiseAndAssignmentExpression(BitwiseAndAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBitwiseXorAssignmentExpression(BitwiseXorAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitBitwiseOrAssignmentExpression(BitwiseOrAssignmentExpression node) {
    return visitTwoChildren(node.getLeft(), node.getRight());
  }

  default R visitTernaryExpression(TernaryExpression node) {
    return superNodeTypeResult();
  }

  default R visitConditionExpression(ConditionExpression node) {
    return visitThreeChildren(
        node.getCondition(),
        node.getTrueExpression(),
        node.getFalseExpression());
  }

  default R visitManyExpression(ManyExpression node) {
    return superNodeTypeResult();
  }

  default R visitSequenceExpression(SequenceExpression node) {
    return visitChildren(node);
  }

  default R visitTerminalExpression(TerminalExpression node) {
    return superNodeTypeResult();
  }

  default R visitReferenceExpression(ReferenceExpression node) {
    return visit(node.getIdentifier());
  }

  default R visitLiteralExpression(LiteralExpression node) {
    var result = visitData(node.getType());
    result = visitData(result, node.getNumber());
    return node.isInteger() ? visitData(result, node.getIntegerFormat()) : result;
  }

  default R visitStatement(Statement node) {
    return superNodeTypeResult();
  }

  default R visitEmptyStatement(EmptyStatement node) {
    return defaultResult();
  }

  default R visitCompoundStatement(CompoundStatement node) {
    return visitChildren(node);
  }

  default R visitDeclarationStatement(DeclarationStatement node) {
    return visit(node.getDeclaration());
  }

  default R visitExpressionStatement(ExpressionStatement node) {
    return visit(node.getExpression());
  }

  default R visitSelectionStatement(SelectionStatement node) {
    return visitThreeChildren(node.getCondition(), node.getIfTrue(), node.getIfFalse());
  }

  default R visitSwitchStatement(SwitchStatement node) {
    return visitTwoChildren(node.getExpression(), node.getStatement());
  }

  default R visitCaseStatement(CaseStatement node) {
    return visit(node.getExpression());
  }

  default R visitDefaultStatement(DefaultStatement node) {
    return defaultResult();
  }

  default R visitCaseLabelStatement(CaseLabelStatement node) {
    return superNodeTypeResult();
  }

  default R visitForLoopStatement(ForLoopStatement node) {
    var result = initialResult();
    result = visitSafe(result, node.getInitExpression());
    result = visitSafe(result, node.getInitDeclaration());
    result = visitSafe(result, node.getCondition());
    result = visitSafe(result, node.getIterationConditionInitializer());
    result = visitSafe(result, node.getIncrementer());
    return visit(result, node.getStatement());
  }

  default R visitWhileLoopStatement(WhileLoopStatement node) {
    return visitTwoChildren(node.getCondition(), node.getStatement());
  }

  default R visitDoWhileLoopStatement(DoWhileLoopStatement node) {
    return visitTwoChildren(node.getStatement(), node.getCondition());
  }

  default R visitContinueStatement(ContinueStatement node) {
    return defaultResult();
  }

  default R visitBreakStatement(BreakStatement node) {
    return defaultResult();
  }

  default R visitReturnStatement(ReturnStatement node) {
    return visitSafe(initialResult(), node.getExpression());
  }

  default R visitDiscardStatement(DiscardStatement node) {
    return defaultResult();
  }

  default R visitIgnoreIntersectionStatement(IgnoreIntersectionStatement node) {
    return defaultResult();
  }

  default R visitTerminateRayStatement(TerminateRayStatement node) {
    return defaultResult();
  }

  default R visitDemoteStatement(DemoteStatement node) {
    return defaultResult();
  }

  default R visitManyStatement(ManyStatement node) {
    return superNodeTypeResult();
  }

  default R visitLoopStatement(LoopStatement node) {
    return superNodeTypeResult();
  }

  default R visitTerminalStatement(TerminalStatement node) {
    return superNodeTypeResult();
  }

  default R visitSemiTerminalStatement(SemiTerminalStatement node) {
    return superNodeTypeResult();
  }

  default R visitDeclaration(Declaration node) {
    return superNodeTypeResult();
  }

  default R visitDeclarationMember(DeclarationMember node) {
    return visitThreeChildren(node.getName(), node.getArraySpecifier(), node.getInitializer());
  }

  default R visitFunctionDeclaration(FunctionDeclaration node) {
    return visit(node.getFunctionPrototype());
  }

  default R visitFunctionParameter(FunctionParameter node) {
    return visitThreeChildren(node.getType(), node.getName(), node.getArraySpecifier());
  }

  default R visitInterfaceBlockDeclaration(InterfaceBlockDeclaration node) {
    var result = visit(node.getTypeQualifier());
    result = visit(result, node.getBlockName());
    result = visit(result, node.getStructBody());
    result = visitSafe(result, node.getVariableName());
    return visitSafe(result, node.getArraySpecifier());
  }

  default R visitPrecisionDeclaration(PrecisionDeclaration node) {
    return visitTwoChildren(node.getPrecisionQualifier(), node.getTypeSpecifier());
  }

  default R visitTypeAndInitDeclaration(TypeAndInitDeclaration node) {
    return visitChildren(visit(node.getType()), node.getMembers());
  }

  default R visitVariableDeclaration(VariableDeclaration node) {
    return visitChildren(visit(node.getTypeQualifier()), node.getNames());
  }

  default R visitExpressionInitializer(ExpressionInitializer node) {
    return visit(node.getExpression());
  }

  default R visitInitializer(Initializer node) {
    return superNodeTypeResult();
  }

  default R visitNestedInitializer(NestedInitializer node) {
    return visitChildren(node.getInitializers());
  }

  default R visitInterpolationQualifier(InterpolationQualifier node) {
    return visitData(node.interpolationType);
  }

  default R visitInvariantQualifier(InvariantQualifier node) {
    return defaultResult();
  }

  default R visitLayoutQualifier(LayoutQualifier node) {
    return visitChildren(node.getParts());
  }

  default R visitLayoutQualifierPart(LayoutQualifierPart node) {
    return superNodeTypeResult();
  }

  default R visitNamedLayoutQualifierPart(NamedLayoutQualifierPart node) {
    return visitTwoChildren(node.getName(), node.getExpression());
  }

  default R visitPreciseQualifier(PreciseQualifier node) {
    return defaultResult();
  }

  default R visitPrecisionQualifier(PrecisionQualifier node) {
    return visitData(node.precisionLevel);
  }

  default R visitSharedLayoutQualifierPart(SharedLayoutQualifierPart node) {
    return defaultResult();
  }

  default R visitStorageQualifier(StorageQualifier node) {
    var result = visitChildren(node.getTypeNames());
    return visitData(result, node.storageType);
  }

  default R visitTypeQualifier(TypeQualifier node) {
    return visitChildren(node);
  }

  default R visitTypeQualifierPart(TypeQualifierPart node) {
    return superNodeTypeResult();
  }

  default R visitArraySpecifier(ArraySpecifier node) {
    return visitChildren(node);
  }

  default R visitBuiltinFixedTypeSpecifier(BuiltinFixedTypeSpecifier node) {
    return visitData(node.type);
  }

  default R visitBuiltinNumericTypeSpecifier(BuiltinNumericTypeSpecifier node) {
    return visitData(node.type);
  }

  default R visitTypeReference(TypeReference node) {
    return visit(node.getReference());
  }

  default R visitTypeSpecifier(TypeSpecifier node) {
    return superNodeTypeResult();
  }

  default R visitStructBody(StructBody node) {
    return visitChildren(node);
  }

  default R visitStructDeclarator(StructDeclarator node) {
    return visitTwoChildren(node.getName(), node.getArraySpecifier());
  }

  default R visitStructMember(StructMember node) {
    return visitChildren(visit(node.getType()), node.getDeclarators());
  }

  default R visitStructSpecifier(StructSpecifier node) {
    return visitTwoChildren(node.getName(), node.getStructBody());
  }

  default R visitFullySpecifiedType(FullySpecifiedType node) {
    return visitTwoChildren(node.getTypeQualifier(), node.getTypeSpecifier());
  }

  default R visitIterationConditionInitializer(IterationConditionInitializer node) {
    return visitThreeChildren(node.getType(), node.getName(), node.getInitializer());
  }

  default R visitFunctionPrototype(FunctionPrototype node) {
    return visitChildren(visitTwoChildren(node.getReturnType(), node.getName()), node);
  }

  default R visitIdentifier(Identifier node) {
    return visitData(node.getName());
  }
}
