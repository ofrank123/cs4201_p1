class Test {
    public static void main(String[] args) {
        System.out.println(2);
    }
}

class A {
    int a;

    public boolean Start() {
        boolean b;
        a = 0;
        b = true;
        b = A.Check(a, b);
        return b;
    }
}

class B {
    int a;

    public boolean Check(boolean a, int b) {
        if (a && (b < false)) {
            return a;
        } else {
            return false;
        }
    }
}