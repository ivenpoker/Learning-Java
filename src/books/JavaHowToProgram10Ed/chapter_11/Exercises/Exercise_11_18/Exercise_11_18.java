package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_18;

public class Exercise_11_18 {

    public static void main(String[] args) {

        // Demonstrating that the order of the 'catch' block
        // is important. The code below has been commented out
        // because it cause issues in my IDE when working with
        // other codes (during their compilation). Basically,
        // the code in the 'try' block with throw a 'NullPointerException'
        // and it'll be caught by the very first 'catch' block because
        // all exceptions inherit from 'Exception' so all other 'catch'
        // blocks, catching any exception which is a subclass of 'Exception'
        // will not be executed.

//        try {
//            String test = "test";
//            test = null;
//            System.out.println(test.charAt(0));
//
//        } catch (Exception exception) {
//            exception.printStackTrace();
//
//        } catch (NullPointerException nullPointerException) {
//            nullPointerException.printStackTrace();
//        }

    }
}
