package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_20;

public class Exercise_11_20 {

    private static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception exception) {
            throw exception;
        }
    }

    private static void someMethod2() throws Exception {
        throw new Exception("someMethod2() exception");
    }

    public static void main(String[] args) {

        try {
            someMethod();

        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

}

