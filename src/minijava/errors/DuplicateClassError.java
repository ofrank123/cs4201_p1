package minijava.errors;

public class DuplicateClassError extends Error {
    public DuplicateClassError(String className) {
        super("Duplicate class " + className);
    }
}
