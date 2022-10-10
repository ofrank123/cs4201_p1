package minijava.errors;

import minijava.symbol.Type;

public class ClassExpectedError extends Error {
    public ClassExpectedError(Type type) {
        super("Expected class, received " + type);
    }
}
