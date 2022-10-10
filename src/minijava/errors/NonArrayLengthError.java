package minijava.errors;

import minijava.symbol.Type;

public class NonArrayLengthError extends Error {
    public NonArrayLengthError(Type t) {
        super("Cannot get length of type " + t + ", not int[]");
    }
}
