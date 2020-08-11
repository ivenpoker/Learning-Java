package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Breaks an integer into a sequence of individual digits.             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_10 {

    private static final Scanner input = new Scanner(System.in);

    private static long obtainUserInteger(String inputMess) {
        boolean inputValid = false;
        long userInt = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (userInt < 0) {
                    throw new InputMismatchException("please enter positive input");
                }

                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static int numberOfDigits(long mainNumber) {
        int cnt = 0;
        while (mainNumber > 0) {
            mainNumber /= 10;
            cnt += 1;
        }
        return cnt;
    }

    private static long[] processNumber(long mainNumber) {
        int numberOfDigits = numberOfDigits(mainNumber);
        long[] digits = new long[numberOfDigits];

        int i = numberOfDigits-1;
        while (i >= 0) {
            digits[i] = mainNumber % 10;
            mainNumber /= 10;
            i--;
        }
        return digits;
    }

    public static void main(String[] args) {

        long mainNum = obtainUserInteger("Enter a positive integer: ");
        long[] digits = processNumber(mainNum);

        System.out.printf("Digits array: %s%n", Arrays.toString(digits));
        System.out.print("Digits: ");

        for (long digit : digits) {
            System.out.printf("%d ", digit);
        }
        System.out.println();
    }

}
