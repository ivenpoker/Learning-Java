package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the maximum of three integer values obtained from user.       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_3 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainNumberFromUser(String inputMess) {
        boolean inputValid = false;
        int userIntVal = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userIntVal = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userIntVal;
    }

    private static int findMaxOfThree(int valA, int valB, int valC) {
        return Math.max(valA, Math.max(valB, valC));
    }

    public static void main(String[] args) {

        int firstInt = obtainNumberFromUser("Enter first integer: ");
        int secondInt = obtainNumberFromUser("Enter second integer: ");
        int thirdInt = obtainNumberFromUser("Enter third integer: ");

        int maxNum = firstInt;
        if (secondInt > maxNum) {
            maxNum = secondInt;
        }
        if (thirdInt > maxNum) {
            maxNum = thirdInt;
        }

        System.out.printf("Max of %d, %d and %d (using 'if'): %d%n", firstInt, secondInt, thirdInt, maxNum);
        System.out.printf("Max of %d, %d and %d: %d%n", firstInt, secondInt, thirdInt,
                findMaxOfThree(firstInt, secondInt, thirdInt));

    }

}
