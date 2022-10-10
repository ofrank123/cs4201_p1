package minijava.errors;

import minijava.symbol.Type;

public class NewArrayTypeError extends Error {
    public NewArrayTypeError(Type t) {
        super("Expected type int for the size of new int[], found " + t);
    }
}
