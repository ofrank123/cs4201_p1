package minijava.errors;

import minijava.symbol.MethodSignature;
import minijava.symbol.Type;

public class MethodArgumentCountError extends Error {
    public MethodArgumentCountError(String methodName, MethodSignature methodSig, int argc) {
        super("Method " + methodName + " takes " + methodSig.getParameters().size() + " arguments, found " + argc);
    }
}
