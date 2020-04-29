package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_13;

public class AlternativeImplementation {

    public static void main(String[] args) {

        long fact = 1;
        int MAX_TIMES = 20;

        for (int i = 1; i < MAX_TIMES; i++) {
            for (int j = i; j >= 1; j--) {
                fact *= j;
            }
            System.out.printf("!%2d: %19d%n", i, fact);
            fact = 1;
        }

    }

}
