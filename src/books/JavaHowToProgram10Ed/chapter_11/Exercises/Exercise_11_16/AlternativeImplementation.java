package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_16;

public class AlternativeImplementation {

    public static void method1() throws AltExceptionA {
        try {
            method2();
        } catch (AltExceptionA exceptionA) {
            throw new AltExceptionA("From method 1", exceptionA);
        }
    }

    public static void method2() throws AltExceptionB {
        try {
            method3();
        } catch (ExceptionC exceptionC) {
            throw new AltExceptionB("From method 2", exceptionC);
        }
    }

    public static void method3() throws ExceptionC {
        throw new ExceptionC("From method 3");
    }

    public static void main(String[] args) {

        try {
            method1();
        } catch (AltExceptionA exceptionA) {
            exceptionA.printStackTrace();
        }

    }

}

class AltExceptionA extends Exception {

    public AltExceptionA() {
        super("ExceptionA called");
    }

    public AltExceptionA(String message) {
        super(message);
    }

    public AltExceptionA(String message, Throwable cause) {
        super(message, cause);
    }

}

class AltExceptionB extends AltExceptionA {

    public AltExceptionB() {
        super("ExceptionB called");
    }

    public AltExceptionB(String message) {
        super(message);
    }

    public AltExceptionB(String message, Throwable cause) {
        super(message, cause);
    }

}

class AltExceptionC extends AltExceptionB {
    public AltExceptionC() {
        super("ExceptionC called");
    }

    public AltExceptionC(String message) {
        super(message);
    }

    public AltExceptionC(String message, Throwable cause) {
        super(message, cause);
    }
}