package io.github.douira.glsl_transformer.ast.print;

import io.github.douira.glsl_transformer.GLSLLexer;
import io.github.douira.glsl_transformer.ast.node.Identifier;
import io.github.douira.glsl_transformer.ast.node.IterationConditionInitializer;
import io.github.douira.glsl_transformer.ast.node.TranslationUnit;
import io.github.douira.glsl_transformer.ast.node.VersionStatement;
import io.github.douira.glsl_transformer.ast.node.abstract_node.ASTNode;
import io.github.douira.glsl_transformer.ast.node.declaration.*;
import io.github.douira.glsl_transformer.ast.node.expression.ConditionExpression;
import io.github.douira.glsl_transformer.ast.node.expression.Expression;
import io.github.douira.glsl_transformer.ast.node.expression.Expression.ExpressionType;
import io.github.douira.glsl_transformer.ast.node.expression.Expression.ExpressionType.OperandStructure;
import io.github.douira.glsl_transformer.ast.node.expression.LiteralExpression;
import io.github.douira.glsl_transformer.ast.node.expression.SequenceExpression;
import io.github.douira.glsl_transformer.ast.node.expression.binary.*;
import io.github.douira.glsl_transformer.ast.node.expression.unary.*;
import io.github.douira.glsl_transformer.ast.node.external_declaration.*;
import io.github.douira.glsl_transformer.ast.node.external_declaration.PragmaDirective.PragmaType;
import io.github.douira.glsl_transformer.ast.node.statement.CompoundStatement;
import io.github.douira.glsl_transformer.ast.node.statement.Statement;
import io.github.douira.glsl_transformer.ast.node.statement.loop.DoWhileLoopStatement;
import io.github.douira.glsl_transformer.ast.node.statement.loop.ForLoopStatement;
import io.github.douira.glsl_transformer.ast.node.statement.loop.WhileLoopStatement;
import io.github.douira.glsl_transformer.ast.node.statement.selection.SelectionStatement;
import io.github.douira.glsl_transformer.ast.node.statement.selection.SwitchStatement;
import io.github.douira.glsl_transformer.ast.node.statement.terminal.*;
import io.github.douira.glsl_transformer.ast.node.type.FullySpecifiedType;
import io.github.douira.glsl_transformer.ast.node.type.initializer.NestedInitializer;
import io.github.douira.glsl_transformer.ast.node.type.qualifier.*;
import io.github.douira.glsl_transformer.ast.node.type.specifier.*;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructBody;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructDeclarator;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructMember;
import io.github.douira.glsl_transformer.ast.node.type.struct.StructSpecifier;
import io.github.douira.glsl_transformer.ast.print.token.EOFToken;
import io.github.douira.glsl_transformer.util.Type.NumberType;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * The AST printer emits tokens to convert an AST node into a string with the
 * help of a few other utility classes. Information encoded about the string
 * content and printed structure of each node is encoded in this printer.
 */
public class ASTPrinter extends ASTPrinterBase {
  private final Deque<Expression> precedenceWrapped = new ArrayDeque<>();

  public ASTPrinter(TokenProcessor tokenProcessor) {
    super(tokenProcessor);
  }

  public static String printAST(TokenProcessor tokenProcessor, ASTNode node) {
    var printer = new ASTPrinter(tokenProcessor);
    printer.startVisit(node);
    printer.finalizePrinting();
    return printer.generateString();
  }

  public static String print(PrintType type, ASTNode node) {
    return printAST(type.getTokenProcessor(), node);
  }

  public static String printSimple(ASTNode node) {
    return print(PrintType.SIMPLE, node);
  }

  public static String printIndented(ASTNode node) {
    return print(PrintType.INDENTED, node);
  }

  public static String printCompact(ASTNode node) {
    return print(PrintType.COMPACT, node);
  }

  public static String printIndentedAnnotated(ASTNode node) {
    return print(PrintType.INDENTED_ANNOTATED, node);
  }

