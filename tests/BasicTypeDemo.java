class Test {
    public static void main(String[] args) {
        System.out.println(2);
    }
}

class A {
    public int foo() {
        // int declaration
        int a;
        int b;

        // Basic assignment of ints
        a = 0;
        b = 5;

        // Assignment to expression
        a = 3 + 1;

        // Assignment to expressions involving variables
        a = a + b;

        // Assignment to more complex expressions
        b = (a + b) * 10;
        b = (a + 10) * b + 2;

        // Declaration of bools
        boolean c;
        boolean d;

        //
        c = true;
        // Basic assignment should not error
        d = false;
        // Assignment to expressions should not error
        c = c && d;
        // Assignment to expressions should not error
        c = true && d;
        // Nested assignments with correct types should not error
        c = c && (1 < (b + 10));

        // Boolean expressions in if clauses should not error
        if (d) c = true;
        else d = false;

        // Boolean expressions in while clauses should not error
        while (d) d = c && false;

        // Nested boolean expressions in if clauses should not error
        if (c && (1 < (b + 10))) c = true;
        else d = false;

        // Nested boolean expressions in while clauses should not error
        while ((1 < (a + 5)) && true) a = a + 1;

        int[] myArr;
        // Array instantiation should not error
        myArr = new int[3];

        // Array index assignment should not error
        myArr[0] = 0;

        // Array index assignment with variables should not error
        myArr[a] = b;

        // Array index assignment with nested expressions should not error
        myArr[a + b] = 10 * ((7 * a) * (b + 4));

        // Should not error, but will with the unmodified grammar
        myArr[0] = myArr[0] + myArr[0];

        A myA;

        // Object assignment should not error
        myA = new A();

        return 0;
    }

    public int bar() {
        return 0;
    }
}