package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise_14_14 {

    private static Scanner scanner = new Scanner(System.in);
    private static final String endStr = "ED";

    private static String readUserString(String inputMess) {
        boolean valid = false;
        String userText = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userText = scanner.nextLine().trim();

                if (userText.isEmpty()) {
                    throw new IllegalArgumentException("please enter some input.");
                }
                valid = true;

            } catch (IllegalStateException iSe) {
                System.out.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

                // clear input stream
                scanner.nextLine();

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
                scanner.nextLine();                 // clear input stream.
            }
        }
        return userText;
    }

    private static ArrayList<String> processString(String mainStr, String targetEndStr) {
        ArrayList<String> matchedWords = new ArrayList<>();
        String[] words = mainStr.split("\\s+");

        for (String word : words) {
            if (word.endsWith(targetEndStr)) {
                matchedWords.add(word);
            }
        }
        return matchedWords;
    }

    private static void displayFoundStrings(String message, ArrayList<String> wordsList) {
        System.out.print(message);

        if (wordsList.isEmpty()) {
            System.out.println("[NONE]");
        } else {
            System.out.printf("%s%n", Arrays.toString(wordsList.toArray(new String[0])));
        }
    }

    public static void main(String[] args) {

        String userMainText = readUserString("Enter some text: ");
        ArrayList<String> matchedWords = processString(userMainText, endStr);

        // display found strings
        displayFoundStrings(String.format("Found words ending with '%s': ", endStr), matchedWords);

    }

}
