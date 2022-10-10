package minijava.errors;

public abstract class Error {
    int linum;
    String message;

    public Error(String message) {
        this.linum = ErrorHandler.getLinum();
        this.message = message;
    }

    public void printError() {
        System.err.println("Error: line " + linum + ": " + message);
    }
}
