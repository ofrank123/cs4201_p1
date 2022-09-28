package minijava.symbol;

import java.util.HashMap;

enum TypeE {
    INT,
    BOOLEAN,
    INT_ARRAY,
    ID
}

class Type {
    TypeE type;
    Symbol name;

    public Type(TypeE type) {
        this.type = type;
        switch (type) {
            case INT: {
                this.name = Symbol.symbol("int");
                break;
            }
            case BOOLEAN: {
                this.name = Symbol.symbol("boolean");
                break;
            }
            case INT_ARRAY: {
                this.name = Symbol.symbol("int[]");
                break;
            }
            case ID: {
                System.err.println("Cannot create ID type without name");
                System.exit(-1);
            }
        }
    }

    public Type(TypeE type, String name) {
        this.type = type;
        this.name = Symbol.symbol(name);
    }
}

public class SymbolTable {
    SymbolTable parent;
    HashMap<Symbol, Type> bindings;
    public SymbolTable() {
        parent = null;
    }

    public SymbolTable(SymbolTable parent) {
        this.parent = parent;
    }

    public void addBinding(String name, Type type) {
        bindings.put(Symbol.symbol(name), type);
    }

    public boolean hasBinding(String name) {
        return bindings.containsKey(Symbol.symbol(name));
    }

    public Type getType(String name) {
        return bindings.get(Symbol.symbol(name));
    }
}
