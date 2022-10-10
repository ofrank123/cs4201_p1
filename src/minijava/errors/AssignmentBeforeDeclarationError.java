package minijava.errors;

import minijava.symbol.Type;

public class AssignmentBeforeDeclarationError extends Error {
    public AssignmentBeforeDeclarationError(String name) {
        super("Variable " + name + " assigned before it was declared");
    }
}
