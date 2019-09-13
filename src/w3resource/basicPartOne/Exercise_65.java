package w3resource.basicPartOne;

// ###############################################################################################
// #                                                                                             #
// #    Program Purpose: Find the remainder when two numbers are divided without using the '%'   #
// #                     operator.                                                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                   #
// #    Creation Date  : September 13, 2019                                                      #
// #                                                                                             #
// ###############################################################################################

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_65 {

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

    private static int findRemainderWithoutUsingInBuildModulorOperator(int valA, int valB) {
        int divided = valA / valB;
        return valA - (divided * valB);
    }

    public static void main(String[] args) {

        int valA = readIntegerValueFromConsole("Enter first number : ");
        int valB = readIntegerValueFromConsole("Enter second number: ");

        System.out.printf("Remainder without using %% operator: %d\n",
                findRemainderWithoutUsingInBuildModulorOperator(valA, valB));

    }
}
