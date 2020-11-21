package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the character (Unicode code point) at the given index within   #
// #                     the String.                                                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 21, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_2 {

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

    private static int getUnicodeCodePointAtIndex(String mainStr, int idx) {
        return mainStr.charAt(idx);
    }

    public static void main(String[] args) {
        String mainTestData = "This is just a test string data input";

        System.out.printf("[TEST_DATA]: %s%n", mainTestData);
        int userIdx = getUserIndex("Enter index to get char Unicode: ", 0, mainTestData.length());

        System.out.printf("Character (unicode point): %d%n", getUnicodeCodePointAtIndex(mainTestData, userIdx));
        System.out.printf("Character (unicode point): %d%n", mainTestData.codePointAt(userIdx));
    }

}
