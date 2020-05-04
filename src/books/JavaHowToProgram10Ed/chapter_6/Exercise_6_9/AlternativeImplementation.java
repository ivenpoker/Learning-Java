package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_9;

import java.util.Scanner;

public class AlternativeImplementation {

    private static final double INPUT_END_VALUE = 0.0;
    private static final Scanner input = new Scanner(System.in);

    private static double readUserNumber(String message) {
        System.out.print(message);
        return input.nextDouble();
    }

    private static int roundNumber(double someNum) {
        return (int) Math.floor(someNum + 0.5);
    }

    public static void main(String[] args) {
        double userVal;
        do {
            userVal = readUserNumber("Enter a double value to round [0 to stop]: ");
            if (userVal != INPUT_END_VALUE) {
                System.out.printf("Original value was '%.2f' and rounded value is: %d%n",
                        userVal, roundNumber(userVal));
            }
        } while (userVal != INPUT_END_VALUE);
    }

}
