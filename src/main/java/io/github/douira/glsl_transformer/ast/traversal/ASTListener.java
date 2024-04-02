package io.github.douira.glsl_transformer.ast.traversal;

import io.github.douira.glsl_transformer.ast.node.IterationConditionInitializer;
import io.github.douira.glsl_transformer.ast.node.TranslationUnit;
import io.github.douira.glsl_transformer.ast.node.declaration.*;
import io.github.douira.glsl_transformer.ast.node.expression.*;
import io.github.douira.glsl_transformer.ast.node.expression.binary.*;
import io.github.douira.glsl_transformer.ast.node.expression.unary.*;
import io.github.douira.glsl_transformer.ast.node.external_declaration.DeclarationExternalDeclaration;
import io.github.douira.glsl_transformer.ast.node.external_declaration.ExternalDeclaration;
import io.github.douira.glsl_transformer.ast.node.external_declaration.FunctionDefinition;
import io.github.douira.glsl_transformer.ast.node.external_declaration.LayoutDefaults;
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
import io.github.douira.glsl_transformer.ast.node.type.specifier.ArraySpecifier;
import io.github.douira.glsl_transformer.ast.node.type.specifier.FunctionPrototype;
import io.github.douira.glsl_transformer.ast.node.type.specifier.TypeReference;
import io.github.douira.glsl_transformer.ast.node.type.specifier.TypeSpecifier;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructBody;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructDeclarator;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructMember;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructSpecifier;

/**
 * The AST listener interface has a method for entering and exiting each
 * non-terminal AST node.
 */
public interface ASTListener extends GeneralASTListener {
  default void enterTranslationUnit(TranslationUnit node) {
  }

  default void exitTranslationUnit(TranslationUnit node) {
  }

  default void enterExternalDeclaration(ExternalDeclaration node) {
  }

  default void exitExternalDeclaration(ExternalDeclaration node) {
  }

  default void enterFunctionDefinition(FunctionDefinition node) {
  }

  default void exitFunctionDefinition(FunctionDefinition node) {
  }

  default void enterLayoutDefaults(LayoutDefaults node) {
  }

  default void exitLayoutDefaults(LayoutDefaults node) {
  }

  default void enterDeclarationExternalDeclaration(DeclarationExternalDeclaration node) {
  }

  default void exitDeclarationExternalDeclaration(DeclarationExternalDeclaration node) {
  }

  default void enterExpression(Expression node) {
  }

  default void exitExpression(Expression node) {
  }

  default void enterUnaryExpression(UnaryExpression node) {
  }

  default void exitUnaryExpression(UnaryExpression node) {
  }

  default void enterBitwiseNotExpression(BitwiseNotExpression node) {
  }

  default void exitBitwiseNotExpression(BitwiseNotExpression node) {
  }

  default void enterBooleanNotExpression(BooleanNotExpression node) {
  }

  default void exitBooleanNotExpression(BooleanNotExpression node) {
  }

  default void enterDecrementPostfixExpression(DecrementPostfixExpression node) {
  }

  default void exitDecrementPostfixExpression(DecrementPostfixExpression node) {
  }

  default void enterDecrementPrefixExpression(DecrementPrefixExpression node) {
  }

  default void exitDecrementPrefixExpression(DecrementPrefixExpression node) {
  }

  default void enterFunctionCallExpression(FunctionCallExpression node) {
  }

  default void exitFunctionCallExpression(FunctionCallExpression node) {
  }

  default void enterGroupingExpression(GroupingExpression node) {
  }

  default void exitGroupingExpression(GroupingExpression node) {
  }

  default void enterIncrementPostfixExpression(IncrementPostfixExpression node) {
  }

  default void exitIncrementPostfixExpression(IncrementPostfixExpression node) {
  }

  default void enterIncrementPrefixExpression(IncrementPrefixExpression node) {
  }

  default void exitIncrementPrefixExpression(IncrementPrefixExpression node) {
  }

  default void enterMemberAccessExpression(MemberAccessExpression node) {
  }

  default void exitMemberAccessExpression(MemberAccessExpression node) {
  }

  default void enterLengthAccessExpression(LengthAccessExpression node) {
  }

