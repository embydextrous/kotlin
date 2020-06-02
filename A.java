public class A {
    private int a = 2;

    void printA() {
        System.out.println(new B().b);
        new B().printA();
    }

    class B {
        private int b = 2;
        void printA() {
            System.out.println(a);
        }
    }
    public static void main(String[] args) {
        A a = new A();
        a.printA();
    }
}
