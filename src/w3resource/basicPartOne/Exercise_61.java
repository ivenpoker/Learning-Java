package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Reverse a string obtained from user.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 13, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_61 {

    private static Scanner input = new Scanner(System.in);

    private static String readLine(String message) {
        boolean isValid = false;
        String inputString = "";

        do {
            try {
                System.out.print(message);
                inputString = input.nextLine().trim();
                isValid = true;

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("No more input left.");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner has been closed.");
            }
        } while (!isValid);
        return inputString;
    }

    private static String reverseLine(String someString) {
        return (new StringBuilder(someString)).reverse().toString();
    }

    public static void main(String[] args) {
        String userInput = readLine("Enter a sentence (or word): ");
        String reversedUserInput = reverseLine(userInput);

        System.out.printf("Reversed input: %s\n", reversedUserInput);
    }
}
