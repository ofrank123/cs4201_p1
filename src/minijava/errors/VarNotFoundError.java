package minijava.errors;

public class VarNotFoundError extends Error {
    public VarNotFoundError(String name) {
        super("No such var: " + name);
    }
}
