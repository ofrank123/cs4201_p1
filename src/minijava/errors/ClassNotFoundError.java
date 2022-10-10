package minijava.errors;

import minijava.symbol.Type;

public class ClassNotFoundError extends Error {
    public ClassNotFoundError(String cls) {
        super("Class " + cls + " not found");
    }
}
