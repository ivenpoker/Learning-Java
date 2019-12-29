package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Multiply two given integers without using the multiply       #
// #                     operator.                                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_168 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserNumber(String inputMessage) {
        int userData = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMisMatchExc) {
                System.err.println("[INPUT_ERROR]: " + inputMisMatchExc.getMessage());

            } catch (IllegalStateException illegalStateExc) {
                System.err.print("[REBOOTING_SCANNER] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        return userData;
    }

    private static int multiply(int intA, int intB) {
        int result = 0;
        boolean negativeSum = (intA < 0 && intB >= 0) || (intB < 0 && intA >= 0);
        boolean positiveSum = !negativeSum;

        intA = Math.abs(intA);
        for (int i = 0; i < intA; i++) {
            if (negativeSum && intB > 0 || positiveSum && intB < 0) {
                result -= intB;
            } else {
                result += intB;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int firstVal = obtainUserNumber("Enter first integer: ");
        int secondVal = obtainUserNumber("Enter second integer: ");

        System.out.printf("Results after multiply '%d' and '%d': %d\n",
                firstVal, secondVal, multiply(firstVal, secondVal));
    }
}
