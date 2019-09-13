package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Accepts three integer values and return true if one of them is 20  #
// #                     or more and less than the subtractions of others.                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 13, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_62 {

    private static Scanner scanner = new Scanner(System.in);

    private static int readIntegerFromConsole(String message) {
        boolean isValid = false;
        int intVal = 0;

        do {
            try {
                System.out.print(message);
                intVal = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Invalid input. Please try again.");

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Input has been exhausted. Try again");

            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner has been closed. Re-opening scanner....");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        } while (!isValid);
        return intVal;
    }

    private static boolean processData(int valA, int valB, int valC) {
        // checking for valA....
        int subVal = Math.abs(valB - valC);

        if ((valA == (subVal + 20)) || (valA == Math.abs(subVal - 20))) {
            return true;
        }

        // checking for valB...
        subVal = Math.abs(valA - valC);
        if ((valB == (subVal + 20)) || (valB == Math.abs(subVal - 20))) {
            return true;
        }

        // finally, checking for valC..
        subVal = Math.abs(valA - valB);
        return (valC == (subVal + 20)) || (valC == Math.abs(subVal - 20));
    }

    public static void main(String[] args) {
        int valA = readIntegerFromConsole("Enter first integer value : ");
        int valB = readIntegerFromConsole("Enter second integer value: ");
        int valC = readIntegerFromConsole("Enter third integer value : ");

        System.out.printf("Passes conditions: %s\n",
                processData(valA, valB, valC) ? "YES" : "NO");
    }
}
