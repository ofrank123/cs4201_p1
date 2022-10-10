package minijava.errors;

import minijava.symbol.Type;

public class ArrayAssignmentTypeError extends Error {
    public ArrayAssignmentTypeError(String name, Type valType) {
        super(name + " is of type int[], but one of its elements is being assigned to type " + valType);
    }
}
