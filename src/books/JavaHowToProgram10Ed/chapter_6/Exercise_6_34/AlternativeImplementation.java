package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_34;

public class AlternativeImplementation {

    private static final int UPPER_BOUND = 255;

    private static void displayTable(int upperBound) {

        System.out.printf("%3s | %8s | %3s | %5s%n", "DEC", "BIN", "OCT", "HEX");
        for (int i = 1; i <= upperBound; i++) {
            System.out.printf("%3d | %8s | %3s | %5s\n", i, Integer.toBinaryString(i),
                    Integer.toOctalString(i), Integer.toHexString(i));
        }
    }

    public static void main(String[] args) {

        displayTable(UPPER_BOUND);

    }
}
