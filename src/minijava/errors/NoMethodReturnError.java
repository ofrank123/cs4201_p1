package minijava.errors;

public class NoMethodReturnError extends Error {
    public NoMethodReturnError(String methodName, String returnType) {
        super("Method " + methodName + " has return type " + returnType + ", but does not return a value.");
    }
}
