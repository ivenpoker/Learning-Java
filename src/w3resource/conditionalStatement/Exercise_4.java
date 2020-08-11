package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Reads a floating-point number and prints "zero" if the number is    #
// #                     zero. Otherwise, print "positive" or "negative". Add "small" if the #
// #                     absolute value of the number is less than 1, or "large" if it       #
// #                     exceeds 1,000,000.                                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_4 {

    private static final Scanner input = new Scanner(System.in);

    private static float obtainIntValueFromUser(String inputMess) {
        boolean inputValid = false;
        float userIntVal = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userIntVal = input.nextFloat();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.out.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userIntVal;
    }

    public static void main(String[] args) {

        float userFloat = obtainIntValueFromUser("Enter a floating-point number: ");
        if (userFloat == 0) {
            System.out.println("zero");
        } else {
            if (userFloat > 0) {
                System.out.println("Positive");
            } else {
                System.out.println("Negative");
            }
            if (Math.abs(userFloat) < 1) {
                System.out.println("small");
            } else if (userFloat > 1_000_000) {
                System.out.println("large");
            }
        }

    }
}
