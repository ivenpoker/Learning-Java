package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_17;

import java.io.IOException;

public class Exercise_11_17 {

    public static void main(String[] args) {

        // Throwing 'ExceptionA'
        try {
            throw new ExceptionA();

        } catch (Exception exceptionA) {
            exceptionA.printStackTrace();
        }

        System.out.println();

        // Throwing 'ExceptionB'
        try {
            throw new ExceptionB();

        } catch (Exception exceptionB) {
            exceptionB.printStackTrace();
        }

        System.out.println();

        // Throwing 'NullPointerException'
        try {
            String mess = "test";
            mess = null;

            // This will throw a 'NullPointerException' because
            // we've explicitly assign 'null' to 'mess' above.

            System.out.println(mess.charAt(0));

        } catch (Exception exception) {
            exception.printStackTrace();
        }

        // Throwing an 'IOException' explicitly
        try {
            throw new IOException("IO Exception just occurred");

        } catch (Exception ioException) {
            ioException.printStackTrace();
        }
    }
}

class ExceptionA extends Exception {

    public ExceptionA() {
        super("Exception A occurred");
    }

    public ExceptionA(String message) {
        super(message);
    }

    public ExceptionA(String message, Throwable cause) {
        super(message, cause);
    }
}

class ExceptionB extends ExceptionA {

    public ExceptionB() {
        super("Exception B occurred");
    }

    public ExceptionB(String message) {
        super(message);
    }

    public ExceptionB(String message, Throwable cause) {
        super(message, cause);
    }

}
