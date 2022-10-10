package minijava.errors;

import minijava.symbol.Type;

public class MethodNotFoundError extends Error {
    public MethodNotFoundError(String method, Type cls) {
        super("Method " + method + " not found in class " + cls);
    }
}
