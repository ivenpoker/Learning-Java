package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Reads a sentence from console, and converts it all to lowercase.   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_59 {

    private static Scanner input = new Scanner(System.in);

    private static String readLineFromConsole(String message) {
        String mainLine = "";
        boolean isValid = false;

        do {
            try {
                System.out.print(message);
                mainLine = input.nextLine().trim();
                isValid = true;

            } catch (NoSuchElementException noSuchElementException) {
                System.err.println("No input provided. Please try again.");

            } catch (IllegalStateException illegalStateException) {
                System.err.println("Scanner is closed. ");
            }
        } while (!isValid);

        return mainLine;
    }

    private static String lineToLowerCase(String someLine) {
        return someLine.toLowerCase();
    }

    public static void main(String[] args) {

        String mainInputLine = readLineFromConsole("Enter a sentence: ");
        String newLineString = lineToLowerCase(mainInputLine);

        System.out.printf("Sentence in lowercase: %s\n", newLineString);
    }
}
