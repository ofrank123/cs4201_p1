package minijava.errors;

import minijava.symbol.Type;

public class NonArrayIndexError extends Error {
    public NonArrayIndexError(String name, Type t) {
        super("Cannot perform index operation on " + name + ", it is of type " + t + ", not int[]");
    }
}
