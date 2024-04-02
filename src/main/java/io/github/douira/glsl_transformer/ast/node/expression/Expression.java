package io.github.douira.glsl_transformer.ast.node.expression;

import io.github.douira.glsl_transformer.ast.node.abstract_node.InnerASTNode;
import io.github.douira.glsl_transformer.ast.query.Root;
import io.github.douira.glsl_transformer.ast.traversal.ASTListener;
import io.github.douira.glsl_transformer.ast.traversal.ASTVisitor;

public abstract class Expression extends InnerASTNode {
  public enum ExpressionType {
    REFERENCE(OperandStructure.NONE),
    LITERAL(OperandStructure.NONE),
    GROUPING(OperandStructure.UNARY, 1),
    INCREMENT_POSTFIX(OperandStructure.UNARY, 2, Associativity.LTR),
    DECREMENT_POSTFIX(OperandStructure.UNARY, 2, Associativity.LTR),
    INCREMENT_PREFIX(OperandStructure.UNARY, 3, Associativity.RTL),
    DECREMENT_PREFIX(OperandStructure.UNARY, 3, Associativity.RTL),
    IDENTITY(OperandStructure.UNARY, 3, Associativity.RTL),
    NEGATION(OperandStructure.UNARY, 3, Associativity.RTL),
    BOOLEAN_NOT(OperandStructure.UNARY, 3, Associativity.RTL),
    BITWISE_NOT(OperandStructure.UNARY, 3, Associativity.RTL),
    LENGTH_ACCESS(OperandStructure.UNARY, 2, Associativity.LTR),
    MEMBER_ACCESS(OperandStructure.UNARY, 2, Associativity.LTR),
    FUNCTION_CALL(OperandStructure.MANY, 2, Associativity.LTR),
    ARRAY_ACCESS(OperandStructure.BINARY, 2, Associativity.LTR),
    MULTIPLICATION(OperandStructure.BINARY, 4, Associativity.LTR),
    DIVISION(OperandStructure.BINARY, 4, Associativity.LTR),
    MODULO(OperandStructure.BINARY, 4, Associativity.LTR),
    ADDITION(OperandStructure.BINARY, 5, Associativity.LTR),
    SUBTRACTION(OperandStructure.BINARY, 5, Associativity.LTR),
    SHIFT_LEFT(OperandStructure.BINARY, 6, Associativity.LTR),
    SHIFT_RIGHT(OperandStructure.BINARY, 6, Associativity.LTR),
    LESS_THAN(OperandStructure.BINARY, 7, Associativity.LTR),
    GREATER_THAN(OperandStructure.BINARY, 7, Associativity.LTR),
    LESS_THAN_EQUAL(OperandStructure.BINARY, 7, Associativity.LTR),
    GREATER_THAN_EQUAL(OperandStructure.BINARY, 7, Associativity.LTR),
    EQUAL(OperandStructure.BINARY, 7, Associativity.LTR),
    NOT_EQUAL(OperandStructure.BINARY, 7, Associativity.LTR),
    BITWISE_AND(OperandStructure.BINARY, 9, Associativity.LTR),
    BITWISE_XOR(OperandStructure.BINARY, 10, Associativity.LTR),
    BITWISE_OR(OperandStructure.BINARY, 11, Associativity.LTR),
    BOOLEAN_AND(OperandStructure.BINARY, 12, Associativity.LTR),
    BOOLEAN_XOR(OperandStructure.BINARY, 13, Associativity.LTR),
    BOOLEAN_OR(OperandStructure.BINARY, 14, Associativity.LTR),
    ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    MULTIPLICATION_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    DIVISION_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    MODULO_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    ADDITION_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    SUBTRACTION_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    LEFT_SHIFT_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    RIGHT_SHIFT_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    BITWISE_AND_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    BITWISE_XOR_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    BITWISE_OR_ASSIGNMENT(OperandStructure.BINARY, 16, Associativity.RTL),
    CONDITION(OperandStructure.TERNARY, 15, Associativity.RTL),
    SEQUENCE(OperandStructure.MANY, 17, Associativity.LTR);

    public enum Associativity {
      LTR, // left-to-right
      RTL // right-to-left
    }

    public enum OperandStructure {
      NONE, // no operands, reference and literals
      UNARY, // unary operator
      BINARY, // binary operator
      TERNARY, // ternary operator (conditional expression)
      MANY // sequence of expressions (sequence expression)
    }

    public final int precedence;
    public final Associativity associativity;
    public final OperandStructure operandStructure;

    ExpressionType(
        OperandStructure operandStructure,
        int precedence,
        Associativity associativity) {
      this.operandStructure = operandStructure;
      this.precedence = precedence;
      this.associativity = associativity;
    }

    ExpressionType(OperandStructure operandStructure, int precedence) {
      this(operandStructure, precedence, null);
    }

    ExpressionType(OperandStructure operandStructure) {
      this(operandStructure, 0);
    }
  }

  public abstract ExpressionType getExpressionType();

  public abstract <R> R expressionAccept(ASTVisitor<R> visitor);

  @Override
  public <R> R accept(ASTVisitor<R> visitor) {
    return visitor.visitExpression(this);
  }

  @Override
  public void enterNode(ASTListener listener) {
    listener.enterExpression(this);
  }

  @Override
  public void exitNode(ASTListener listener) {
    listener.exitExpression(this);
  }

  @Override
  public abstract Expression clone();

  @Override
  public Expression cloneInto(Root root) {
    return (Expression) super.cloneInto(root);
  }
}
