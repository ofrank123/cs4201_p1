package minijava.errors;

import minijava.symbol.Type;

public class ArrayIndexTypeError extends Error {
    public ArrayIndexTypeError(String name, Type idxType) {
        super(name + " can only be indexed with type int, but found type " + idxType);
    }
}
