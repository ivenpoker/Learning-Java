package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Transforms a given integer to String format.                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_166 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserData(String inputMessage) {
        int userData = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextInt();
                isValid = true;

            } catch (IllegalStateException illegalStateExc) {
                System.err.println("[REOPENING_SCANNER]: " + illegalStateExc.getMessage());

            } catch (Exception exc) {
                System.err.println("[SYSTEM_ERROR]: " + exc.getMessage());
            }
        }
        return userData;
    }

    private static String transformIntToString(int intVal) {
        return Integer.toString(intVal);
    }

    public static void main(String[] args) {

        int userInt = obtainUserData("Enter integer value: ");
        System.out.printf("String format of the said integer: %s\n",
                transformIntToString(userInt));
    }
}
