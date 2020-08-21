package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Accepts three numbers from the user and prints "increasing" if the  #
// #                     numbers are in increasing order, "decreasing" if the numbers are in #
// #                     decreasing order, and "Neither increasing or decreasing order       #
// #                     otherwise.                                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 21, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_31 {

    private static final Scanner scanner = new Scanner(System.in);

    private static int readInputFromUser(String inputMess) {
        boolean inputValid = false;
        int userInput = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextInt();

                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();                 // clear input stream.

            } catch (IllegalArgumentException iAe) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", iAe.getMessage());
            }
        }
        return userInput;
    }

    public static void main(String[] args) {

        int fstInt = readInputFromUser("Enter first integer: ");
        int sndInt = readInputFromUser("Enter second integer: ");
        int thrdInt = readInputFromUser("Enter third integer: ");

        if (fstInt < sndInt && (sndInt < thrdInt || sndInt == thrdInt)) {
            System.out.println("increasing");

        } else if (fstInt > sndInt && (sndInt > thrdInt || sndInt == thrdInt)) {
            System.out.println("decreasing");

        } else {
            System.out.println("Neither increasing or decreasing order");
        }
    }

}
