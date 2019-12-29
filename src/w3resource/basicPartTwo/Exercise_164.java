package w3resource.basicPartTwo;


// ######################################################################################
// #                                                                                    #
// #    Program Purpose: Divides two user obtained integers using subtraction operator. #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                          #
// #    Creation Date  : December 29, 2019                                              #
// #                                                                                    #
// ######################################################################################

import java.util.Scanner;

public class Exercise_164 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserInput(String inputMessage) {
        int userData = 0;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextInt();
                isValid = true;

            } catch (IllegalArgumentException illegalArgExc) {
                System.err.println("[INPUT_ERROR]: " + illegalArgExc.getMessage());

            } catch (IllegalStateException illegalStateExc) {
                System.out.print("[REBOOTING_SCANNER] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        return userData;
    }

    private static float divideUsingSubtraction(int dividend, int divider) {
        if (divider == 0) {
            return 0;
        }
        float result = 0;
        while (dividend > divider) {
            dividend -= divider;
            result++;
        }
        float decimalPart = (float) dividend / (float) divider;
        result += decimalPart;

        return result;
    }

    public static void main(String[] args) {

        int dividend = obtainUserInput("Enter dividend (integer): ");
        int divisor = obtainUserInput(" Enter divider (integer): ");

        System.out.printf("Result after division: %.1f\n", divideUsingSubtraction(dividend, divisor));
    }
}
