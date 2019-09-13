package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Capitalize the first letter of each word in a sentence.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 13, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercise_58 {

    private static Scanner input = new Scanner(System.in);

    private static String[] readAndTokenizeInputLine(String message) {
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

    private static String[] processInputTokenData(String[] data) {
        for (int i = 0; i < data.length; i++) {
            String temp = data[i];
            data[i] = (temp.charAt(0) + "").toUpperCase() + temp.substring(1);
        }
        return data;
    }

    private static String joinStringData(String[] data) {
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            if (i == data.length-1) {
                temp.append(data[i]);
            } else {
                temp.append(data[i]).append(" ");
            }
        }
        return temp.toString();
    }

    public static void main(String[] args) {

        String[] inputTokenData = readAndTokenizeInputLine("Enter a sentence: ");
        String[] processedInputTokenData = processInputTokenData(inputTokenData);
        System.out.printf("Processed sentence: %s\n", joinStringData(processedInputTokenData));
    }
}
