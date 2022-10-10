package minijava.symbol;

import minijava.errors.ClassNotFoundError;
import minijava.errors.ErrorHandler;

import java.util.*;


// Stores some data about variable bindings
class VarBinding {
    public Type type;
    public boolean instantiated;
    public boolean declared;

    public VarBinding(Type type, boolean instantiated, boolean declared) {
        this.type = type;
        this.instantiated = instantiated;
        this.declared = declared;
    }
}

// Stores some data about class bindings
class ClassBinding {
    public Symbol extended;

    public ClassBinding(Symbol extended) {
        this.extended = extended;
    }
}

public class SymbolTable {
    // Global singleton
    static SymbolTable globalTable;

    // Symbol Table info
    Symbol name;
    SymbolTableType tableType;

    // Relationships
    SymbolTable parent;
    HashMap<Symbol, SymbolTable> children = new HashMap<>();

    // Binding maps
    HashMap<Symbol, VarBinding> varBindings = new HashMap<>();
    HashMap<Symbol, MethodSignature> methodBindings = new HashMap<>();
    HashMap<Symbol, ClassBinding> classBindings = new HashMap<>();

    /******************************
     *        Constructors        *
     ******************************/

    // Constructor for the global table
    public SymbolTable(String name) {
        this.tableType = SymbolTableType.GLOBAL;
        parent = null;
        this.name = Symbol.symbol(name);

        // Sets the global table singleton
        globalTable = this;
    }

    // Constructor for method/class symbol tables
    public SymbolTable(SymbolTable parent, String name, SymbolTableType tableType) {
        this.tableType = tableType;
        this.name = Symbol.symbol(name);
        this.parent = parent;

        // Add this table to the parent as a child
        parent.children.put(this.name, this);
    }

    /******************************
     *           GETTERS          *
     ******************************/

    // Get the global table singleton
    public static SymbolTable getGlobalTable() {
        return globalTable;
    }

    // Get the parent scope
    public SymbolTable getParent() {
        return parent;
    }

    // Get a child scope by name
    public SymbolTable getChild(String name) {
        return children.get(Symbol.symbol(name));
    }

    // Get name of this scope
    public Symbol getName() {
        return name;
    }

    // Get the table type (Global, Class, or Method)
    public SymbolTableType getTableType() {
        return tableType;
    }

    // Get the current class scope.  Should only be called from within a class or method
    public SymbolTable getEnclosingClass() {
        SymbolTable st = this;
        while (st != null && st.tableType != SymbolTableType.CLASS) {
            st = st.getParent();
        }
        return st;
    }

    // Checks if cls extends extended
    public boolean classExtends(Symbol cls, Symbol extended) {
        // Not a class
        if (cls == null || !classBindings.containsKey(cls)) {
            return false;
        }

        // Recursive base case
        if (cls.equals(extended)) {
            return true;
        }

        // Recursive call to parent
        Symbol parent = classBindings.get(cls).extended;
        return classExtends(parent, extended);
    }


    /******************************
     *          BINDINGS          *
     ******************************/

    // Internal helper to check if a binding can be used in this scope
    boolean bindingAvailable(String name) {
        return !varBindings.containsKey(Symbol.symbol(name)) &&
                !methodBindings.containsKey(Symbol.symbol(name)) &&
                !classBindings.containsKey(Symbol.symbol(name));
    }


    // Add a variable binding to the current scope
    public boolean addVarBinding(String name, String typeName, boolean instantiated, boolean declared) {
        if (bindingAvailable(name)) {
            varBindings.put(Symbol.symbol(name), new VarBinding(new Type(typeName), instantiated, declared));
            return true;
        } else {
            return false;
        }
    }

    // Add a method binding to the current scope
    public boolean addMethodBinding(String name, MethodSignature methodSig) {
        if (bindingAvailable(name)) {
            methodBindings.put(Symbol.symbol(name), methodSig);
            return true;
        } else {
            return false;
        }
    }

    // Add a class binding to the current scope
    public boolean addClassBinding(String name, Symbol extended) {
        if (bindingAvailable(name)) {
            classBindings.put(Symbol.symbol(name), new ClassBinding(extended));
            return true;
        } else {
            return false;
        }
    }

    /***********************************
     *          Type Checking          *
     ***********************************/

    // Internal helper to get the class this class extends
    SymbolTable getExtendedClass() {
        if (parent.classBindings.containsKey(this.name)) {
            Symbol extended = parent.classBindings.get(this.name).extended;
            if (extended != null) {
                return parent.children.get(extended);
            }
        }

        return null;
    }

    // Get type of identifier
    public Type getType(String name) {
        Symbol s = Symbol.symbol(name);

        // Check if there's a variable binding
        if (varBindings.containsKey(s)) {
            return varBindings.get(s).type;
        // Check if there's a class binding
        } else if (classBindings.containsKey(s)) {
            return new Type(s);
        } else if (parent != null) {
            // Check extended class for symbol
            SymbolTable extended = getExtendedClass();
            if (extended != null) {
                Type t = extended.getType(name);
                if (t != null) {
                    return t;
                }
            }

            // Check parent scope
            return parent.getType(name);
        }
        return null;
    }

    // Internal helper to get the binding for a given variable
    public VarBinding getVar(Symbol name) {
        // Check this scope for binding
        if (varBindings.containsKey(name)) {
            return varBindings.get(name);
        } else if (parent != null) {
            // Check extended class for var
            SymbolTable extended = getExtendedClass();
            if (extended != null) {
                VarBinding v = extended.getVar(name);
                if (v != null) {
                    return v;
                }
            }

            // Check the parent scope for binding
            return parent.getVar(name);
        }

        return null;
    }

