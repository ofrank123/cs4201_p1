class Test {
    public static void main(String[] args) {
        System.out.println(20);
    }
}

class A {
    int a;
    int b;

    // Variables should not be declared more than once in a scope
    int x;
    int x;

    public int foo(int arg) {
        // c has not been declared yet, should error
        c = 0;

        int c;
        // This is fine, now that c has been declared
        c = 0;
        // This is fine, arg1 is an argument so it must be instantiated here
        c = arg;

        int d;
        // d was declared, but not instantiated, so it should error
        a = d;

        // Fine, b is automatically instantiated on class initialization,
        // as with all member variables of classes, so it can be used.
        // Additionally, c has now been declared so it can be assigned.
        c = b;

        int[] arr;
        // The array has not been instantiated yet, should throw an error
        arr[0] = 123;

        // Now we instantiate it
        arr = new int[128];

        // Now we can assign without an error
        arr[0] = 123;

        return 0;
    }

    // Cannot have 2 arguments with the same name
    public int bar(int arg, int arg) {
        return 0;
    }

    // Cannot declare a local var twice
    public int foofoo() {
        int y;
        int y;

        return 0;
    }

    // Cannot delcare a local var with the same name as an arg
    public int barbar(int arg) {
        int arg;

        return 0;
    }

    // We can shadow a class variable though, because they're not in the same scope
    public int foobar() {
        int a;

        return 0;
    }
}
