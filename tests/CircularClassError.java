class Test {
    public static void main(String[] args) {
        System.out.println(20);
    }
}

// A cannot extend itself
class A extends A {}

// Cicular class extension issue
// B --> C
// ^     |
// |     |
// +-----+
class B extends C {}
class C extends B {}

// Cicular class extension issue
// E --> D --> F
// ^           |
// |           |
// +-----------+
class E extends F {}
class D extends E {}
class F extends D {}