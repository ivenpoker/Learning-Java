package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Test if a given positive number is a perfect square or not.           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 4, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_197 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String mess) {
        boolean isValid = false;
        int userVal = 0;

        while (!isValid) {
            try {
                System.out.print(mess);
                userVal = input.nextInt();
                if (userVal >= 0) {
                    isValid = true;
                }
            } catch (InputMismatchException iMe) {
                System.err.printf("[INPUT_ERROR]: %s%n", iMe.getMessage());
            }
        }
        return userVal;
    }

    private static boolean isPerfectSquare(int someNum) {
        for (int i = 0; i <= someNum / 2; i++) {
            if (Math.pow(i, 2) == (double) someNum) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int userVal = obtainUserInput("Enter some positive integer: ");

        if (isPerfectSquare(userVal)) {
            System.out.printf("Number '%d' is a perfect square!%n", userVal);
        } else {
            System.out.printf("Number '%d' is NOT a perfect square!%n", userVal);
        }

    }
}
