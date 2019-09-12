package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Calculate the sum of two integers and return true if the sum is    #
// #                     equal to a third integer.                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_53 {

    private static Scanner input = new Scanner(System.in);

    private static int readIntegerFomConsole(String mess) {
        System.out.print(mess);
        int intNum = 0;
        try {
            intNum = input.nextInt();

        } catch (InputMismatchException exception) {
            System.err.println("Invalid integer input. Terminating...");
            System.exit(1);

        } catch (NoSuchElementException exception) {
            System.err.println("Input is exhausted. Terminating...");
            System.exit(1);

        } catch (IllegalStateException exception) {
            System.err.println("Scanner is closed");
            System.exit(1);
        }
        return intNum;
    }

    public static void main(String[] args) {

        int intA = readIntegerFomConsole("Enter the first number : ");
        int intB = readIntegerFomConsole("Enter the second number: ");
        int intC = readIntegerFomConsole("Enter the third number : ");

        System.out.printf("The result is: %s", (intA + intB == intC) ? "True" : "False");
    }

}
