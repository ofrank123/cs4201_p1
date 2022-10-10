class Test {
    public static void main(String[] args) {
        System.out.println(20);
    }
}

class A {
    public int foo(int a, int b) {
        return true;
    }

    // Method duplication errors
    public int foo(int a, int b) {
        return 0;
    }

    public int bar() {
        int b;
        // Methods should not have too few arguments
        b = this.foo(0);

        // Methods should not have too many arguments
        b = this.foo(0, 2, 3);

        // Method arguments should be the correct type
        b = this.foo(true, 0);

        // Nested method calls should be passed the correct arguments
        b = this.foo(this.foo(0, true), 0);
        b = this.foo(this.bar(), this.bar(0));
        b = this.foo(0, this.foo(0, 1, 2));

        B myB;
        myB = new B();
        // Method calls on object vars should not have too few args
        b = myB.foobar(0);
        // Method calls on object vars should not have too many args
        b = myB.foobar(0, 2, 3);
        // Nested method calls on object vars should have args of the correct type
        b = myB.foobar(0, myB.foobar(0, true));
        // Nested method calls on object vars should have the right number of arguments
        b = myB.foobar(0, myB.foobar(0));

        return 0;
    }

    public int fooint() {
        // Method return statements should be of the correct type
        return true;
    }

    public boolean foobool() {
        // Method return statements should be of the correct type
        return 0;
    }

    public int foofoofoo() {
        // Non void methods should return something
    }
}

class B {
    public int foobar(int a, int b) {
        return 0;
    }
}