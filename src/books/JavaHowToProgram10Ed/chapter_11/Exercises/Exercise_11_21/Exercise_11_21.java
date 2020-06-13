package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_21;

public class Exercise_11_21 {

    private static void method1() {
        try {

            // will throw 'IllegalArgumentException' which will not
            // be caught by the 'catch' block, hence thrown to the calling
            // method to handle it.

            method2();

        } catch (ArithmeticException iAe) {
            System.out.println("Exception handled in method1");
            iAe.printStackTrace();
        }
    }

    private static void method2() {
        throw new IllegalArgumentException("Oops, invalid arguments or is it?");
    }

    public static void main(String[] args) {

        try {
            method1();

        } catch (IllegalArgumentException iAe) {
            System.out.println("IllegalArgumentException handled in main");
            iAe.printStackTrace();

        } catch (Exception exception) {
            System.out.println("Handling exception with super class");
            exception.printStackTrace();
        }

    }
}
