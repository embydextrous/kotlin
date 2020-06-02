public class MultipleInheritance {
    public static void main(String[] args) {
        C c = new C();
        c.doSomething();
    }
}

interface P {
    default void doSomething() {
        System.out.println("P's doSomething()");
    }
}

interface Q {
    default void doSomething() {
        System.out.println("Q's doSomething()");
    }
}

class C implements P, Q {
    @Override
    public void doSomething() {
        P.super.doSomething();
        Q.super.doSomething();
        System.out.println("C's doSomething()");
    }
}
