package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Add two numbers without using operators like +, -, / and *.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_111 {

    private static Scanner scanner = new Scanner(System.in);

    private static long readInteger(String mess) {
        boolean isValid = false;
        long mainInt = 0;
        while (!isValid) {
            try {
                System.out.print(mess);
                mainInt = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("[ERROR]: Input is not an integer. Please try again.");

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[WARNING]: Scanner closed unexpectedly. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
        return mainInt;
    }

    private static long computeSumWithUsingOperators(long intA, long intB) {
        while (intB != 0) {
            long carry = intA & intB;
            intA ^= intB;
            intB = carry << 1;
        }
        return intA;
    }

    public static void main(String[] args) {
        long intA = readInteger("Enter integer A: ");
        long intB = readInteger("Enter integer B: ");
        System.out.printf("Sum is: %d\n", computeSumWithUsingOperators(intA, intB));
    }
}
