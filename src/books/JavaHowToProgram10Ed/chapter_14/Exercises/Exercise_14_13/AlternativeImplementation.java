package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserInput(String inputMess) {
        boolean isValid = false;
        String userStrData = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userStrData = scanner.nextLine().trim();

                if (userStrData.isEmpty()) {
                    throw new IllegalArgumentException("please enter some input string");
                }
                isValid = true;

            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());
                scanner.nextLine();                     // clear input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();                     // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
                scanner.nextLine();                     // clear input stream.
            }
        }
        return userStrData;
    }

    private static  ArrayList<String> processString(String mainData, String endStr) {
        if (mainData.isEmpty()) {
            throw new IllegalArgumentException("Main string is needed");
        }
        String[] words = mainData.split("\\s+");
        ArrayList<String> endList = new ArrayList<>();

        for (String word : words) {
            if (word.endsWith(endStr)) {
                endList.add(word);
            }
        }

        return endList;
    }

    public static void main(String[] args) {

        String userText = obtainUserInput("Enter some line of text: ");
        String endText = obtainUserInput("Enter 'end' text to search for: ");

        ArrayList<String> endTextWords = processString(userText, endText);
        System.out.printf("Words ending with '%s': %s%n", endText,
                Arrays.toString(endTextWords.toArray(new String[0])));

    }
}
