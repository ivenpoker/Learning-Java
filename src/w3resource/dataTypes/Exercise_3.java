package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Reads an integer between 0 and 1000 and adds all the digits in the  #
// #                     integer.                                                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_3 {

    private static final Scanner input = new Scanner(System.in);
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 1000;

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private static int readUserNumber(String inputMess, int lower, int upper) {
        boolean inputValid = false;
        int userNum = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userNum = input.nextInt();

                if (!inRange(lower, userNum, upper)) {
                    throw new InputMismatchException(
                            String.format("Input out of range. Must be in [%d, %d]", lower, upper));
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userNum;
    }

    private static int findSumOfDigits(int someNum) {
        String numStr = String.format("%d", someNum);
        return Arrays.stream(numStr.split("")).mapToInt(Integer::parseInt).sum();
    }

    public static void main(String[] args) {

        int readUserNum = readUserNumber(String.format("Enter integer in range [%d, %d]: ",
                                        LOWER_BOUND, UPPER_BOUND), LOWER_BOUND, UPPER_BOUND);
        System.out.printf("Sum of digits in '%d': %d%n", readUserNum, findSumOfDigits(readUserNum));

    }

}
