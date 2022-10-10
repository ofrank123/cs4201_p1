package minijava.errors;

import minijava.symbol.Type;

public class IfTypeError extends Error {
    public IfTypeError(Type type) {
        super("If clause expected a boolean, received " + type);
    }
}
