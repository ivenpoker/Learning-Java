package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Accepts three numbers from user and prints "All numbers are equal"  #
// #                     if all three numbers are equal, "All numbers are different" if all  #
// #                     three numbers are different and "Neither all are equal or different"#
// #                     otherwise.                                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_30 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainInputFromUser(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput =  input.nextInt();

                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[input_valid]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    public static void main(String[] args) {

        int fstInt = obtainInputFromUser("Enter first number: ");
        int sndInt = obtainInputFromUser("Enter second number: ");
        int thrdInt = obtainInputFromUser("Enter third number: ");

        if (fstInt == sndInt && sndInt == thrdInt) {
            System.out.println("All numbers are equal");

        } else if (fstInt != sndInt && sndInt != thrdInt && fstInt != thrdInt) {
            System.out.println("All numbers are different");

        } else {
            System.out.println("Neither all are equal or different");
        }
    }

}
