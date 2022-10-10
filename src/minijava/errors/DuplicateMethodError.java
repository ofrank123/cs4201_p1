package minijava.errors;

public class DuplicateMethodError extends Error {
    public DuplicateMethodError(String className) {
        super("Cannot declare method " + className + ", symbol already used");
    }
}
