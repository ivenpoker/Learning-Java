package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Determines if a user provided integer is positive or negative.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_1 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String inputMess) {
        boolean inputValid = false;
        int userIntVal = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userIntVal = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();                   // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userIntVal;
    }

    public static void main(String[] args) {

        int firstInt = obtainUserInput("Enter first integer value: ");
        System.out.printf("Is '%d' positive: %s%n", firstInt, firstInt > 0 ? "YES" : "NO");
    }

}
