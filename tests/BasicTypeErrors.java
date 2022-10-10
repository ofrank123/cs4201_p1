class Test {
    public static void main(String[] args) {
        System.out.println(2);
    }
}

class A {
    // Demonstrate type errors for different types
    public int foo() {
        int a;
        // Integer variable assignment should have an integer on the right hand side
        a = false;
        // Values in nested expressions should be of the correct type
        a = 10 + ((10 * ((true + 10) + 7)) * 3);

        boolean b;
        // Boolean variable assignment should have a boolean on the right hand side
        b = 1;
        // Method return type should match expected type
        b = this.bar();
        // Variables in nested expressions should be the correct type
        b = b && (10 < (b + a));

        // If clauses should be a boolean
        if (10 + 10) a = 10;
        else a = 5;

        // If clauses shouldn't have type mismatches in sub expressions
        if (10 < b) a = 10;
        else a = 5;

        // While clauses should be a boolean
        while (10 + 10) a = 10;

        int[] c;
        c = new int[128];

        // Array value assignments should be integers on the right hand side
        c[0] = true;
        // Array values should only be assigned to integer variables
        c[3] = b;
        // Variables being assigned to array values should be integers
        b = c[0];
        // Indexing should be performed with integers
        c[b] = 0;
        // Nested indexing expressions should be typed correctly
        c[10 < (5 * b)] = 0;
        // Indexed variable should be an array
        b[0] = 10;

        A d;
        // Object variables should be set to values of the correct type
        d = 0;
        // When the result of a method is assigned to an object variable, that method should return an object
        d = d.bar();
        // Complex nested statements should be free of type mismatches
        c[b] = d.bar() < ((7 < c[d.bar() + (a < true)]) + 10);

        return 0;
    }

    public int bar() {
        return 0;
    }
}