package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Gets the character (Unicode code point) before the specified index  #
// #                     within the string.                                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 21, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_3 {

    private static final Scanner scanner = new Scanner(System.in);

    private static int getUserSpecifiedIndex(String mess, int lower, int upper) {
        boolean isValid = false;
        int userInputInt = -1;

        while (!isValid) {
            try {
                System.out.print(mess);
                userInputInt = scanner.nextInt();

                if (userInputInt < lower || userInputInt >= upper) {
                    throw new InputMismatchException(
                            String.format("Invalid specified input. Must be in range [%d, %d]",
                                    lower, upper));
                }
                isValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getCause().getMessage());
            }
        }
        return userInputInt;
    }

    public static void main(String[] args) {
        String mainStr = "This is a test string here";

        System.out.printf("[MAIN_STRING]: %s%n", mainStr);

        int userIdx = getUserSpecifiedIndex("Enter index to get character (Unicode code point) before: ",
                0, mainStr.length());

        try {
            int uniCodePoint = mainStr.codePointBefore(userIdx);
            System.out.printf("Character (unicode point) = %d%n", uniCodePoint);

        } catch (IndexOutOfBoundsException iBe) {
            System.err.println("[index_error]: NO character before specified index");

        } catch (Exception exc) {
            System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getCause().getMessage());
        }
    }
}
