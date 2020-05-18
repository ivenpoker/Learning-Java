package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_14;

public class AlternativeImplementation {

    public static int product(int... intValues) {
        int product = 1;
        for (int val : intValues) {
            product *= val;
        }
        return product;
    }

    public static void main(String[] args) {
        System.out.printf("Test A: %d%n", product(1, 2, 3, 4));
        System.out.printf("Test B: %d%n", product(5, 6, 7, 8, 9));
        System.out.printf("Test C: %d%n", product(9, 2, 3, 1));
    }
}
