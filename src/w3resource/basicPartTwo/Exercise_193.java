package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Accepts an integer and find the sum of all elements from all possible #
// #                     subsets of a set formed by first N natural numbers.                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : May 28, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_193 {

    private static Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String mess) {
        boolean isValid = false;
        int userData = -1;
        while (!isValid) {
            try {
                System.out.print(mess);
                userData = input.nextInt();
                isValid = true;
            } catch (Exception exc) {
                exc.printStackTrace();
                System.err.printf("[ERROR]: %s%n", exc.getMessage());
            }
        }
        return userData;
    }

    private static int findSubsetsSum(int maxNum) {
        int sum = (maxNum * (maxNum + 1) / 2) * (1 << (maxNum - 1));
        return sum;
    }

    public static void main(String[] args) {
        int userInput = obtainUserInput("Input a positive integer: ");
        int subsetsSum = findSubsetsSum(userInput);

        System.out.printf("Sum of all subsets: %d%n", subsetsSum);
    }
}