  @Override
  public Void startVisit(ASTNode node) {
    precedenceWrapped.clear();
    return super.startVisit(node);
  }

  @Override
  public Void visitTranslationUnit(TranslationUnit node) {
    visitSafe(node.getVersionStatement());
    emitLiteralSafe(node.outputOptions.getPrintHeader());
    visitChildren(node);
    emitToken(new EOFToken());
    return null;
  }

  @Override
  public Void visitVersionStatement(VersionStatement node) {
    emitType(GLSLLexer.NR, GLSLLexer.NR_VERSION);
    emitExtendableSpace();
    emitType(node.version.tokenType);
    if (node.profile != null) {
      emitExtendableSpace();
      emitType(node.profile.tokenType);
    }
    emitExactNewline();
    return null;
  }

  @Override
  public void enterExternalDeclaration(ExternalDeclaration node) {
    emitLineDirective(node.getSourceLocation());
    super.enterExternalDeclaration(node);
  }

  @Override
  public void enterStatement(Statement node) {
    emitLineDirective(node.getSourceLocation());
    super.visitStatement(node);
  }

  @Override
  public Void visitFunctionDefinition(FunctionDefinition node) {
    visit(node.getFunctionPrototype());
    emitBreakableSpace();
    visit(node.getBody());
    return null;
  }