    // Get type of variable
    public Type getVarType(String name) {
        VarBinding var = getVar(Symbol.symbol(name));
        if (var != null) {
            return var.type;
        } else {
            return null;
        }
    }

    // Check if name refers to a variable
    public boolean isVar(String name) {
        VarBinding binding = getVar(Symbol.symbol(name));
        return binding != null;
    }

    // Check if variable is declared
    public boolean isVarDeclared(String name) {
        VarBinding var = getVar(Symbol.symbol(name));
        if (var != null) {
            return var.declared;
        } else {
            return false;
        }
    }

    // Check if variable is instantiated
    public boolean isVarInstantiated(String name) {
        VarBinding var = getVar(Symbol.symbol(name));
        if (var != null) {
            return var.instantiated;
        } else {
            return false;
        }
    }

    // Set a variable to declared
    public void declareVar(String name) {
        VarBinding binding = getVar(Symbol.symbol(name));
        if (binding != null) {
            binding.declared = true;
        }
    }

    // Set a variable to instantiated
    public void instantiateVar(String name) {
        VarBinding binding = getVar(Symbol.symbol(name));
        if (binding != null) {
            binding.instantiated = true;
        }
    }

    public MethodSignature getMethodSig(Symbol name) {
        if (methodBindings.containsKey(name)) {
            return methodBindings.get(name);
        }
        if (parent.classBindings.containsKey(this.name)) {
            Symbol extended = parent.classBindings.get(this.name).extended;
            if (extended != null) {
                return parent.children.get(extended).methodBindings.get(name);
            }
        }
        return null;
    }

    // Gets the type of class
    public Type getClassType(String name) {
        Symbol s = Symbol.symbol(name);
        if (classBindings.containsKey(s)) {
            return new Type(s);
        } else if (parent != null) {
            return parent.getClassType(name);
        }
        return null;
    }

    // Gets the symbol table for a given class
    public SymbolTable getClassTable(Symbol name) {
        if (children.containsKey(name)) {
            return children.get(name);
        } else if (parent != null) {
            return parent.getClassTable(name);
        }
        return null;
    }

    /***********************************
     *             Printing            *
     ***********************************/

    // Print this symbol table as a tree
    public void print() {
        printWithOffset("");
    }

    // Print this symbol table with a given offset
    void printWithOffset(String o) {
        // Print the name of this scope in bold
        System.out.println("\033[0;1m" + name + "\033[0;0m");

        // Print variable bindings
        Iterator<Map.Entry<Symbol, VarBinding>> bindingsIter = varBindings.entrySet().iterator();
        for (int i = 0; i < varBindings.size(); i++) {
            Map.Entry<Symbol, VarBinding> binding = bindingsIter.next();
            String prefix = "├── ";
            if (i == varBindings.size() - 1 && children.size() == 0 && methodBindings.size() == 0) {
                prefix = "└── ";
            }
            System.out.println(o + prefix + binding.getKey() + ": " + binding.getValue().type);
        }

        // Print method bindings
        Iterator<Map.Entry<Symbol, MethodSignature>> methodIter = methodBindings.entrySet().iterator();
        for (int i = 0; i < methodBindings.size(); i++) {
            Map.Entry<Symbol, MethodSignature> binding = methodIter.next();
            String prefix = "├── ";
            if (i == methodBindings.size() - 1 && children.size() == 0) {
                prefix = "└── ";
            }
            System.out.println(o + prefix + binding.getKey() + ": " + binding.getValue());
        }

        // Print class bindings
        Iterator<Symbol> classIter = classBindings.keySet().iterator();
        for (int i = 0; i < classBindings.size(); i++) {
            String prefix = "├── class ";
            if (i == classBindings.size() - 1 && children.size() == 0) {
                prefix = "└── class ";
            }
            System.out.println(o + prefix + classIter.next());
        }

        // Print out child symbol tables
        Iterator<Map.Entry<Symbol, SymbolTable>> childIter = children.entrySet().iterator();
        for (int i = 0; i < children.size(); i++) {
            if (i == children.size() - 1) {
                System.out.print(o + "└── ");
                childIter.next().getValue().printWithOffset(o + "    ");
            } else {
                System.out.print(o + "├── ");
                childIter.next().getValue().printWithOffset(o + "│   ");
            }
        }
    }

    /***********************************
     *          Cycle Checking         *
     ***********************************/

    // Check for cycles in the inheritance graph
    public void checkExtensionCycles() {
        if (this.tableType != SymbolTableType.GLOBAL) {
            System.err.println("Cycle checking can only be done from the global scope");
            System.exit(-1) ;
        }

        boolean anyCycles = false;

        // Look through each class (we don't have nested classes)
        for (Symbol s : classBindings.keySet()) {
            Symbol extended = classBindings.get(s).extended;
            // Set to keep track of which classes we've seen so far
            Set<Symbol> seenClasses = new HashSet<>();
            seenClasses.add(s);
            while (extended != null) {
                // If we've already seen this class, it's a loop
                if (seenClasses.contains(extended)) {
                    System.err.println("Error: Cyclic inheritance involving " + s.toString());
                    anyCycles = true;
                    break;
                }
                if (!classBindings.containsKey(extended)) {
                    ErrorHandler.addError(new ClassNotFoundError(extended.toString()));
                    break;
                } else {
                    seenClasses.add(extended);
                    extended = classBindings.get(extended).extended;
                }
            }
        }

        // Error out if we saw any cycles
        // Typechecking when we have cycles will just run forever.
        if (anyCycles) {
            System.exit(-1);
        }
    }
}
