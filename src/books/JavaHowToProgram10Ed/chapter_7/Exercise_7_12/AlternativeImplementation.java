package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_12;

import java.util.Arrays;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);
    private static final int MAX_NUMBERS_TO_READ = 5;
    private static final int LOWER_BOUND = 10;
    private static final int UPPER_BOUND = 100;

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private static int[] readFiveNumbers() {

        int[] userData = new int[MAX_NUMBERS_TO_READ];

        for (int i = 0, k = 0; i < MAX_NUMBERS_TO_READ; i++) {
            System.out.printf("Enter a number [%d left]: ", (MAX_NUMBERS_TO_READ-1)-i);
            int userInput = input.nextInt();

            // Check if input was already read.
            boolean found = false;
            for (int userDatum : userData) {
                if (userDatum == userInput) {
                    found = true;
                    break;
                }
            }
            if (!found && inRange(LOWER_BOUND, userInput, UPPER_BOUND)) {
                userData[k++] = userInput;
            }
            // display current data read.
            System.out.print("Current read items: [");
            for (int j = 0; j < userData.length; j++) {
                if (inRange(LOWER_BOUND, userData[j], UPPER_BOUND)) {
                    System.out.printf("%d, ", userData[j]);
                }
            }
            System.out.println("]");
        }
        return userData;
    }

    public static void main(String[] args) {
        int[] mainData = readFiveNumbers();
        System.out.printf("Data read: %s%n", Arrays.toString(mainData));

    }
}
