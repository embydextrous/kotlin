class A {

    A() {
        System.out.println(A.class.getName() + ": constructor");
    }

    static {
        System.out.println(A.class.getName() + ": static block 1");
    }

    {
        System.out.println(A.class.getName() + ": instance block 2");
    }

    static {
        System.out.println(A.class.getName() + ": static block 2");
    }

    {
        System.out.println(A.class.getName() + ": instance block 1");
    }
}

class B extends A {
    B() {
        System.out.println(B.class.getName() + ": constructor");
    }

    static {
        System.out.println(B.class.getName() + ": static block 1");
    }

    {
        System.out.println(B.class.getName() + ": instance block 2");
    }

    static {
        System.out.println(B.class.getName() + ": static block 2");
    }

    {
        System.out.println(B.class.getName() + ": instance block 1");
    }
}

public class BlockExecutionOrder {
    static {
        System.out.println(BlockExecutionOrder.class.getName() + ": static block 1");
    }

    static {
        System.out.println(BlockExecutionOrder.class.getName() + ": static block 2");
    }

    public static void main(String[] args) {
        A a = new B();
        A b = new B();
    }
}
