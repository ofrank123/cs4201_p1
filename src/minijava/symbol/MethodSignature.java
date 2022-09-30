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
            ret.append(parameter).append(", ");
        }
        if (parameters.size() > 0) {
            ret.deleteCharAt(ret.length() - 1);
            ret.deleteCharAt(ret.length() - 1);
        }
        ret.append(") => ").append(returnType.toString());

        return ret.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof MethodSignature)) {
            return false;
        }

        MethodSignature m = (MethodSignature) o;

        if (m.returnType != this.returnType) {
            return false;
        }

        if (m.parameters.size() != this.parameters.size()) {
            return false;
        }

        for (int i = 0; i < m.parameters.size(); i++) {
            if (m.parameters.get(i) != this.parameters.get(i)) {
                return false;
            }
        }

        return true;
    }
}
