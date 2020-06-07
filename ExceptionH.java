class ExceptionA extends Exception {} // checked exception
class ExceptionB extends RuntimeException{} // unchecked exception


public class ExceptionH {

    public static void main(String[] args) {
        try { // ExceptionA is checked so it needs to be handled explicitly
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
    
    public static void fun(int a) throws ExceptionA { // ExceptionA is checked so it needs to be marked not the case with ExceptionB
        if (a == 0) {
            throw new ExceptionA();
        } else {
            throw new ExceptionB();
        }
    }
}
