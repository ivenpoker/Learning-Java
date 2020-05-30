package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_9;

import static java.lang.Math.sqrt;
import static java.lang.Math.ceil;
import static java.lang.Math.E;
import static java.lang.Math.PI;

public class AlternativeImplementation {

    public static void main(String[] args) {
        System.out.printf("%12s: %.1f%n", "sqrt(900.0)", sqrt(900.0));
        System.out.printf("%12s: %.1f%n", "ceil(-9.8)", ceil(-9.8));
        System.out.printf("%12s: %f%n", "E", E);
        System.out.printf("%12s: %f%n", "PI", PI);
    }

}

