package minijava.symbol;

enum TypeE {
    INT,
    BOOLEAN,
    INT_ARRAY,
    ID
}

public class Type {
    TypeE type;
    Symbol name;

    public Type(String name) {
        this.name = Symbol.symbol(name);
        switch (name) {
            case "int": {
                this.type = TypeE.INT;
                break;
            }
            case "boolean": {
                this.type = TypeE.BOOLEAN;
                break;
            }
            case "int[]": {
                this.type = TypeE.INT_ARRAY;
                break;
            }
            default: {
                this.type = TypeE.ID;
                break;
            }
        }
    }

    @Override
    public String toString() {
        return name.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Type)) {
            return false;
        }

        Type t = (Type) o;

        if (this.type == TypeE.ID) {
            return t.type == TypeE.ID && t.name.equals(this.name);
        } else {
            return t.type == this.type;
        }
    }
}
