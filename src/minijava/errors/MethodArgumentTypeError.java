package minijava.errors;

import minijava.symbol.MethodSignature;
import minijava.symbol.Type;

public class MethodArgumentTypeError extends Error {
    public MethodArgumentTypeError(String methodName, Type passedArg, Type expectedArg) {
        super(methodName + " passed an argument of type " + passedArg + " but was expecting type " + expectedArg);
    }
}
