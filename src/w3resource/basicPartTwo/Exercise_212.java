package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Compute the digit number of sum of two given integers.                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 02, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_212 {

    private static Scanner scanner = new Scanner(System.in);

    private static int readUserInteger(String inputMess) {
        boolean valid = false;
        int userInt = 0;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInt = scanner.nextInt();
                valid = true;

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-OPENING__SCANNER] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();     // clear input stream

            } catch (InputMismatchException iMe) {
                System.err.print("[INVALID_INPUT]: Must be an integer value.");
                scanner.nextLine();     // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s%n", exc.getMessage());
                scanner.nextLine();     // clear input stream.
            }
        }

        return userInt;
    }

    private static int computeDigitSum(int firstInt, int secondInd) {
        String sumStr = String.format("%d", Math.abs(firstInt + secondInd));
        return sumStr.length();
    }

    public static void main(String[] args) {

        int firstInt = readUserInteger("Enter first number: ");
        int secondInt = readUserInteger("Enter second number: ");

        System.out.printf("Digit number of sum of said two integers: %d%n",
                computeDigitSum(firstInt, secondInt));

    }

}
