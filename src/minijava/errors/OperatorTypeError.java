package minijava.errors;

import minijava.symbol.Type;

public class OperatorTypeError extends Error {
    public OperatorTypeError(String op, Type actualType, Type expectedType) {
        super("Operator " + op + " takes operands of type " + expectedType + ", but found operand of type " + actualType);
    }
}
