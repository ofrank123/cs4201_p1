package minijava.errors;

import minijava.symbol.Type;

public class WhileTypeError extends Error {
    public WhileTypeError(Type type) {
        super("While clause expected a boolean, received " + type);
    }
}
