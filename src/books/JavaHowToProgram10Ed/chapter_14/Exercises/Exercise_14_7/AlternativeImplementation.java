package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_7;

import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserStringInput(String inputMess) {
        boolean isValid = false;
        String userData = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userData = scanner.nextLine().trim();

                if (userData.isEmpty()) {
                    throw new IllegalArgumentException("Please enter some string input");
                }
                isValid = true;

            } catch (IllegalStateException iSe) {
                System.err.print("[re-booting_scanner] ... ");
                scanner = new Scanner(System.in);
                System.err.println("[done]");

                scanner.nextLine();         // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
            }
        }
        return userData;
    }

    private static String[] processStringInputData(String[] mainInputData) {
        String[] processedPigLatinWords = new String[mainInputData.length];

        for (int i = 0; i < mainInputData.length; i++) {
            String token = mainInputData[i];
            processedPigLatinWords[i] = token.substring(1) + token.charAt(0) + "ay";
        }
        return processedPigLatinWords;
    }

    private static void printLatinWord(String[] latinWords) {
        StringBuilder sb = new StringBuilder();
        for (String latinWord : latinWords) {
            sb.append(latinWord).append(" ");
        }
        System.out.printf("Latin sentence equivalent: %s%n", sb.toString().trim());
    }

    public static void main(String[] args) {

        String[] mainUserInputTokens = obtainUserStringInput("Enter a string message: ").split(" ");

        // Process words in string into pig latin.
        String[] processedLatinWords = processStringInputData(mainUserInputTokens);

        // Display all user pig latin words
        printLatinWord(processedLatinWords);
    }
}
