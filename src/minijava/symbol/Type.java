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
}
