package minijava.errors;

import minijava.symbol.Type;

public class ReturnTypeError extends Error {
    public ReturnTypeError(Type retType, Type methodType) {
        super("Return statement has type " + retType + ", but method returns " + methodType);
    }
}
