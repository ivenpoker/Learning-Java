package w3resource.basicPartOne;

// ##############################################################################
// #                                                                            #
// #    Program Purpose: Find the number of bits required to flip to convert    #
// #                     two given integers.                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                  #
// #    Creation Date  : November 22, 2019                                      #
// #                                                                            #
// ##############################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_147 {

    private static Scanner scanner = new Scanner(System.in);

    public static int getUserIntegerData(String inputMessage) {

        int userVal = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userVal = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.println("Invalid input");

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        return userVal;
    }

    private static int bitSwapRequired(int x, int y) {
        int ctr = 0;
        for (int z = x ^ y; z != 0; z = z >>> 1) {
            ctr += z & 1;
        }
        return ctr;
    }

    public static void main(String[] args) {
        int firstVal = getUserIntegerData("Enter first integer: ");
        int secondVal = getUserIntegerData("Enter second integer: ");
        int numBits = bitSwapRequired(firstVal, secondVal);

        System.out.printf("Number of bits required to flip to convert is: %d\n",
                numBits);
    }
}
