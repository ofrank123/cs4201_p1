package minijava.errors;

public class DuplicateVariableError extends Error {
    public DuplicateVariableError(String varName) {
        super("Cannot declare variable " + varName + ", symbol already used");
    }
}
