package minijava.symbol;

import java.util.*;


public class SymbolTable {
    Symbol name;
    SymbolTableType tableType;
    SymbolTable parent;
    HashMap<Symbol, SymbolTable> children = new HashMap<>();
    HashMap<Symbol, Type> bindings = new HashMap<>();
    HashMap<Symbol, MethodSignature> methodBindings = new HashMap<>();
    HashSet<Symbol> classDeclarations = new HashSet<>();

    public SymbolTable(String name) {
        this.tableType = SymbolTableType.GLOBAL;
        parent = null;
        this.name = Symbol.symbol(name);
    }

    public SymbolTable(SymbolTable parent, String name, SymbolTableType tableType) {
        this.tableType = tableType;
        this.name = Symbol.symbol(name);
        this.parent = parent;
        parent.children.put(this.name, this);
    }

    public SymbolTable getParent() {
        return parent;
    }
    public SymbolTable getEnclosingClass() {
        SymbolTable st = this;
        while (st != null && st.tableType != SymbolTableType.CLASS) {
            st = st.getParent();
        }
        return st;
    }

    public SymbolTable getChild(String name) {
        return children.get(Symbol.symbol(name));
    }

    boolean bindingAvailable(String name)  {
        return !bindings.containsKey(Symbol.symbol(name)) &&
                !methodBindings.containsKey(Symbol.symbol(name)) &&
                !classDeclarations.contains(Symbol.symbol(name));
    }


    public boolean addBinding(String name, String typeName) {
        if (bindingAvailable(name)) {
            bindings.put(Symbol.symbol(name), new Type(typeName));
            return true;
        } else {
            return false;
        }
    }

    public boolean addMethodBinding(String name, MethodSignature methodSig) {
        if (bindingAvailable(name)) {
            methodBindings.put(Symbol.symbol(name), methodSig);
            return true;
        } else {
            return false;
        }
    }

    public boolean addClassDecl(String name) {
        if (bindingAvailable(name))  {
            classDeclarations.add(Symbol.symbol(name));
            return true;
        } else {
            return false;
        }
    }

    public Symbol getName() {
        return name;
    }

    // Get type of identifier
    public Type getType(String name) {
        Symbol s = Symbol.symbol(name);
        if (bindings.containsKey(s)) {
            return bindings.get(s);
        }
        else if (classDeclarations.contains(s)) {
            return new Type(s);
        }
        else if (parent != null){
            return parent.getType(name);
        }
        return null;
    }

    public MethodSignature getMethodSig(Symbol name) {
        if (methodBindings.containsKey(name)) {
            return methodBindings.get(name);
        }
        return null;
    }

    public Type getClassType(String name) {
        Symbol s = Symbol.symbol(name);
        if (classDeclarations.contains(s)) {
            return new Type(s);
        } else if (parent != null){
            return parent.getClassType(name);
        }
        return null;
    }

    public SymbolTable getClassTable(Symbol name) {
        if (children.containsKey(name)) {
            return children.get(name);
        } else if (parent != null) {
            return parent.getClassTable(name);
        }
        return null;
    }

    public void print() {
        printWithOffset("");
    }

    void printWithOffset(String o) {
        System.out.println("\033[0;1m" + name + "\033[0;0m");
        Iterator<Map.Entry<Symbol, Type>> bindingsIter = bindings.entrySet().iterator();
        for (int i = 0; i < bindings.size(); i++) {
            Map.Entry<Symbol, Type> binding = bindingsIter.next();
            String prefix = "├── ";
            if (i == bindings.size() - 1 && children.size() == 0 && methodBindings.size() == 0) {
                prefix = "└── ";
            }
            System.out.println(o + prefix + binding.getKey() + ": " + binding.getValue());
        }
        Iterator<Map.Entry<Symbol, MethodSignature>> methodIter = methodBindings.entrySet().iterator();
        for (int i = 0; i < methodBindings.size(); i++) {
            Map.Entry<Symbol, MethodSignature> binding = methodIter.next();
            String prefix = "├── ";
            if (i == methodBindings.size() - 1 && children.size() == 0) {
                prefix = "└── ";
            }
            System.out.println(o + prefix + binding.getKey() + ": " + binding.getValue());
        }
        Iterator<Symbol> classIter = classDeclarations.iterator();
        for (int i = 0; i < classDeclarations.size(); i++) {
            String prefix = "├── class ";
            if (i == classDeclarations.size() - 1 && children.size() == 0) {
                prefix = "└── class ";
            }
            System.out.println(o + prefix + classIter.next());
        }

        Iterator<Map.Entry<Symbol, SymbolTable>> childIter = children.entrySet().iterator();
        for (int i = 0; i < children.size(); i++) {
            String prefix = "├── ";
            if (i == children.size() - 1) {
                prefix = "└── class ";
                System.out.print(o + "└── ");
                childIter.next().getValue().printWithOffset(o + " \t");
            } else {
                System.out.print(o + "├── ");
                childIter.next().getValue().printWithOffset(o + "│\t");
            }
        }
    }
}
