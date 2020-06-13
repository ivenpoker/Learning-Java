package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_19;

public class Exercise_11_19 {

    public static void main(String[] args) {

        try {
            SomeClass obj = new SomeClass();
            System.out.println("This is working really well!");
            System.out.println(obj);

        } catch (IllegalArgumentException iAe) {
            System.out.println("[EXCEPTION HANDLED]: Done");
            iAe.printStackTrace();

        } catch (Exception exc) {
            System.err.println("Hmm, something is wrong?");
            exc.printStackTrace();
        }

    }

}

class SomeClass {

    public SomeClass() {
        throw new IllegalArgumentException("Oops, something went wrong or did it?");
    }

}
