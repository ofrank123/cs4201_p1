package minijava.errors;

import minijava.symbol.Type;

public class AssignmentTypeError extends Error {
    public AssignmentTypeError(String name, Type lhsType, Type rhsType) {
        super(name + " is of type " + lhsType + ", but is being assigned to type " + rhsType);
    }
}
