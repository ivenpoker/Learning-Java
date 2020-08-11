package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Compute the floor division and the floor modulus of the given       #
// #                     dividend and divisor.                                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_13 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserIntegerInput(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    public static void main(String[] args) {

        int dividend = obtainUserIntegerInput("Enter dividend value: ");
        int divisor = obtainUserIntegerInput("Enter divisor value: ");

        System.out.printf("Floor division using '/' operator: %d%n", dividend / divisor);
        System.out.printf("Floor division using floorDiv() method is: %d%n", Math.floorDiv(dividend, divisor));
        System.out.println();
        System.out.printf("Floor modulus using '%%' operator: %d%n", dividend % divisor);
        System.out.printf("Floor modulus using floorMod() method is: %d%n", Math.floorMod(dividend, divisor));


    }
}
