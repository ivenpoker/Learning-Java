package w3resource.basicPartTwo;

// #######################################################################################
// #                                                                                     #
// #    Program Purpose: Accepts an integer and convert it into a binary representation. #
// #                     Then counts the number of bits which is equal to zero of the    #
// #                     said binary representation.                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                           #
// #    Creation Date  : December 29, 2019                                               #
// #                                                                                     #
// #######################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_163 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserData(String inputMess) {
        int userData = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userData = scanner.nextInt();
                valid = true;

            } catch (InputMismatchException inputMismatchExc) {
                System.err.println("[INPUT_ERROR]: " + inputMismatchExc);

            } catch (IllegalStateException illegalStateExc) {
                System.err.print("[REBOOTING_SCANNER] ... ");
                scanner = new Scanner(System.in);

            } catch (Exception exc) {
                System.err.println("[ERROR]: " + exc.getMessage());
            }
        }
        return userData;
    }

    private static String intToBin(int mainInt) {
        return Integer.toBinaryString(mainInt);
    }

    private static int countNumberOfChar(String mainData, char key) {
        int cnt = 0;
        for (char tempChar : mainData.toCharArray()) {
            if (tempChar == key) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        int userVal = obtainUserData("Enter first number: ");
        String binVal = intToBin(userVal);

        System.out.printf("Binary equivalent of '%d': %s\n", userVal, binVal);
        System.out.printf("  Number of '0' in binary: %s\n", countNumberOfChar(binVal, '0'));
    }
}
