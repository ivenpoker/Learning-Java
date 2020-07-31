package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Cuts words of 3 to 6 characters length from a given sentence not more #
// #                     than 1024 characters long.                                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 31, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Exercise_240 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_NUMBER_OF_CHARS = 1024;
    private static final int LOWER_BOUND_FOR_REMOVAL = 3;
    private static final int UPPER_BOUND_FOR_REMOVAL = 6;

    private static boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }

    private static String readUserInput(String inputMess) {
        boolean valid = false;
        String userInput = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.isEmpty() || !inRange(0, userInput.length(), MAX_NUMBER_OF_CHARS)) {
                    throw new IllegalArgumentException(
                            String.format("input needed. Length must of max %d characters.",
                                    MAX_NUMBER_OF_CHARS));
                }
                valid = true;
            } catch (IllegalArgumentException | NoSuchElementException iAeNsEe) {
                System.err.printf("[invalid input]: %s%n", iAeNsEe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static String processString(String mainStr) {
        if (Objects.isNull(mainStr) || mainStr.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String[] words = mainStr.split("\\s+");

        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];

            // if word length is not in the removal range with keep track of it, else
            // we just ignore the word ... as it is 'invalid'.

            if (!inRange(LOWER_BOUND_FOR_REMOVAL, currWord.length(), UPPER_BOUND_FOR_REMOVAL)) {
                if (i > 0 && i != words.length-1) {
                    sb.append(currWord).append(" ");
                } else {
                    sb.append(currWord);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String mainUserStr = readUserInput("Enter some input text: ");
        String processedText = processString(mainUserStr);

        System.out.printf("Processed input: %s%n", processedText);

    }

}
