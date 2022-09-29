package minijava.symbol;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SymbolTable {
    SymbolTable parent;
    ArrayList<SymbolTable> children = new ArrayList<>();
    String name;
    HashMap<Symbol, Type> bindings = new HashMap<>();
    HashMap<Symbol, MethodSignature> methodBindings = new HashMap<>();
    HashMap<Symbol, Symbol> classDeclarations = new HashMap<>();

    public SymbolTable(String name) {
        parent = null;
        this.name = name;
    }

    public SymbolTable(SymbolTable parent, String name) {
        this.name = name;
        this.parent = parent;
        parent.children.add(this);
    }

    boolean hasBinding()  {
        return !bindings.containsKey(Symbol.symbol(name)) && !methodBindings.containsKey(Symbol.symbol(name));
    }


    public boolean addBinding(String name, String typeName) {
        if (hasBinding()) {
            bindings.put(Symbol.symbol(name), new Type(typeName));
            return true;
        } else {
            return false;
        }
    }

    public boolean addMethodBinding(String name, MethodSignature methodSig) {
        if (hasBinding()) {
            methodBindings.put(Symbol.symbol(name), methodSig);
            return true;
        } else {
            return false;
        }
    }

    public boolean hasBinding(String name) {
        return bindings.containsKey(Symbol.symbol(name));
    }

    public Type getType(String name) {
        if (bindings.containsKey(Symbol.symbol(name))) {
            return bindings.get(Symbol.symbol(name));
        } else if (parent != null){
            parent.getType(name);
        }
        return null;
    }

    public void print() {
        printWithOffset(0);
    }

    void printWithOffset(int offset) {
        String o = "|\t".repeat(offset);
        System.out.println(o + "|---");
        System.out.println(o + "| " + name);
        System.out.println(o + "|---");
        for (Map.Entry<Symbol, Type> binding : bindings.entrySet()) {
            System.out.println(o + "| " + binding.getKey() + ": " + binding.getValue());
        }
        for (Map.Entry<Symbol, MethodSignature> binding : methodBindings.entrySet()) {
            System.out.println(o + "| " + binding.getKey() + ": " + binding.getValue());
        }
        for (SymbolTable child : children) {
            child.printWithOffset(offset + 1);
        }
    }
}
