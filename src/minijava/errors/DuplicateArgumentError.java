package minijava.errors;

public class DuplicateArgumentError extends Error {
    public DuplicateArgumentError(String argName) {
        super("Cannot declare argument " + argName + ", symbol already used");
    }
}
