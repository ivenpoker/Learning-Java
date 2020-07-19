package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Reads a text (only alphabetical characters and spaces.) and prints    #
// #                     two words. The first one is the word which is arise most frequently   #
// #                     in the text. The second one is the word which has the maximum number  #
// #                     of letters.                                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 19, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Exercise_227 {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainTextFromUser(String inputMess) {
        boolean isValid = false;
        String userInput = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.length() == 0) {
                    throw new IllegalArgumentException("Please enter some input");
                }
                isValid = true;

            } catch (IllegalArgumentException iAe) {
                System.err.println(iAe.getMessage());

            } catch (IllegalStateException iSe) {
                System.out.print("[re-opening_scanner] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();                     // clear input stream
            }
        }
        return userInput;
    }

    private static ArrayList<String> processText(String mainText) {
        if (Objects.isNull(mainText) || mainText.isEmpty()) {
            throw new IllegalArgumentException("Invalid main text. Must be a string of length > 0");
        }
        String[] words = mainText.split("\\s+");

        // Find the word with the most occurrences.
        HashMap<String, Integer> wordsFreq = new HashMap<>();
        int maxCnt = 0;

        for (String word : words) {
            if (wordsFreq.containsKey(word)) {
                int oldVal = wordsFreq.get(word);
                wordsFreq.put(word, oldVal + 1);

                if (oldVal + 1 > maxCnt) {
                    maxCnt = oldVal + 1;
                }
            } else {
                wordsFreq.put(word, 1);

            }
        }

        int finalMaxCnt = maxCnt;
        String[] maxWordFreq = {""};
        wordsFreq.forEach((key, val) -> {
            if (val == finalMaxCnt) {
                maxWordFreq[0] = key;
            }
        });

        // Find word with max number of letters
        int maxLetters = 0;
        String maxWordLettCnt = "";

        for (String word : words) {
            if (word.length() > maxLetters) {
                maxLetters = word.length();
                maxWordLettCnt = word;
            }
        }

        ArrayList<String> results = new ArrayList<>();
        results.add(maxWordFreq[0]);
        results.add(maxWordLettCnt);

        return results;
    }

    public static void main(String[] args) {

        String userText = obtainTextFromUser("Enter your text message: ");

        ArrayList<String> results = processText(userText);
        System.out.printf("Word with most occurrences: %s%n", results.get(0).isEmpty() ? "[NONE]" : results.get(0));
        System.out.printf("Word with most letters count: %s%n", results.get(1));

    }

}