  default void exitLengthAccessExpression(LengthAccessExpression node) {
  }

  default void enterNegationExpression(NegationExpression node) {
  }

  default void exitNegationExpression(NegationExpression node) {
  }

  default void enterIdentityExpression(IdentityExpression node) {
  }

  default void exitIdentityExpression(IdentityExpression node) {
  }

  default void enterBinaryExpression(BinaryExpression node) {
  }

  default void exitBinaryExpression(BinaryExpression node) {
  }

  default void enterArrayAccessExpression(ArrayAccessExpression node) {
  }

  default void exitArrayAccessExpression(ArrayAccessExpression node) {
  }

  default void enterMultiplicationExpression(MultiplicationExpression node) {
  }

  default void exitMultiplicationExpression(MultiplicationExpression node) {
  }

  default void enterDivisionExpression(DivisionExpression node) {
  }

  default void exitDivisionExpression(DivisionExpression node) {
  }

  default void enterModuloExpression(ModuloExpression node) {
  }

  default void exitModuloExpression(ModuloExpression node) {
  }

  default void enterAdditionExpression(AdditionExpression node) {
  }

  default void exitAdditionExpression(AdditionExpression node) {
  }

  default void enterSubtractionExpression(SubtractionExpression node) {
  }

  default void exitSubtractionExpression(SubtractionExpression node) {
  }

  default void enterLeftShiftExpression(LeftShiftExpression node) {
  }

  default void exitLeftShiftExpression(LeftShiftExpression node) {
  }

  default void enterRightShiftExpression(RightShiftExpression node) {
  }

  default void exitRightShiftExpression(RightShiftExpression node) {
  }

  default void enterLessThanExpression(LessThanExpression node) {
  }

  default void exitLessThanExpression(LessThanExpression node) {
  }

  default void enterGreaterThanExpression(GreaterThanExpression node) {
  }

  default void exitGreaterThanExpression(GreaterThanExpression node) {
  }

  default void enterLessThanEqualExpression(LessThanEqualExpression node) {
  }

  default void exitLessThanEqualExpression(LessThanEqualExpression node) {
  }

  default void enterGreaterThanEqualExpression(GreaterThanEqualExpression node) {
  }

  default void exitGreaterThanEqualExpression(GreaterThanEqualExpression node) {
  }

  default void enterEqualityExpression(EqualityExpression node) {
  }

  default void exitEqualityExpression(EqualityExpression node) {
  }

  default void enterInequalityExpression(InequalityExpression node) {
  }

  default void exitInequalityExpression(InequalityExpression node) {
  }

  default void enterBitwiseAndExpression(BitwiseAndExpression node) {
  }

  default void exitBitwiseAndExpression(BitwiseAndExpression node) {
  }

  default void enterBitwiseXorExpression(BitwiseXorExpression node) {
  }

  default void exitBitwiseXorExpression(BitwiseXorExpression node) {
  }

  default void enterBitwiseOrExpression(BitwiseOrExpression node) {
  }

  default void exitBitwiseOrExpression(BitwiseOrExpression node) {
  }

  default void enterBooleanAndExpression(BooleanAndExpression node) {
  }

  default void exitBooleanAndExpression(BooleanAndExpression node) {
  }

  default void enterBooleanXorExpression(BooleanXorExpression node) {
  }

  default void exitBooleanXorExpression(BooleanXorExpression node) {
  }

  default void enterBooleanOrExpression(BooleanOrExpression node) {
  }

  default void exitBooleanOrExpression(BooleanOrExpression node) {
  }

  default void enterAssignmentExpression(AssignmentExpression node) {
  }

  default void exitAssignmentExpression(AssignmentExpression node) {
  }

  default void enterMultiplicationAssignmentExpression(MultiplicationAssignmentExpression node) {
  }

  default void exitMultiplicationAssignmentExpression(MultiplicationAssignmentExpression node) {
  }

  default void enterDivisionAssignmentExpression(DivisionAssignmentExpression node) {
  }

  default void exitDivisionAssignmentExpression(DivisionAssignmentExpression node) {
  }

