package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_16;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.10 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : July 24, 2019                                              #
// #                                                                                  #
// ####################################################################################

public class App {

    public static void throwA() throws ExceptionA {
        throwB();
    }

    public static void throwB() throws ExceptionB {
        throwC();
    }

    public static void throwC() throws ExceptionC {
        throw new ExceptionC();
    }

    public static void main(String[] args) {

        try {
            throwA();
        } catch (ExceptionA exceptionA) {
            StackTraceElement[] stackTraceElements = exceptionA.getStackTrace();

            for (StackTraceElement elem : stackTraceElements) {
                System.out.printf("%10s %10s %10s: Line %d\n", elem.getClassName(),
                        elem.getMethodName(), elem.getFileName(), elem.getLineNumber());
            }
        }
//        try {
//            throwA();
//        } catch (ExceptionC exceptionA) {
//            System.err.println("Exception C caught");
//        } catch (ExceptionB exceptionB) {
//            System.err.println("Exception B caught");
//        } catch (ExceptionA exceptionC) {
//            System.err.println("Exception A caught");
//        }
    }

}
