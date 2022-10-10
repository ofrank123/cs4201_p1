package minijava.errors;

import minijava.symbol.Type;

public class IdentifierNotFoundError extends Error {
    public IdentifierNotFoundError(String name) {
        super("Could not find identifier " + name);
    }
}