  default void enterModuloAssignmentExpression(ModuloAssignmentExpression node) {
  }

  default void exitModuloAssignmentExpression(ModuloAssignmentExpression node) {
  }

  default void enterAdditionAssignmentExpression(AdditionAssignmentExpression node) {
  }

  default void exitAdditionAssignmentExpression(AdditionAssignmentExpression node) {
  }

  default void enterSubtractionAssignmentExpression(SubtractionAssignmentExpression node) {
  }

  default void exitSubtractionAssignmentExpression(SubtractionAssignmentExpression node) {
  }

  default void enterLeftShiftAssignmentExpression(LeftShiftAssignmentExpression node) {
  }

  default void exitLeftShiftAssignmentExpression(LeftShiftAssignmentExpression node) {
  }

  default void enterRightShiftAssignmentExpression(RightShiftAssignmentExpression node) {
  }

  default void exitRightShiftAssignmentExpression(RightShiftAssignmentExpression node) {
  }

  default void enterBitwiseAndAssignmentExpression(BitwiseAndAssignmentExpression node) {
  }

  default void exitBitwiseAndAssignmentExpression(BitwiseAndAssignmentExpression node) {
  }

  default void enterBitwiseXorAssignmentExpression(BitwiseXorAssignmentExpression node) {
  }

  default void exitBitwiseXorAssignmentExpression(BitwiseXorAssignmentExpression node) {
  }

  default void enterBitwiseOrAssignmentExpression(BitwiseOrAssignmentExpression node) {
  }

  default void exitBitwiseOrAssignmentExpression(BitwiseOrAssignmentExpression node) {
  }

  default void enterTernaryExpression(TernaryExpression node) {
  }

  default void exitTernaryExpression(TernaryExpression node) {
  }

  default void enterConditionExpression(ConditionExpression node) {
  }

  default void exitConditionExpression(ConditionExpression node) {
  }

  default void enterManyExpression(ManyExpression node) {
  }

  default void exitManyExpression(ManyExpression node) {
  }

  default void enterSequenceExpression(SequenceExpression node) {
  }

  default void exitSequenceExpression(SequenceExpression node) {
  }

  default void enterReferenceExpression(ReferenceExpression node) {
  }

  default void exitReferenceExpression(ReferenceExpression node) {
  }

  default void enterLiteralExpression(LiteralExpression node) {
  }

  default void exitLiteralExpression(LiteralExpression node) {
  }

  default void enterStatement(Statement node) {
  }

  default void exitStatement(Statement node) {
  }

  default void enterCompoundStatement(CompoundStatement node) {
  }

  default void exitCompoundStatement(CompoundStatement node) {
  }

  default void enterDeclarationStatement(DeclarationStatement node) {
  }

  default void exitDeclarationStatement(DeclarationStatement node) {
  }

  default void enterExpressionStatement(ExpressionStatement node) {
  }

  default void exitExpressionStatement(ExpressionStatement node) {
  }

  default void enterSelectionStatement(SelectionStatement node) {
  }

  default void exitSelectionStatement(SelectionStatement node) {
  }

  default void enterSwitchStatement(SwitchStatement node) {
  }

  default void exitSwitchStatement(SwitchStatement node) {
  }

  default void enterCaseLabelStatement(CaseLabelStatement node) {
  }

  default void exitCaseLabelStatement(CaseLabelStatement node) {
  }

  default void enterForLoopStatement(ForLoopStatement node) {
  }

  default void exitForLoopStatement(ForLoopStatement node) {
  }

  default void enterWhileLoopStatement(WhileLoopStatement node) {
  }

  default void exitWhileLoopStatement(WhileLoopStatement node) {
  }

  default void enterDoWhileLoopStatement(DoWhileLoopStatement node) {
  }

  default void exitDoWhileLoopStatement(DoWhileLoopStatement node) {
  }

  default void enterManyStatement(ManyStatement node) {
  }

  default void exitManyStatement(ManyStatement node) {
  }

  default void enterLoopStatement(LoopStatement node) {
  }

  default void exitLoopStatement(LoopStatement node) {
  }

  default void enterSemiTerminalStatement(SemiTerminalStatement node) {
  }

