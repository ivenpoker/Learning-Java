package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_12;

public class AlternativeImplementation {

    public static void main(String[] args) {

        int MAX_NUM = 15;           // Iteration max
        int product = 1;            // Product store for all odd numbers

        System.out.println("Performing product ...");
        for (int i = 1; i <= MAX_NUM; i += 2) {
            product  *= i;
        }
        System.out.printf("Product of odd in range [1, 15]: %d%n", product);

    }
}
