class Test {
    public static void main(String[] args) {
        System.out.println(20);
    }
}

class A {
    public int foo() {
        B myB;
        // A does not extend B, so this errors
        myB = new A();

        // C and D both extend B
        myB = new C();
        myB = new D();

        C myC;
        // A and B do not extend C
        myC = new A();
        myC = new B();

        // D extends C
        myC = new D();

        int x;
        // foo and bar are both accessible on C
        x = myC.foo();
        x = myC.bar();

        //  foobar isn't accessible, despite myC being an object of class D
        x = myC.foobar();

        return 0;
    }
}

class B {
    public int foo() {
        return 0;
    }
}
class C extends B {
    public int bar() {
        return 0;
    }
}
class D extends C {
    public int foobar() {
        return 0;
    }
}

class Foo extends Bar {}

// Cannot have duplicate classes
class E {}
class E {}