  default void exitSemiTerminalStatement(SemiTerminalStatement node) {
  }

  default void enterCaseStatement(CaseStatement node) {
  }

  default void exitCaseStatement(CaseStatement node) {
  }

  default void enterDeclaration(Declaration node) {
  }

  default void exitDeclaration(Declaration node) {
  }

  default void enterDeclarationMember(DeclarationMember node) {
  }

  default void exitDeclarationMember(DeclarationMember node) {
  }

  default void enterFunctionDeclaration(FunctionDeclaration node) {
  }

  default void exitFunctionDeclaration(FunctionDeclaration node) {
  }

  default void enterFunctionParameter(FunctionParameter node) {
  }

  default void exitFunctionParameter(FunctionParameter node) {
  }

  default void enterInterfaceBlockDeclaration(InterfaceBlockDeclaration node) {
  }

  default void exitInterfaceBlockDeclaration(InterfaceBlockDeclaration node) {
  }

  default void enterPrecisionDeclaration(PrecisionDeclaration node) {
  }

  default void exitPrecisionDeclaration(PrecisionDeclaration node) {
  }

  default void enterTypeAndInitDeclaration(TypeAndInitDeclaration node) {
  }

  default void exitTypeAndInitDeclaration(TypeAndInitDeclaration node) {
  }

  default void enterVariableDeclaration(VariableDeclaration node) {
  }

  default void exitVariableDeclaration(VariableDeclaration node) {
  }

  default void enterExpressionInitializer(ExpressionInitializer node) {
  }

  default void exitExpressionInitializer(ExpressionInitializer node) {
  }

  default void enterInitializer(Initializer node) {
  }

  default void exitInitializer(Initializer node) {
  }

  default void enterNestedInitializer(NestedInitializer node) {
  }

  default void exitNestedInitializer(NestedInitializer node) {
  }

  default void enterLayoutQualifier(LayoutQualifier node) {
  }

  default void exitLayoutQualifier(LayoutQualifier node) {
  }

  default void enterLayoutQualifierPart(LayoutQualifierPart node) {
  }

  default void exitLayoutQualifierPart(LayoutQualifierPart node) {
  }

  default void enterNamedLayoutQualifierPart(NamedLayoutQualifierPart node) {
  }

  default void exitNamedLayoutQualifierPart(NamedLayoutQualifierPart node) {
  }

  default void enterStorageQualifier(StorageQualifier node) {
  }

  default void exitStorageQualifier(StorageQualifier node) {
  }

  default void enterTypeQualifier(TypeQualifier node) {
  }

  default void exitTypeQualifier(TypeQualifier node) {
  }

  default void enterTypeQualifierPart(TypeQualifierPart node) {
  }

  default void exitTypeQualifierPart(TypeQualifierPart node) {
  }

  default void enterArraySpecifier(ArraySpecifier node) {
  }

  default void exitArraySpecifier(ArraySpecifier node) {
  }

  default void enterTypeReference(TypeReference node) {
  }

  default void exitTypeReference(TypeReference node) {
  }

  default void enterTypeSpecifier(TypeSpecifier node) {
  }

  default void exitTypeSpecifier(TypeSpecifier node) {
  }

  default void enterStructBody(StructBody node) {
  }

  default void exitStructBody(StructBody node) {
  }

  default void enterStructDeclarator(StructDeclarator node) {
  }

  default void exitStructDeclarator(StructDeclarator node) {
  }

  default void enterStructMember(StructMember node) {
  }

  default void exitStructMember(StructMember node) {
  }

  default void enterStructSpecifier(StructSpecifier node) {
  }

  default void exitStructSpecifier(StructSpecifier node) {
  }

  default void enterFullySpecifiedType(FullySpecifiedType node) {
  }

  default void exitFullySpecifiedType(FullySpecifiedType node) {
  }

  default void enterIterationConditionInitializer(IterationConditionInitializer node) {
  }

  default void exitIterationConditionInitializer(IterationConditionInitializer node) {
  }

  default void enterFunctionPrototype(FunctionPrototype node) {
  }

  default void exitFunctionPrototype(FunctionPrototype node) {
  }
}
