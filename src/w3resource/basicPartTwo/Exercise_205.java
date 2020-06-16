package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Checks whether a given integer is power of 2 or not using O(1) time.  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 16, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_205 {

    private static final int KEY_VALUE = 2;
    private static Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String inputMess) {
        boolean isValid = false;
        int userVal = -1;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userVal = input.nextInt();

                isValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("%n[INVALID_INPUT]: Please enter valid user data%n");
                input.nextLine();

            } catch (IllegalStateException iSe) {
                System.out.printf("%n[RE-OPENING_SCANNER] ... ");
                input = new Scanner(System.in);

            }
        }
        return userVal;
    }

    private static boolean isPowerOf2(int num) {
        boolean b = true;
        while (num != 1  && num > 0) {
            if (num % 2 != 0) {
                b = !b;
                break;
            }
            num /= 2;
        }
        return b;
    }

    public static void main(String[] args) {

        int userVal = obtainUserInput("Enter your integer value: ");

        long start = System.nanoTime();
        boolean isPowerOfKEY = isPowerOf2(userVal);
        long end = System.nanoTime();

        System.out.printf("Is '%d' a power of '%d': %s (time: %d)%n", userVal, KEY_VALUE, isPowerOfKEY, (end - start));

    }

}

