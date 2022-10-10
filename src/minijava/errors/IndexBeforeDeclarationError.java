package minijava.errors;

public class IndexBeforeDeclarationError extends Error {
    public IndexBeforeDeclarationError(String name) {
        super("Array " + name + " indexed before it was declared");
    }
}
