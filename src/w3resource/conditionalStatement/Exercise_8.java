package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Obtains a character from the user and determines if character is a  #
// #                     vowel or consonant.                                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_8 {

    private static final Scanner input = new Scanner(System.in);
    private static final String vowels = "aeiou";

    private static char obtainCharFromUser(String inputMess) {
        boolean inputValid = false;
        char userChar = ' ';

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                String userInput = input.next().trim();

                if (userInput.length() != 1 || !Character.isAlphabetic(userInput.charAt(0))) {
                    throw new InputMismatchException("please enter a single alphabetic character.");
                }
                userChar = userInput.charAt(0);
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();                   // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userChar;
    }

    public static void main(String[] args) {

        char userChar = obtainCharFromUser("Enter an alphabetic character: ");
        System.out.printf("Character '%c' is: %s%n",
                userChar, vowels.contains(userChar + "") ? "vowel" : "consonant");

    }

}
