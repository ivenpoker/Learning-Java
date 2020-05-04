package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_21;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 99999;
    private static final Scanner input = new Scanner(System.in);

    private static int getIntPartOfQuotient(int valA, int valB) {
        return valA / valB;
    }

    private static int getRemainderPartOfQuotient(int valA, int valB) {
        return valA % valB;
    }

    private static void displayDigits(int number) {

        int numOfDigits = numberOfDigits(number);

        int dividend = (int) Math.pow(10, numOfDigits-1);

        while (number > 0) {
            int digit =getIntPartOfQuotient(number, dividend);
            System.out.printf("%d ", digit);
            number = getRemainderPartOfQuotient(number, dividend);
            dividend /= 10;
        }
    }

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private static int numberOfDigits(int number) {
        int cnt = 0;
        while (number > 0) {
            number /= 10;
            cnt += 1;
        }
        return cnt;
    }

    private static int obtainNumberFromUser(String inputMessage) {
        System.out.print(inputMessage);
        int userVal = input.nextInt();

        while (!inRange(LOWER_BOUND, userVal, UPPER_BOUND)) {
            System.out.print(inputMessage);
            userVal = input.nextInt();
        }
        return userVal;
    }

    public static void main(String[] args) {

        int mainUserVal = obtainNumberFromUser(String.format("Enter a number in range [%d, %d]: ",
                                        LOWER_BOUND, UPPER_BOUND));
        System.out.print("Digits are: ");
        displayDigits(mainUserVal);

    }
}