  @Override
  public Void visitEmptyDeclaration(EmptyDeclaration node) {
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitPragmaDirective(PragmaDirective node) {
    emitType(GLSLLexer.NR, GLSLLexer.NR_PRAGMA);
    emitExtendableSpace();
    if (node.stdGL) {
      emitType(GLSLLexer.NR_STDGL);
      emitExtendableSpace();
    }
    if (node.type == PragmaType.CUSTOM) {
      emitLiteral(node.getCustomName());
    } else {
      emitType(
          node.type.tokenType,
          GLSLLexer.NR_LPAREN,
          node.state.tokenType,
          GLSLLexer.NR_RPAREN);
    }
    emitExactNewline();
    return null;
  }

  @Override
  public Void visitExtensionDirective(ExtensionDirective node) {
    emitType(GLSLLexer.NR, GLSLLexer.NR_EXTENSION);
    emitExtendableSpace();
    emitLiteral(node.getName());
    if (node.behavior != null) {
      emitType(GLSLLexer.NR_COLON);
      emitExtendableSpace();
      emitType(node.behavior.tokenType);
    }
    emitExactNewline();
    return null;
  }

  @Override
  public Void visitCustomDirective(CustomDirective node) {
    var translationUnitParent = node.getAncestor(TranslationUnit.class);
    if (translationUnitParent != null
        && !translationUnitParent.outputOptions.printCustomDirectives) {
      return null;
    }
    emitType(GLSLLexer.NR, GLSLLexer.NR_CUSTOM);
    var content = node.getContent();
    if (content != null) {
      emitExtendableSpace();
      emitLiteral(content);
    }
    emitExactNewline();
    return null;
  }

  @Override
  public Void visitIncludeDirective(IncludeDirective node) {
    emitType(GLSLLexer.NR, GLSLLexer.NR_INCLUDE);
    emitExtendableSpace();
    emitType(node.isAngleBrackets ? GLSLLexer.NR_STRING_START_ANGLE : GLSLLexer.NR_STRING_START);
    var content = node.getContent();
    if (content != null) {
      emitLiteral(content);
    }
    emitType(node.isAngleBrackets ? GLSLLexer.S_STRING_END_ANGLE : GLSLLexer.S_STRING_END);
    emitExactNewline();
    return null;
  }

  @Override
  public void exitLayoutDefaults(LayoutDefaults node) {
    emitType(node.mode.tokenType);
    emitBreakableSpace();
    emitStatementEnd();
  }

  @Override
  public void enterExpression(Expression node) {
    // emit extra parentheses if necessary to preserve the semantics of the AST in
    // the printed code
    if (node.getParent() instanceof Expression parent) {
      var parentType = parent.getExpressionType();
      var ownType = node.getExpressionType();
      if (parentType != ExpressionType.GROUPING
          && ownType != ExpressionType.GROUPING
          && parentType.precedence < ownType.precedence
          && (parentType.operandStructure == OperandStructure.UNARY
              || parentType.operandStructure == OperandStructure.BINARY
              || parentType.operandStructure == OperandStructure.TERNARY
              || parentType == ExpressionType.SEQUENCE)
          && !(parent instanceof ArrayAccessExpression access
              && access.getRight() == node)) {
        emitType(GLSLLexer.NR_LPAREN);
        precedenceWrapped.add(node);
      }
    }
  }

  @Override
  public void exitExpression(Expression node) {
    if (precedenceWrapped.peekLast() == node) {
      emitType(GLSLLexer.NR_RPAREN);
      precedenceWrapped.removeLast();
    }
  }

  @Override
  public void enterBitwiseNotExpression(BitwiseNotExpression node) {
    emitType(GLSLLexer.BITWISE_NEG_OP);
  }

  @Override
  public void enterBooleanNotExpression(BooleanNotExpression node) {
    emitType(GLSLLexer.LOGICAL_NOT_OP);
  }

  @Override
  public void enterDecrementPrefixExpression(DecrementPrefixExpression node) {
    emitType(GLSLLexer.MINUS_OP, GLSLLexer.MINUS_OP);
  }

  @Override
  public Void visitGroupingExpression(GroupingExpression node) {
    var operand = node.getOperand();
    if (operand.getExpressionType() == ExpressionType.GROUPING) {
      visit(operand);
    } else {
      emitType(GLSLLexer.LPAREN);
      visit(operand);
      emitType(GLSLLexer.RPAREN);
    }
    return null;
  }

  @Override
  public void enterIncrementPrefixExpression(IncrementPrefixExpression node) {
    emitType(GLSLLexer.PLUS_OP, GLSLLexer.PLUS_OP);
  }

  @Override
  public Void visitNegationExpression(NegationExpression node) {
    if (node.getParent() instanceof NegationExpression) {
      emitBreakableSpace();
    }
    emitType(GLSLLexer.MINUS_OP);
    visit(node.getOperand());
    return null;
  }

  @Override
  public void enterIdentityExpression(IdentityExpression node) {
    emitType(GLSLLexer.PLUS_OP);
  }

  @Override
  public void exitDecrementPostfixExpression(DecrementPostfixExpression node) {
    emitType(GLSLLexer.MINUS_OP, GLSLLexer.MINUS_OP);
  }

  @Override
  public void exitIncrementPostfixExpression(IncrementPostfixExpression node) {
    emitType(GLSLLexer.PLUS_OP, GLSLLexer.PLUS_OP);
  }

  @Override
  public Void visitFunctionCallExpression(FunctionCallExpression node) {
    visit(node.getReference());
    emitType(GLSLLexer.LPAREN);
    visitCommaSpaced(node.getParameters());
    emitType(GLSLLexer.RPAREN);
    return null;
  }

  @Override
  public Void visitMemberAccessExpression(MemberAccessExpression node) {
    visit(node.getOperand());
    emitType(GLSLLexer.DOT);
    visit(node.getMember());
    return null;
  }

  @Override
  public void exitLengthAccessExpression(LengthAccessExpression node) {
    emitType(GLSLLexer.DOT_LENGTH_METHOD_CALL);
  }

  @Override
  public Void visitConditionExpression(ConditionExpression node) {
    visit(node.getCondition());
    emitBreakableSpace();
    emitType(GLSLLexer.QUERY_OP);
    emitExtendableSpace();
    visit(node.getTrueExpression());
    emitBreakableSpace();
    emitType(GLSLLexer.COLON);
    emitExtendableSpace();
    visit(node.getFalseExpression());
    return null;
  }

  @Override
  public Void visitSequenceExpression(SequenceExpression node) {
    visitCommaSpaced(node.getExpressions());
    return null;
  }

  @Override
  public Void visitLiteralExpression(LiteralExpression node) {
    // literal expressions are always positive, negation is handled with a negation
    // expression
    var numberType = node.getNumberType();
    switch (numberType) {
      case BOOLEAN:
        emitLiteral(node.getBoolean() ? "true" : "false");
        break;
      case SIGNED_INTEGER:
      case UNSIGNED_INTEGER:
        int radix = node.getIntegerRadix();
        var integer = node.getInteger();
        var unsignedInt = numberType == NumberType.UNSIGNED_INTEGER;
        var intString = unsignedInt
            ? Long.toUnsignedString(integer, radix)
            : Long.toString(integer, radix);
        if (radix != 10) {
          var negative = !unsignedInt && integer < 0;
          var sign = intString.charAt(0);
          if (negative) {
            intString = intString.substring(1);
          }
          if (radix == 16) {
            intString = "0x" + intString;
          } else if (radix == 8) {
            intString = "0" + intString;
          }
          if (negative) {
            emitBreakableSpace();
            intString = sign + intString;
          }
        }
        switch (node.getType()) {
          case INT16:
            emitLiteral(intString + "s");
            break;
          case UINT16:
            emitLiteral(intString + "us");
            break;
          case INT32:
            emitLiteral(intString);
            break;
          case UINT32:
            emitLiteral(intString + "u");
            break;
          case INT64:
            emitLiteral(intString + "l");
            break;
          case UINT64:
            emitLiteral(intString + "ul");
            break;
          default:
            throw new IllegalStateException("Unexpected int type: " + node.getType());
        }
        break;
      case FLOATING_POINT:
        switch (node.getType()) {
          case FLOAT16:
            emitLiteral(Double.toString(node.getFloating()) + "hf");
            break;
          case FLOAT32:
            emitLiteral(Double.toString(node.getFloating()) + "f");
            break;
          case FLOAT64:
            emitLiteral(Double.toString(node.getFloating()) + "lf");
            break;
          default:
            throw new IllegalStateException("Unexpected float type: " + node.getType());
        }
        break;
    }
    return null;
  }

  @Override
  public Void visitArrayAccessExpression(ArrayAccessExpression node) {
    visit(node.getLeft());
    emitType(GLSLLexer.LBRACKET);
    visit(node.getRight());
    emitType(GLSLLexer.RBRACKET);
    return null;
  }

  @Override
  public Void visitMultiplicationExpression(MultiplicationExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.TIMES_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitDivisionExpression(DivisionExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.DIV_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitModuloExpression(ModuloExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.MOD_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitAdditionExpression(AdditionExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.PLUS_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitSubtractionExpression(SubtractionExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.MINUS_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitLeftShiftExpression(LeftShiftExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.LEFT_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitRightShiftExpression(RightShiftExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.RIGHT_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitLessThanExpression(LessThanExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.LT_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitGreaterThanExpression(GreaterThanExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.GT_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitLessThanEqualExpression(LessThanEqualExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.LE_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitGreaterThanEqualExpression(GreaterThanEqualExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.GE_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitEqualityExpression(EqualityExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.EQ_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitInequalityExpression(InequalityExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.NE_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBitwiseAndExpression(BitwiseAndExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.BITWISE_AND_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBitwiseXorExpression(BitwiseXorExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.BITWISE_XOR_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBitwiseOrExpression(BitwiseOrExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.BITWISE_OR_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBooleanAndExpression(BooleanAndExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.LOGICAL_AND_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBooleanXorExpression(BooleanXorExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.LOGICAL_XOR_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBooleanOrExpression(BooleanOrExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.LOGICAL_OR_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitAssignmentExpression(AssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.ASSIGN_OP);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitMultiplicationAssignmentExpression(MultiplicationAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.MUL_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitDivisionAssignmentExpression(DivisionAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.DIV_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitModuloAssignmentExpression(ModuloAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.MOD_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitAdditionAssignmentExpression(AdditionAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.ADD_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitSubtractionAssignmentExpression(SubtractionAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.SUB_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitLeftShiftAssignmentExpression(LeftShiftAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.LEFT_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitRightShiftAssignmentExpression(RightShiftAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.RIGHT_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBitwiseAndAssignmentExpression(BitwiseAndAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.AND_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBitwiseXorAssignmentExpression(BitwiseXorAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.XOR_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitBitwiseOrAssignmentExpression(BitwiseOrAssignmentExpression node) {
    visit(node.getLeft());
    emitBreakableSpace();
    emitType(GLSLLexer.OR_ASSIGN);
    emitBreakableSpace();
    visit(node.getRight());
    return null;
  }

  @Override
  public Void visitEmptyStatement(EmptyStatement node) {
    emitStatementEnd();
    return null;
  }

  /**
   * ANTLR grammar rule:
   * compoundStatement: LBRACE statement* RBRACE;
   */
  @Override
  public void enterCompoundStatement(CompoundStatement node) {
    emitType(GLSLLexer.LBRACE);
    emitCommonNewline();
    indent();
    if (node.getParent() instanceof SwitchStatement) {
      indent();
    }
  }

  @Override
  public void exitCompoundStatement(CompoundStatement node) {
    unindent();
    if (node.getParent() instanceof SwitchStatement) {
      unindent();
    }
    emitType(GLSLLexer.RBRACE);
    emitCommonNewline();
  }

  @Override
  public void exitExpressionStatement(ExpressionStatement node) {
    emitStatementEnd();
  }

  /**
   * ANTLR grammar rule:
   * selectionStatement:
   * attribute? IF LPAREN condition = expression RPAREN ifTrue = statement (
   * ELSE ifFalse = statement
   * )?;
   */
  @Override
  public Void visitSelectionStatement(SelectionStatement node) {
    emitType(GLSLLexer.IF);
    emitExtendableSpace();
    emitType(GLSLLexer.LPAREN);
    visit(node.getCondition());
    emitType(GLSLLexer.RPAREN);
    emitBreakableSpace();
    visit(node.getIfTrue());
    if (node.hasIfFalse()) {
      compactCommonNewline(CompoundStatement.class);
      emitType(GLSLLexer.ELSE);
      emitBreakableSpace();
      visit(node.getIfFalse());
    }
    return null;
  }

  /**
   * ANTLR grammar rule:
   * switchStatement:
   * attribute? SWITCH LPAREN condition = expression RPAREN compoundStatement;
   */
  @Override
  public Void visitSwitchStatement(SwitchStatement node) {
    emitType(GLSLLexer.SWITCH);
    emitExtendableSpace();
    emitType(GLSLLexer.LPAREN);
    visit(node.getExpression());
    emitType(GLSLLexer.RPAREN);
    emitBreakableSpace();
    visit(node.getStatement());
    return null;
  }

  @Override
  public void enterCaseLabelStatement(CaseLabelStatement node) {
    unindent();
  }

  @Override
  public void exitCaseLabelStatement(CaseLabelStatement node) {
    indent();
  }

  @Override
  public Void visitCaseStatement(CaseStatement node) {
    emitType(GLSLLexer.CASE);
    emitBreakableSpace();
    visit(node.getExpression());
    emitType(GLSLLexer.COLON);
    emitCommonNewline();
    return null;
  }

  @Override
  public Void visitDefaultStatement(DefaultStatement node) {
    emitType(GLSLLexer.DEFAULT, GLSLLexer.COLON);
    emitCommonNewline();
    return null;
  }

  private void visitLoopBody(Statement statement) {
    if (!(statement instanceof EmptyStatement)) {
      emitBreakableSpace();
    }
    visit(statement);
  }

  /**
   * ANTLR grammar rule:
   * * iterationCondition:
   * expression
   * | fullySpecifiedType IDENTIFIER ASSIGN_OP initializer;
   *
   * forStatement:
   * attribute? FOR LPAREN (
   * emptyStatement
   * | expressionStatement
   * | declarationStatement
   * ) condition = iterationCondition? SEMICOLON incrementer = expression? RPAREN
   * loopBody = statement;
   *
   */
  @Override
  public Void visitForLoopStatement(ForLoopStatement node) {
    emitType(GLSLLexer.FOR);
    emitBreakableSpace();
    emitType(GLSLLexer.LPAREN);
    if (visitSafe(node.getInitDeclaration())) {
      compactCommonNewline();
    } else {
      if (!visitSafe(node.getInitExpression())) {
        emitExactSpace();
      }
      emitType(GLSLLexer.SEMICOLON);
      emitBreakableSpace();
    }
    if (!visitSafe(node.getCondition())) {
      visitSafe(node.getIterationConditionInitializer());
    }
    emitType(GLSLLexer.SEMICOLON);
    emitBreakableSpace();
    visitSafe(node.getIncrementer());
    emitType(GLSLLexer.RPAREN);
    visitLoopBody(node.getStatement());
    return null;
  }

  /**
   * ANTLR grammar rules:
   * whileStatement:
   * attribute? WHILE LPAREN condition = iterationCondition RPAREN loopBody =
   * statement;
   */
  @Override
  public Void visitWhileLoopStatement(WhileLoopStatement node) {
    emitType(GLSLLexer.WHILE);
    emitBreakableSpace();
    emitType(GLSLLexer.LPAREN);
    if (!visitSafe(node.getCondition())) {
      visitSafe(node.getIterationConditionInitializer());
    }
    emitType(GLSLLexer.RPAREN);
    visitLoopBody(node.getStatement());
    return null;
  }

  /**
   * ANTLR grammar rule:
   * doWhileStatement:
   * attribute? DO loopBody = statement WHILE LPAREN condition = expression RPAREN
   * SEMICOLON;
   */
  @Override
  public Void visitDoWhileLoopStatement(DoWhileLoopStatement node) {
    emitType(GLSLLexer.DO);
    visitLoopBody(node.getStatement());
    compactCommonNewline(CompoundStatement.class);
    emitType(GLSLLexer.WHILE);
    emitBreakableSpace();
    emitType(GLSLLexer.LPAREN);
    visit(node.getCondition());
    emitType(GLSLLexer.RPAREN);
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitContinueStatement(ContinueStatement node) {
    emitType(GLSLLexer.CONTINUE);
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitBreakStatement(BreakStatement node) {
    emitType(GLSLLexer.BREAK);
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitReturnStatement(ReturnStatement node) {
    emitType(GLSLLexer.RETURN);
    if (node.getExpression() != null) {
      emitBreakableSpace();
      visit(node.getExpression());
    }
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitDiscardStatement(DiscardStatement node) {
    emitType(GLSLLexer.DISCARD);
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitIgnoreIntersectionStatement(IgnoreIntersectionStatement node) {
    emitType(GLSLLexer.IGNORE_INTERSECTION_EXT);
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitTerminateRayStatement(TerminateRayStatement node) {
    emitType(GLSLLexer.TERMINATE_RAY_EXT);
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitDemoteStatement(DemoteStatement node) {
    emitType(GLSLLexer.DEMOTE);
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitDeclarationMember(DeclarationMember node) {
    visit(node.getName());
    visitSafe(node.getArraySpecifier());
    if (node.getInitializer() != null) {
      emitBreakableSpace();
      emitType(GLSLLexer.ASSIGN_OP);
      emitBreakableSpace();
      visit(node.getInitializer());
    }
    return null;
  }

  @Override
  public Void visitFunctionPrototype(FunctionPrototype node) {
    visit(node.getReturnType());
    emitBreakableSpace();
    visit(node.getName());
    emitType(GLSLLexer.LPAREN);
    if (node.getParameters().size() >= 7) {
      emitCommonNewline();
      indent();
      visitWithSeparator(node.getParameters(), () -> {
        emitType(GLSLLexer.COMMA);
        emitCommonNewline();
      });
      emitCommonNewline();
      unindent();
    } else {
      visitCommaSpaced(node.getParameters());
    }
    emitType(GLSLLexer.RPAREN);
    return null;
  }

  @Override
  public Void visitFunctionParameter(FunctionParameter node) {
    visit(node.getType());
    if (node.getName() != null) {
      emitBreakableSpace();
      visit(node.getName());
      if (node.getArraySpecifier() != null) {
        visit(node.getArraySpecifier());
      }
    }
    return null;
  }

  /**
   * ANTLR grammar rule:
   * declaration:
   * functionPrototype SEMICOLON # functionDeclaration
   * | fullySpecifiedType (
   * declarationMembers += declarationMember (
   * COMMA declarationMembers += declarationMember
   * )*
   * )? SEMICOLON # typeAndInitDeclaration
   * | PRECISION precisionQualifier typeSpecifier SEMICOLON # precisionDeclaration
   * | typeQualifier blockName = IDENTIFIER structBody (
   * variableName = IDENTIFIER arraySpecifier?
   * )? SEMICOLON # interfaceBlockDeclaration
   * | typeQualifier (
   * variableNames += IDENTIFIER (COMMA variableNames += IDENTIFIER)*
   * )? SEMICOLON # variableDeclaration;
   */

  @Override
  public void exitFunctionDeclaration(FunctionDeclaration node) {
    emitStatementEnd();
  }

  @Override
  public Void visitInterfaceBlockDeclaration(InterfaceBlockDeclaration node) {
    visit(node.getTypeQualifier());
    emitBreakableSpace();
    visit(node.getBlockName());
    emitBreakableSpace();
    visit(node.getStructBody());
    if (node.getVariableName() != null) {
      emitBreakableSpace();
      visit(node.getVariableName());
      visitSafe(node.getArraySpecifier());
    }
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitPrecisionDeclaration(PrecisionDeclaration node) {
    emitType(GLSLLexer.PRECISION);
    emitBreakableSpace();
    visit(node.getPrecisionQualifier());
    emitBreakableSpace();
    visit(node.getTypeSpecifier());
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitTypeAndInitDeclaration(TypeAndInitDeclaration node) {
    visit(node.getType());
    if (!node.getMembers().isEmpty()) {
      emitBreakableSpace();
      visitCommaSpaced(node.getMembers());
    }
    emitStatementEnd();
    return null;
  }

  @Override
  public Void visitVariableDeclaration(VariableDeclaration node) {
    visit(node.getTypeQualifier());
    if (!node.getNames().isEmpty()) {
      emitBreakableSpace();
      visitCommaSpaced(node.getNames());
    }
    emitStatementEnd();
    return null;
  }

  // ExpressionInitializer is just an expression

  @Override
  public Void visitNestedInitializer(NestedInitializer node) {
    emitType(GLSLLexer.LBRACE);
    emitBreakableSpace();
    visitCommaSpaced(node.getInitializers());
    emitBreakableSpace();
    emitType(GLSLLexer.RBRACE);
    return null;
  }

  @Override
  public Void visitInterpolationQualifier(InterpolationQualifier node) {
    emitType(node.interpolationType.tokenType);
    return null;
  }

  @Override
  public Void visitInvariantQualifier(InvariantQualifier node) {
    emitType(GLSLLexer.INVARIANT);
    return null;
  }

  @Override
  public Void visitLayoutQualifier(LayoutQualifier node) {
    emitType(GLSLLexer.LAYOUT, GLSLLexer.LPAREN);
    visitCommaSpaced(node.getParts());
    emitType(GLSLLexer.RPAREN);
    return null;
  }

  @Override
  public Void visitNamedLayoutQualifierPart(NamedLayoutQualifierPart node) {
    visit(node.getName());
    if (node.getExpression() != null) {
      emitBreakableSpace();
      emitType(GLSLLexer.ASSIGN_OP);
      emitBreakableSpace();
      visit(node.getExpression());
    }
    return null;
  }

  @Override
  public Void visitSharedLayoutQualifierPart(SharedLayoutQualifierPart node) {
    emitType(GLSLLexer.SHARED);
    return null;
  }

  @Override
  public Void visitPreciseQualifier(PreciseQualifier node) {
    emitType(GLSLLexer.PRECISE);
    return null;
  }

  @Override
  public Void visitPrecisionQualifier(PrecisionQualifier node) {
    emitType(node.precisionLevel.tokenType);
    return null;
  }

  @Override
  public Void visitStorageQualifier(StorageQualifier node) {
    emitType(node.storageType.tokenType);
    if (node.getTypeNames() != null) {
      emitType(GLSLLexer.LPAREN);
      visitCommaSpaced(node.getTypeNames());
      emitType(GLSLLexer.RPAREN);
    }
    return null;
  }

  @Override
  public Void visitTypeQualifier(TypeQualifier node) {
    visitWithSeparator(node.getParts(), this::emitBreakableSpace);
    return null;
  }

  @Override
  public Void visitArraySpecifier(ArraySpecifier node) {
    for (var dimension : node.getDimensions()) {
      emitType(GLSLLexer.LBRACKET);
      visitSafe(dimension);
      emitType(GLSLLexer.RBRACKET);
    }
    return null;
  }

  @Override
  public void exitTypeSpecifier(TypeSpecifier node) {
    visitSafe(node.getArraySpecifier());
  }

  @Override
  public Void visitBuiltinFixedTypeSpecifier(BuiltinFixedTypeSpecifier node) {
    emitType(node.type.tokenType);
    return null;
  }

  @Override
  public Void visitBuiltinNumericTypeSpecifier(BuiltinNumericTypeSpecifier node) {
    emitLiteral(node.type.getMostCompactName());
    return null;
  }

  // TypeReference is just an Identifier

  @Override
  public Void visitStructBody(StructBody node) {
    emitType(GLSLLexer.LBRACE);
    if (node.getMembers().size() <= 1) {
      emitBreakableSpace();
      visitWithSeparator(node.getMembers(), this::emitBreakableSpace);
      emitBreakableSpace();
    } else {
      emitCommonNewline();
      indent();
      visitWithSeparator(node.getMembers(), this::emitCommonNewline);
      unindent();
      emitCommonNewline();
    }
    emitType(GLSLLexer.RBRACE);
    return null;
  }

  @Override
  public Void visitStructDeclarator(StructDeclarator node) {
    visit(node.getName());
    visitSafe(node.getArraySpecifier());
    return null;
  }

  @Override
  public Void visitStructMember(StructMember node) {
    visit(node.getType());
    emitBreakableSpace();
    visitCommaSpaced(node.getDeclarators());
    emitType(GLSLLexer.SEMICOLON);
    return null;
  }

  @Override
  public Void visitStructSpecifier(StructSpecifier node) {
    emitType(GLSLLexer.STRUCT);
    emitBreakableSpace();
    if (node.getName() != null) {
      visit(node.getName());
      emitBreakableSpace();
    }
    visit(node.getStructBody());
    return null;
  }

  @Override
  public Void visitFullySpecifiedType(FullySpecifiedType node) {
    if (node.getTypeQualifier() != null) {
      visit(node.getTypeQualifier());
      emitBreakableSpace();
    }
    visit(node.getTypeSpecifier());
    return null;
  }

  @Override
  public Void visitIterationConditionInitializer(IterationConditionInitializer node) {
    visit(node.getType());
    emitBreakableSpace();
    visit(node.getName());
    emitBreakableSpace();
    emitType(GLSLLexer.ASSIGN_OP);
    emitBreakableSpace();
    visit(node.getInitializer());
    return null;
  }

  @Override
  public Void visitIdentifier(Identifier node) {
    emitLiteral(node.getName());
    return null;
  }
}
