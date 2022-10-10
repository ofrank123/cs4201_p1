package minijava.errors;

import minijava.symbol.Type;

public class BoolTypeError extends Error {
    public BoolTypeError(Type t) {
        super("Expected a boolean, found " + t);
    }
}
