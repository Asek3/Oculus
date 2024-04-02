// Generated from java-escape by ANTLR 4.11.1
package io.github.douira.glsl_transformer;

import repack.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GLSLParser}.
 */
public interface GLSLParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GLSLParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void enterTranslationUnit(GLSLParser.TranslationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#translationUnit}.
	 * @param ctx the parse tree
	 */
	void exitTranslationUnit(GLSLParser.TranslationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#versionStatement}.
	 * @param ctx the parse tree
	 */
	void enterVersionStatement(GLSLParser.VersionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#versionStatement}.
	 * @param ctx the parse tree
	 */
	void exitVersionStatement(GLSLParser.VersionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#externalDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterExternalDeclaration(GLSLParser.ExternalDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#externalDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitExternalDeclaration(GLSLParser.ExternalDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEmptyDeclaration(GLSLParser.EmptyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#emptyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEmptyDeclaration(GLSLParser.EmptyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#pragmaDirective}.
	 * @param ctx the parse tree
	 */
	void enterPragmaDirective(GLSLParser.PragmaDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#pragmaDirective}.
	 * @param ctx the parse tree
	 */
	void exitPragmaDirective(GLSLParser.PragmaDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#extensionDirective}.
	 * @param ctx the parse tree
	 */
	void enterExtensionDirective(GLSLParser.ExtensionDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#extensionDirective}.
	 * @param ctx the parse tree
	 */
	void exitExtensionDirective(GLSLParser.ExtensionDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#customDirective}.
	 * @param ctx the parse tree
	 */
	void enterCustomDirective(GLSLParser.CustomDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#customDirective}.
	 * @param ctx the parse tree
	 */
	void exitCustomDirective(GLSLParser.CustomDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void enterIncludeDirective(GLSLParser.IncludeDirectiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#includeDirective}.
	 * @param ctx the parse tree
	 */
	void exitIncludeDirective(GLSLParser.IncludeDirectiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#layoutDefaults}.
	 * @param ctx the parse tree
	 */
	void enterLayoutDefaults(GLSLParser.LayoutDefaultsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#layoutDefaults}.
	 * @param ctx the parse tree
	 */
	void exitLayoutDefaults(GLSLParser.LayoutDefaultsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(GLSLParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#functionDefinition}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(GLSLParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(GLSLParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code shiftExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(GLSLParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code referenceExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterReferenceExpression(GLSLParser.ReferenceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code referenceExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitReferenceExpression(GLSLParser.ReferenceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(GLSLParser.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additiveExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(GLSLParser.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relationalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(GLSLParser.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relationalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(GLSLParser.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalExclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalExclusiveOrExpression(GLSLParser.LogicalExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalExclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalExclusiveOrExpression(GLSLParser.LogicalExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalExpression(GLSLParser.ConditionalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalExpression(GLSLParser.ConditionalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(GLSLParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(GLSLParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lengthAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterLengthAccessExpression(GLSLParser.LengthAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lengthAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitLengthAccessExpression(GLSLParser.LengthAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(GLSLParser.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicativeExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(GLSLParser.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code groupingExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterGroupingExpression(GLSLParser.GroupingExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code groupingExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitGroupingExpression(GLSLParser.GroupingExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccessExpression(GLSLParser.ArrayAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccessExpression(GLSLParser.ArrayAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpression(GLSLParser.PrefixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpression(GLSLParser.PrefixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitwiseInclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseInclusiveOrExpression(GLSLParser.BitwiseInclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitwiseInclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseInclusiveOrExpression(GLSLParser.BitwiseInclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalInclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalInclusiveOrExpression(GLSLParser.LogicalInclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalInclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalInclusiveOrExpression(GLSLParser.LogicalInclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitwiseAndExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseAndExpression(GLSLParser.BitwiseAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitwiseAndExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseAndExpression(GLSLParser.BitwiseAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(GLSLParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(GLSLParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(GLSLParser.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code logicalAndExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(GLSLParser.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCallExpression(GLSLParser.FunctionCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCallExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCallExpression(GLSLParser.FunctionCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bitwiseExclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitwiseExclusiveOrExpression(GLSLParser.BitwiseExclusiveOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bitwiseExclusiveOrExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitwiseExclusiveOrExpression(GLSLParser.BitwiseExclusiveOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberAccessExpression(GLSLParser.MemberAccessExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberAccessExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberAccessExpression(GLSLParser.MemberAccessExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(GLSLParser.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code literalExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(GLSLParser.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postfixExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(GLSLParser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postfixExpression}
	 * labeled alternative in {@link GLSLParser#finiteExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(GLSLParser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GLSLParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GLSLParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(GLSLParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(GLSLParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code interfaceBlockDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBlockDeclaration(GLSLParser.InterfaceBlockDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code interfaceBlockDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBlockDeclaration(GLSLParser.InterfaceBlockDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code variableDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(GLSLParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code variableDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(GLSLParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code precisionDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterPrecisionDeclaration(GLSLParser.PrecisionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code precisionDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitPrecisionDeclaration(GLSLParser.PrecisionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeAndInitDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeAndInitDeclaration(GLSLParser.TypeAndInitDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeAndInitDeclaration}
	 * labeled alternative in {@link GLSLParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeAndInitDeclaration(GLSLParser.TypeAndInitDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#functionPrototype}.
	 * @param ctx the parse tree
	 */
	void enterFunctionPrototype(GLSLParser.FunctionPrototypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#functionPrototype}.
	 * @param ctx the parse tree
	 */
	void exitFunctionPrototype(GLSLParser.FunctionPrototypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#functionParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameterList(GLSLParser.FunctionParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#functionParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameterList(GLSLParser.FunctionParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterParameterDeclaration(GLSLParser.ParameterDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#parameterDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitParameterDeclaration(GLSLParser.ParameterDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(GLSLParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(GLSLParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#singleAttribute}.
	 * @param ctx the parse tree
	 */
	void enterSingleAttribute(GLSLParser.SingleAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#singleAttribute}.
	 * @param ctx the parse tree
	 */
	void exitSingleAttribute(GLSLParser.SingleAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#declarationMember}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationMember(GLSLParser.DeclarationMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#declarationMember}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationMember(GLSLParser.DeclarationMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#fullySpecifiedType}.
	 * @param ctx the parse tree
	 */
	void enterFullySpecifiedType(GLSLParser.FullySpecifiedTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#fullySpecifiedType}.
	 * @param ctx the parse tree
	 */
	void exitFullySpecifiedType(GLSLParser.FullySpecifiedTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#storageQualifier}.
	 * @param ctx the parse tree
	 */
	void enterStorageQualifier(GLSLParser.StorageQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#storageQualifier}.
	 * @param ctx the parse tree
	 */
	void exitStorageQualifier(GLSLParser.StorageQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#layoutQualifier}.
	 * @param ctx the parse tree
	 */
	void enterLayoutQualifier(GLSLParser.LayoutQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#layoutQualifier}.
	 * @param ctx the parse tree
	 */
	void exitLayoutQualifier(GLSLParser.LayoutQualifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code namedLayoutQualifier}
	 * labeled alternative in {@link GLSLParser#layoutQualifierId}.
	 * @param ctx the parse tree
	 */
	void enterNamedLayoutQualifier(GLSLParser.NamedLayoutQualifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code namedLayoutQualifier}
	 * labeled alternative in {@link GLSLParser#layoutQualifierId}.
	 * @param ctx the parse tree
	 */
	void exitNamedLayoutQualifier(GLSLParser.NamedLayoutQualifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code sharedLayoutQualifier}
	 * labeled alternative in {@link GLSLParser#layoutQualifierId}.
	 * @param ctx the parse tree
	 */
	void enterSharedLayoutQualifier(GLSLParser.SharedLayoutQualifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code sharedLayoutQualifier}
	 * labeled alternative in {@link GLSLParser#layoutQualifierId}.
	 * @param ctx the parse tree
	 */
	void exitSharedLayoutQualifier(GLSLParser.SharedLayoutQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#precisionQualifier}.
	 * @param ctx the parse tree
	 */
	void enterPrecisionQualifier(GLSLParser.PrecisionQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#precisionQualifier}.
	 * @param ctx the parse tree
	 */
	void exitPrecisionQualifier(GLSLParser.PrecisionQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#interpolationQualifier}.
	 * @param ctx the parse tree
	 */
	void enterInterpolationQualifier(GLSLParser.InterpolationQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#interpolationQualifier}.
	 * @param ctx the parse tree
	 */
	void exitInterpolationQualifier(GLSLParser.InterpolationQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#invariantQualifier}.
	 * @param ctx the parse tree
	 */
	void enterInvariantQualifier(GLSLParser.InvariantQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#invariantQualifier}.
	 * @param ctx the parse tree
	 */
	void exitInvariantQualifier(GLSLParser.InvariantQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#preciseQualifier}.
	 * @param ctx the parse tree
	 */
	void enterPreciseQualifier(GLSLParser.PreciseQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#preciseQualifier}.
	 * @param ctx the parse tree
	 */
	void exitPreciseQualifier(GLSLParser.PreciseQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#typeQualifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeQualifier(GLSLParser.TypeQualifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#typeQualifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeQualifier(GLSLParser.TypeQualifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterTypeSpecifier(GLSLParser.TypeSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#typeSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitTypeSpecifier(GLSLParser.TypeSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#arraySpecifier}.
	 * @param ctx the parse tree
	 */
	void enterArraySpecifier(GLSLParser.ArraySpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#arraySpecifier}.
	 * @param ctx the parse tree
	 */
	void exitArraySpecifier(GLSLParser.ArraySpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#arraySpecifierSegment}.
	 * @param ctx the parse tree
	 */
	void enterArraySpecifierSegment(GLSLParser.ArraySpecifierSegmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#arraySpecifierSegment}.
	 * @param ctx the parse tree
	 */
	void exitArraySpecifierSegment(GLSLParser.ArraySpecifierSegmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#builtinTypeSpecifierParseable}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinTypeSpecifierParseable(GLSLParser.BuiltinTypeSpecifierParseableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#builtinTypeSpecifierParseable}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinTypeSpecifierParseable(GLSLParser.BuiltinTypeSpecifierParseableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#builtinTypeSpecifierFixed}.
	 * @param ctx the parse tree
	 */
	void enterBuiltinTypeSpecifierFixed(GLSLParser.BuiltinTypeSpecifierFixedContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#builtinTypeSpecifierFixed}.
	 * @param ctx the parse tree
	 */
	void exitBuiltinTypeSpecifierFixed(GLSLParser.BuiltinTypeSpecifierFixedContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#structSpecifier}.
	 * @param ctx the parse tree
	 */
	void enterStructSpecifier(GLSLParser.StructSpecifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#structSpecifier}.
	 * @param ctx the parse tree
	 */
	void exitStructSpecifier(GLSLParser.StructSpecifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#structBody}.
	 * @param ctx the parse tree
	 */
	void enterStructBody(GLSLParser.StructBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#structBody}.
	 * @param ctx the parse tree
	 */
	void exitStructBody(GLSLParser.StructBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#structMember}.
	 * @param ctx the parse tree
	 */
	void enterStructMember(GLSLParser.StructMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#structMember}.
	 * @param ctx the parse tree
	 */
	void exitStructMember(GLSLParser.StructMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#structDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterStructDeclarator(GLSLParser.StructDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#structDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitStructDeclarator(GLSLParser.StructDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#initializer}.
	 * @param ctx the parse tree
	 */
	void enterInitializer(GLSLParser.InitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#initializer}.
	 * @param ctx the parse tree
	 */
	void exitInitializer(GLSLParser.InitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GLSLParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GLSLParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void enterCompoundStatement(GLSLParser.CompoundStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#compoundStatement}.
	 * @param ctx the parse tree
	 */
	void exitCompoundStatement(GLSLParser.CompoundStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDeclarationStatement(GLSLParser.DeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#declarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDeclarationStatement(GLSLParser.DeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(GLSLParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(GLSLParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(GLSLParser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(GLSLParser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void enterSelectionStatement(GLSLParser.SelectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#selectionStatement}.
	 * @param ctx the parse tree
	 */
	void exitSelectionStatement(GLSLParser.SelectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#iterationCondition}.
	 * @param ctx the parse tree
	 */
	void enterIterationCondition(GLSLParser.IterationConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#iterationCondition}.
	 * @param ctx the parse tree
	 */
	void exitIterationCondition(GLSLParser.IterationConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(GLSLParser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(GLSLParser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code valuedCaseLabel}
	 * labeled alternative in {@link GLSLParser#caseLabel}.
	 * @param ctx the parse tree
	 */
	void enterValuedCaseLabel(GLSLParser.ValuedCaseLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code valuedCaseLabel}
	 * labeled alternative in {@link GLSLParser#caseLabel}.
	 * @param ctx the parse tree
	 */
	void exitValuedCaseLabel(GLSLParser.ValuedCaseLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code defaultCaseLabel}
	 * labeled alternative in {@link GLSLParser#caseLabel}.
	 * @param ctx the parse tree
	 */
	void enterDefaultCaseLabel(GLSLParser.DefaultCaseLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code defaultCaseLabel}
	 * labeled alternative in {@link GLSLParser#caseLabel}.
	 * @param ctx the parse tree
	 */
	void exitDefaultCaseLabel(GLSLParser.DefaultCaseLabelContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(GLSLParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(GLSLParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoWhileStatement(GLSLParser.DoWhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#doWhileStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoWhileStatement(GLSLParser.DoWhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(GLSLParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(GLSLParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(GLSLParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(GLSLParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(GLSLParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(GLSLParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(GLSLParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(GLSLParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code discardStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterDiscardStatement(GLSLParser.DiscardStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code discardStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitDiscardStatement(GLSLParser.DiscardStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ignoreIntersectionStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterIgnoreIntersectionStatement(GLSLParser.IgnoreIntersectionStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ignoreIntersectionStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitIgnoreIntersectionStatement(GLSLParser.IgnoreIntersectionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code terminateRayStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterTerminateRayStatement(GLSLParser.TerminateRayStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code terminateRayStatement}
	 * labeled alternative in {@link GLSLParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitTerminateRayStatement(GLSLParser.TerminateRayStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GLSLParser#demoteStatement}.
	 * @param ctx the parse tree
	 */
	void enterDemoteStatement(GLSLParser.DemoteStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GLSLParser#demoteStatement}.
	 * @param ctx the parse tree
	 */
	void exitDemoteStatement(GLSLParser.DemoteStatementContext ctx);
}
