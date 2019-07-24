package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_16;

public class ExceptionA extends Exception {

    public ExceptionA() {
        super("Exception from A");
    }

    public ExceptionA(String mess) {
        super("Exception from A", new Throwable(mess));
    }

    public ExceptionA(Throwable exception) {
        super("Exception from A", exception);
    }
}
