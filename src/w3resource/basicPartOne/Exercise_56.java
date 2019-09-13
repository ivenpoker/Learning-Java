package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Finds the number of divisors for a number within a specified range #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class Exercise_56 {

    private static Scanner input = new Scanner(System.in);

    private static int readIntegerNumber(String mess) {
        int userNumber = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print(mess);
                userNumber = input.nextInt();
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

        return userNumber;
    }

    private static int findDivisorsOfNumberInRange(int low, int num, int high) {
        int numberOfDivisors = 0;
        for (int i = low; i < high; i++)
            if (i % num == 0)
                numberOfDivisors++;
        return numberOfDivisors;
    }

    public static void main(String[] args) {

        int lowerBound = readIntegerNumber("Enter lower bound: ");
        int upperBound = readIntegerNumber("Enter upper bound: ");
        int mainNum = readIntegerNumber("Enter number to find number of divisors: ");

        System.out.printf("Number of divisor within range: %d\n",
                findDivisorsOfNumberInRange(lowerBound, mainNum, upperBound));

    }
}
