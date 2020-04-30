package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_25;

import java.util.Scanner;

public class AlternativeImplementation {

    private static int readUserInput(String message) {
        Scanner input = new Scanner(System.in);
        System.out.print(message);
        return input.nextInt();
    }

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    public static void printDiamond(int maxHeight) {
        if (maxHeight % 2 == 0) {
            maxHeight += 1;
            System.out.printf("Reshaping from height %d to %d, for better display.%n",
                    maxHeight-1, maxHeight);
        }

        int midHeight = maxHeight / 2;

        // Display first half of diamond (including center line)
        for (int i = 0, numStars = i+1; i < midHeight-1; i++, numStars += 2) {

            int numSpaces = maxHeight - numStars;

            // Print first set of spaces for this level
            for (int k = 0; k < numSpaces/2; k++) {
                System.out.print(' ');
            }

            // Print stars for this level
            for (int k = 0; k < numStars; k++) {
                System.out.print('*');
            }

            // Print second set of spaces for this level
            for (int k = 0; k < numSpaces/2; k++) {
                System.out.print(' ');
            }
            System.out.println();
        }

        // Display last half of diamond (excluding center line)
        for (int i = midHeight, numStars = maxHeight-2; i > 0; i--, numStars -= 2) {
            int numSpaces = maxHeight - numStars;

            // Print firs set of spaces for this level
            for (int k = 0; k < numSpaces/2; k++) {
                System.out.print(' ');
            }

            // Print stars for this level
            for (int k = 0; k < numStars; k++) {
                System.out.print('*');
            }

            // Print second set of spaces for this level
            for (int k = 0; k < numSpaces/2; k++) {
                System.out.print(' ');
            }

            // Move to a new line.
            System.out.println();
        }
    }

    public static void main(String[] args) {

        // Obtain user's data
        int userInt = readUserInput("Enter odd number in range [1, 19]: ");
        while (!inRange(1, userInt, 19) || userInt % 2 == 0) {
            userInt = readUserInput("Enter ODD number IN range [1, 19]: ");
        }
        System.out.println();

        // At this point user provided valid data.
        printDiamond(userInt);

    }
}
