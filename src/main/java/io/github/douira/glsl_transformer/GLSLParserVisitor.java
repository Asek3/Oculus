// Generated from java-escape by ANTLR 4.11.1
package io.github.douira.glsl_transformer;

import repack.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GLSLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GLSLParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GLSLParser#translationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTranslationUnit(GLSLParser.TranslationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#versionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVersionStatement(GLSLParser.VersionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#externalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExternalDeclaration(GLSLParser.ExternalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyDeclaration(GLSLParser.EmptyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#pragmaDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPragmaDirective(GLSLParser.PragmaDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#extensionDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensionDirective(GLSLParser.ExtensionDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#customDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomDirective(GLSLParser.CustomDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#includeDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncludeDirective(GLSLParser.IncludeDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#layoutDefaults}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutDefaults(GLSLParser.LayoutDefaultsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#functionDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(GLSLParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(GLSLParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code referenceExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceExpression(GLSLParser.ReferenceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(GLSLParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relationalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(GLSLParser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalExclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalExclusiveOrExpression(GLSLParser.LogicalExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(GLSLParser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(GLSLParser.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code lengthAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLengthAccessExpression(GLSLParser.LengthAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(GLSLParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code groupingExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGroupingExpression(GLSLParser.GroupingExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAccessExpression(GLSLParser.ArrayAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixExpression(GLSLParser.PrefixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitwiseInclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseInclusiveOrExpression(GLSLParser.BitwiseInclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalInclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalInclusiveOrExpression(GLSLParser.LogicalInclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitwiseAndExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(GLSLParser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(GLSLParser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(GLSLParser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCallExpression(GLSLParser.FunctionCallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bitwiseExclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseExclusiveOrExpression(GLSLParser.BitwiseExclusiveOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessExpression(GLSLParser.MemberAccessExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(GLSLParser.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postfixExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(GLSLParser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GLSLParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(GLSLParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code interfaceBlockDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceBlockDeclaration(GLSLParser.InterfaceBlockDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code variableDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(GLSLParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code precisionDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecisionDeclaration(GLSLParser.PrecisionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeAndInitDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAndInitDeclaration(GLSLParser.TypeAndInitDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#functionPrototype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPrototype(GLSLParser.FunctionPrototypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#functionParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameterList(GLSLParser.FunctionParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterDeclaration(GLSLParser.ParameterDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(GLSLParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#singleAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAttribute(GLSLParser.SingleAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#declarationMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationMember(GLSLParser.DeclarationMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#fullySpecifiedType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullySpecifiedType(GLSLParser.FullySpecifiedTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#storageQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStorageQualifier(GLSLParser.StorageQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#layoutQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLayoutQualifier(GLSLParser.LayoutQualifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namedLayoutQualifier}
	 * labeled alternative in {@link GLSLParser#layoutQualifierId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedLayoutQualifier(GLSLParser.NamedLayoutQualifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code sharedLayoutQualifier}
	 * labeled alternative in {@link GLSLParser#layoutQualifierId}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSharedLayoutQualifier(GLSLParser.SharedLayoutQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#precisionQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrecisionQualifier(GLSLParser.PrecisionQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#interpolationQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterpolationQualifier(GLSLParser.InterpolationQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#invariantQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInvariantQualifier(GLSLParser.InvariantQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#preciseQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreciseQualifier(GLSLParser.PreciseQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#typeQualifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeQualifier(GLSLParser.TypeQualifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#typeSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeSpecifier(GLSLParser.TypeSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#arraySpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySpecifier(GLSLParser.ArraySpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#arraySpecifierSegment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArraySpecifierSegment(GLSLParser.ArraySpecifierSegmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#builtinTypeSpecifierParseable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinTypeSpecifierParseable(GLSLParser.BuiltinTypeSpecifierParseableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#builtinTypeSpecifierFixed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltinTypeSpecifierFixed(GLSLParser.BuiltinTypeSpecifierFixedContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#structSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructSpecifier(GLSLParser.StructSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#structBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructBody(GLSLParser.StructBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#structMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructMember(GLSLParser.StructMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#structDeclarator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclarator(GLSLParser.StructDeclaratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#initializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializer(GLSLParser.InitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GLSLParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#compoundStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundStatement(GLSLParser.CompoundStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#declarationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclarationStatement(GLSLParser.DeclarationStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(GLSLParser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#emptyStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement(GLSLParser.EmptyStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#selectionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectionStatement(GLSLParser.SelectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#iterationCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIterationCondition(GLSLParser.IterationConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(GLSLParser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valuedCaseLabel}
	 * labeled alternative in {@link GLSLParser#caseLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValuedCaseLabel(GLSLParser.ValuedCaseLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defaultCaseLabel}
	 * labeled alternative in {@link GLSLParser#caseLabel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultCaseLabel(GLSLParser.DefaultCaseLabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(GLSLParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#doWhileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhileStatement(GLSLParser.DoWhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(GLSLParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(GLSLParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(GLSLParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(GLSLParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code discardStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDiscardStatement(GLSLParser.DiscardStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ignoreIntersectionStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIgnoreIntersectionStatement(GLSLParser.IgnoreIntersectionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code terminateRayStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminateRayStatement(GLSLParser.TerminateRayStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GLSLParser#demoteStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDemoteStatement(GLSLParser.DemoteStatementContext ctx);
}
