package minijava.errors;

public class VarNotInitializedError extends Error {
    public VarNotInitializedError(String name) {
        super("Variable " + name + " used before initialization");
    }
}
