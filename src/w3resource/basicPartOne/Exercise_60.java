package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Finds the penultimate word form a sentence provided by user.       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_60 {

    private static Scanner input = new Scanner(System.in);

    private static String[] readInputLine(String message) {
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

        return mainLine.split(" ");
    }

    private static String[] processInputString(String[] data) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            String temp = data[i].trim();
            if (temp.length() != 0)
                builder.append(temp).append(" ");
        }
        return builder.toString().trim().split(" ");
    }

    private static String findPenultimate(String[] someData) {
        if (someData.length < 2)
            return null;
        return someData[someData.length-2];
    }

    public static void main(String[] args) {

        String[] inputLineTokens = readInputLine("Enter a sentence: ");
        String[] newInputLineTokens = processInputString(inputLineTokens);

        String penultimateData = findPenultimate(newInputLineTokens);

        System.out.printf("Penultimate word: %s\n", penultimateData);
    }
}
