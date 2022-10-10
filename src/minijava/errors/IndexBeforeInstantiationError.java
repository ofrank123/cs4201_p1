package minijava.errors;

public class IndexBeforeInstantiationError extends Error {
    public IndexBeforeInstantiationError(String name) {
        super("Array " + name + " indexed before it was instantiated");
    }
}
