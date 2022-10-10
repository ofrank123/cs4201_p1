package minijava.symbol;

import java.util.Map;
import java.util.HashMap;

// Adapted from Prog 5.6 - MCIiJ, Appel
public class Symbol {
    private final String name;
    private Symbol (String name) {
        this.name = name;
    }
    private static final Map<String, Symbol> dict = new HashMap<>();

    public String toString() {
        return name;
    }

    public static Symbol symbol(String n) {
        String u = n.intern();
        Symbol s = dict.get(u);
        if (s == null) {
            s = new Symbol(u);
            dict.put(u,s);
        }
        return s;
    }
}
