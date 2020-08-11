package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Accepts two integers from the user and then prints the sum, the     #
// #                     difference, the product, the average, the distance (the difference  #
// #                     between integer), the maximum (the larger of the two integers), the #
// #                     minimum (smaller of the two integers).                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_9 {

    private static final Scanner input = new Scanner(System.in);

    private static int readUserInteger(String inputMess) {
        boolean inputValid = false;
        int userInt = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();           // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    public static void main(String[] args) {

        int int1 = readUserInteger("Enter first integer: ");
        int int2 = readUserInteger("Enter second integer: ");

        System.out.printf("Sum of two integers: %d%n", (int1 + int2));
        System.out.printf("Difference of two integers: %d%n", (int1 - int2));
        System.out.printf("Product of two integers: %d%n", (int1 * int2));
        System.out.printf("Average of two integers: %.2f%n", (double)(int1 + int2) / 2);
        System.out.printf("Distance of two integers: %d%n", (int1 - int2));
        System.out.printf("Max integer: %d%n", Math.max(int1, int2));
        System.out.printf("Max integer: %d%n", Math.min(int1, int2));

    }
}
