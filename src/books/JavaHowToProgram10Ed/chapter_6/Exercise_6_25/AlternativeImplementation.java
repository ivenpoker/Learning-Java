package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_25;

public class AlternativeImplementation {

    private static final int UPPER_BOUND = 10000;

    public static boolean isPrime(int someNum) {
        if (someNum == 1) {
            return false;
        }
        return numberOfFactors(someNum) == 2;
    }

    public static int numberOfFactors(int someNum) {
        int cnt = 0;                                        // count for number of factors
        for (int i = 2; i <= someNum/2; i++) {
            if (someNum % i == 0) {
                cnt += 1;
            }
        }
        // Add 1 because a number is factor of itself, so the number
        // itself counts as a factor.
        return cnt + 1;
    }

    private static void findAndPrintPrimeNumbers(int upperBound) {
        int cnt = 0;
        for (int i = 1; i <= upperBound; i++) {
            if (isPrime(i)) {
                System.out.printf("%10s: %4d%n", String.format("Prime #%d", ++cnt), i);
            }
        }
    }

    public static void main(String[] args) {

        findAndPrintPrimeNumbers(UPPER_BOUND);

    }
}
