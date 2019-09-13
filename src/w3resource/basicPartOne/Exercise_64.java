package w3resource.basicPartOne;

// ###############################################################################################
// #                                                                                             #
// #    Program Purpose: Accepts two integer values between 25 to 75 and return true if there is #
// #                     a common digit in both numbers.                                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                   #
// #    Creation Date  : September 13, 2019                                                      #
// #                                                                                             #
// ###############################################################################################

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_64 {

    private static Scanner scanner = new Scanner(System.in);

    private static int readIntegerInRangeInclusively(String message, int low, int high) {
        boolean isValid = false;
        int intVal = 0;

        do {
            try {
                System.out.print(message);
                intVal = scanner.nextInt();

                if (low <= intVal && intVal <= high) {
                    // Data is valid.
                    isValid = true;
                } else {
                    throw new IllegalArgumentException(String.format("Invalid argument '%d'. " +
                            "Must be in range [%d, %d].", intVal, low, high));
                }

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Invalid input. Please try again.");

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Input has been exhausted. Try again.");

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner has been closed. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (IllegalArgumentException illegalArgumentException) {
                System.err.println(illegalArgumentException.getMessage());

            }
        } while (!isValid);

        return intVal;
    }

    private static boolean processData(int valA, int valB) {
        String strA = Integer.toString(valA);
        String strB = Integer.toString(valB);

        for (Character ch : strA.toCharArray()) {
            if (strB.contains(String.format("%c", ch))) {
                // found common digit (character in this case).
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int valA = readIntegerInRangeInclusively("Enter first integer : ", 25, 75);
        int valB = readIntegerInRangeInclusively("Enter second integer: ", 25, 75);

        boolean result = processData(valA, valB);
        System.out.printf("Passes condition: %s\n", result ? "YES" : "NO");
    }
}
