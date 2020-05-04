package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_24;

public class AlternativeImplementation {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 1000;

    public static boolean isPerfect(int someNum) {
        int sum = 0;                                        // holds sum of factors of 'someNum'
        for (int i = 1; i <= someNum / 2; i++) {
            if (someNum % i == 0) {                         // if 'i' is a factor 'someNum'
                sum += i;                                   // Add it to 'sum of factors' so far.
            }
        }

        // If the sum equals the number passed
        // as parameter to this method, this means
        // that the parameter is a perfect square
        return sum == someNum;
    }

    public static void findPerfectNumbersInRange(int low, int high) {
        for (int i = low; i <= high; i++) {
            if (isPerfect(i)) {
                String factors = String.format("%4d = ", i);
                for (int j = 1; j <= i / 2; j++) {
                    if (i % j == 0) {
                        if (j == (i/2)) {
                            factors += String.format("%d", j);
                        } else {
                            factors += String.format("%d + ", j);
                        }
                    }
                }
                System.out.println(factors);
            }
        }
    }

    public static void main(String[] args) {

        findPerfectNumbersInRange(LOWER_BOUND, UPPER_BOUND);

    }
}
