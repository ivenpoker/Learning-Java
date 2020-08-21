package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Reads a floating-point number. If the number is zero it prints      #
// #                     "zero", otherwise, prints "positive" or "negative". Adds "small" if #
// #                     the number is less than 1, or "large" if it exceeds 1000000.        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_28 {

    private static final Scanner input = new Scanner(System.in);
    private static final float LOWER_BOUND = 1.0f;
    private static final float UPPER_BOUND = 1_000_000.0f;

    private static float obtainFloatDataFromUser(String inputMess) {
        boolean inputValid = false;
        float userInput = 0.0f;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    public static void main(String[] args) {

        float userInput = obtainFloatDataFromUser("Enter float input: ");
        if (userInput == 0.0f) {
            System.out.println("zero");
        } else {
            if (userInput > 0.0f) {
                System.out.print("positive ");
            } else {
                System.out.print("negative ");
            }
            if (Math.abs(userInput) < LOWER_BOUND) {
                System.out.println("small");

            } else if (Math.abs(userInput) > UPPER_BOUND) {
                System.out.println("large");
            } else {
                System.out.println();
            }
        }

    }

}
