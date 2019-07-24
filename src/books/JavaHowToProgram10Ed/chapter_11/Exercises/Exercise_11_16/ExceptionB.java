package books.JavaHowToProgram10Ed.chapter_11.Exercises.Exercise_11_16;

public class ExceptionB extends ExceptionA {
    public ExceptionB(String mess) {
        super(mess);
    }
    public ExceptionB() {
        super("Exception from B");
    }
}
