package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Find the number of factors of a user defined number.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_57 {

    private static Scanner input = new Scanner(System.in);

    private static int countNumberOfFactors(int someNum) {
        int factorCount = 0;
        for (int i = 1; i <= someNum / 2; i++)
            if (someNum % i == 0)
                factorCount++;
        return factorCount + 1; // + 1 because every number is factor of itself.
    }

    private static int readIntegerNumber(String mess) {
        int someNumber = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print(mess);
                someNumber = input.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatch) {
                System.err.println("Invalid input");

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("Input has been exhausted.");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner is closed");
                input = new Scanner(System.in);                 // re-open scanner
            }
        } while (!isValid);

        return someNumber;
    }

    public static void main(String[] args) {
        int mainNumber = readIntegerNumber("Enter an integer: ");
        System.out.printf("Number of factors of %d: %d\n", mainNumber,
                countNumberOfFactors(mainNumber));
    }

}
