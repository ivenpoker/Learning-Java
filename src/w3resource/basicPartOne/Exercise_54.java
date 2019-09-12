package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Accepts three integers from the user and return true if two or     #
// #                     more of them (integers) have the same rightmost digit.             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_54 {

    private static Scanner input = new Scanner(System.in);

    private static int readIntegerFomConsole(String mess) {
        System.out.print(mess);
        int intNum = 0;
        try {
            intNum = input.nextInt();
            if (intNum < 0)
                throw new IllegalArgumentException("Invalid input. Number must be positive.");

        } catch (InputMismatchException exception) {
            System.err.println("Invalid integer input. Terminating...");
            System.exit(1);

        } catch (NoSuchElementException exception) {
            System.err.println("Input is exhausted. Terminating...");
            System.exit(1);

        } catch (IllegalStateException exception) {
            System.err.println("Scanner is closed");
            System.exit(1);

        } catch (IllegalArgumentException exception) {
            System.err.println(exception.getMessage());
            System.exit(1);
        }
        return intNum;
    }

    private static boolean processIntegers(int intA, int intB, int intC) {
        String intAStr = Integer.toString(intA);
        String intBStr = Integer.toString(intB);
        String intCStr = Integer.toString(intC);

        if (intAStr.charAt(intAStr.length()-1) == intBStr.charAt(intBStr.length()-1)) return true;
        if (intBStr.charAt(intBStr.length()-1) == intCStr.charAt(intCStr.length()-1)) return true;
        if (intAStr.charAt(intAStr.length()-1) == intCStr.charAt(intCStr.length()-1)) return true;

        return false;
    }

    public static void main(String[] args) {

        int intA = readIntegerFomConsole("Enter first number : ");
        int intB = readIntegerFomConsole("Enter second number: ");
        int intC = readIntegerFomConsole("Enter third number : ");

        boolean results = processIntegers(intA, intB, intC);
        System.out.printf("The result is: %s\n", results ? "YES" : "NO");

    }

}
