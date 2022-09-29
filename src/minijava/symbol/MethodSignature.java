package minijava.symbol;

import java.util.ArrayList;

public class MethodSignature {
    Type returnType;
    ArrayList<Type> parameters = new ArrayList<>();

    public MethodSignature(String returnType) {
        this.returnType = new Type(returnType);
    }

    public void addParameter(String type) {
        parameters.add(new Type(type));
    }

    public Type getParameterType(int idx) {
        return parameters.get(idx);
    }

    public Type getReturnType() {
        return returnType;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("(");
        for (Type parameter: parameters) {
            ret.append(parameter).append(",");
        }
        if (parameters.size() > 0) {
            ret.deleteCharAt(ret.length() - 1);
        }
        ret.append(") => ").append(returnType.toString());

        return ret.toString();
    }
}
