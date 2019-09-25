package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Adds all the digits of a given positive integer until the result has a single   #
// #                     digit.                                                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_108 {

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

    private static long findSumOfDigits(long mainNum) {
        String[] digits = String.format("%d", mainNum).split("");
        long sum = 0;
        for (String digit : digits) {
            try {
                sum += Integer.parseInt(digit);
            } catch (NumberFormatException exception) {
                System.err.printf("[ERROR]: Can't convert '%s' to a digit.", digit);

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
        return sum;
    }

    private static void processData(long mainInt) {

        mainInt = Math.abs(mainInt);

        while (mainInt >= 10) {

            long tempSum = findSumOfDigits(mainInt);
            String[] digits = String.format("%d", mainInt).split("");
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < digits.length; i++) {
                if (i != digits.length-1) {
                    tmp.append(String.format("%s + ", digits[i]));
                } else {
                    tmp.append(String.format("%s = ", digits[i]));
                }
            }
            tmp.append(tempSum);
            System.out.println(tmp.toString());

            if (tempSum >= 10) {
                mainInt = tempSum;
            } else {
                mainInt = tempSum;
                break;
            }
        }
        System.out.printf("Final sum-of-digits is: %d\n", mainInt);
    }

    public static void main(String[] args) {
        long mainInt = readInteger("Enter a number to sum digit, till sum is a single digit: ");
        processData(mainInt);

    }
}
