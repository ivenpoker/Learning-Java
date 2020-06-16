package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Computes x^n % y where x, y and n are all 32bit integers.             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 16, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_204 {

    private static Scanner input = new Scanner(System.in);

    private static int getUserInput(String inputMess) {
        boolean isValid = false;
        int userVal = -1;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userVal = input.nextInt();

                isValid = true;

            } catch (InputMismatchException iMe) {
                System.out.printf("%n[INVALID_INPUT]: Please enter valid integer%n");
                input.nextLine();

            } catch (IllegalStateException iSe) {
                System.out.printf("%n[RE-OPENING_SCANNER] ... ");
                input = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        return userVal;
    }

    public static void main(String[] args) {
        int xVal = getUserInput("Enter value for x: ");
        int nVal = getUserInput("Enter value for n: ");
        int yVal = getUserInput("Enter value for y: ");

        double results = Math.pow(xVal, nVal) % yVal;
        System.out.printf("x^n %% y: %.1f%n", results);
    }
}
