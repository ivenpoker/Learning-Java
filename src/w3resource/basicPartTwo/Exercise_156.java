package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Finds the largest integer but not larger than the base-2     #
// #                     logarithm of a given integer.                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_156 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserData(String inputMessage) {
        boolean isValid = false;
        int userData = 0;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputExc) {
                System.err.println("Oops, invalid data");

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        return userData;
    }

    private static int findTheLargestInteger(int mainNum) {
        int shiftRightCount = 0;
        do {
            mainNum >>= 1;
            shiftRightCount++;
        } while (mainNum != 0);
        shiftRightCount--;
        return shiftRightCount;
    }

    public static void main(String[] args) {
        int userData = obtainUserData("Enter some number: ");
        System.out.printf("Result: %s\r\n", findTheLargestInteger(userData));
    }

}
