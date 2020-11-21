package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the character at the given index within the string.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 21, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_1 {

    private static final Scanner scanner = new Scanner(System.in);

    private static int getUserIndex(String inputMess, int lowerBound, int upperBound) {
        boolean inputValid = false;
        int userIndx = -1;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userIndx = scanner.nextInt();

                if (userIndx < lowerBound || userIndx >= upperBound) {
                    throw new InputMismatchException(String.format("Invalid specified index." +
                            " Expected index in range [%d, %d]", lowerBound, upperBound-1));
                }
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getCause().getMessage());
            }
        }
        return userIndx;
    }

    public static void main(String[] args) {
        String mainStr = "This is just a test string";

        System.out.printf("[TEST_STRING]: %s%n", mainStr);
        int userIdx = getUserIndex("Enter index to get character at: ", 0, mainStr.length());

        System.out.printf("The character at position '%d' is: %c%n", userIdx, mainStr.charAt(userIdx));
    }

}
