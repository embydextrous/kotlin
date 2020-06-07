class ExceptionA extends Exception {}
class ExceptionB extends RuntimeException{}


public class ExceptionH {

    public static void main(String[] args) {
        try {
            fun(0); 
            fun(2);
        } catch (ExceptionA exceptionA) {
            System.out.println("Checked Exceptions");
        }

        try {
            fun(2);
        } catch (Exception exception) {
            System.out.println("Unchecked Exceptions");
        }
    }
    
    public static void fun(int a) throws ExceptionA {
        if (a == 0) {
            throw new ExceptionA();
        } else {
            throw new ExceptionB();
        }
    }
}
