package w3resource.basicPartOne;

// ###############################################################################################
// #                                                                                             #
// #    Program Purpose: Accepts two integer values from the user and returns the larger value,  #
// #                     However if the two values are the same, return 0 and return the similar #
// #                     value if the two values have the same remainder when divided by 6.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                   #
// #    Creation Date  : September 13, 2019                                                      #
// #                                                                                             #
// ###############################################################################################


import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_63 {

    private static Scanner scanner = new Scanner(System.in);

    private static int readIntegerValueFromConsole(String message) {
        boolean isValid = false;
        int intVal = 0;

        do {
            try {
                System.out.print(message);
                intVal = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Invalid input. Please try again");

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Input is exhausted. Please try again.");
            }

            catch (IllegalStateException exc) {
                System.err.print("Scanner closed. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.print("[DONE]");
            }
        } while (!isValid);

        return intVal;
    }

    private static int processData(int valA, int valB) {
        if (valA == valB) return 0;

        int remA = valA % 6;
        int remB = valB % 6;

        if (remA == remB)
            return Math.min(valA, valB);
        return Math.max(valA, valB);
    }

    public static void main(String[] args) {

        // Get data from user...

        int valA = readIntegerValueFromConsole("Enter first integer : ");
        int valB = readIntegerValueFromConsole("Enter second integer: ");

        int info = processData(valA, valB);
        System.out.printf("Result is: %d\n", info);
    }
}
