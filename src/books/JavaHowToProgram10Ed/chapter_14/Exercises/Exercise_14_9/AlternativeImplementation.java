package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_9;

import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserInputString(String inputMess) {
        boolean isValid = false;
        String userData = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userData = scanner.nextLine().trim();

                if (userData.isEmpty()) {
                    throw new IllegalArgumentException("Please enter a message");
                }
                isValid = true;

            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening_scanner] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();                     // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
                scanner.nextLine();                     // clear input stream.
            }
        }
        return userData;
    }

    private static String getReversedMessage(String mainMessage) {
        String[] msgTokens = mainMessage.split(" ");
        StringBuilder sbTokens = new StringBuilder();

        for (int len = msgTokens.length, i = len-1; i >= 0; i--) {
            sbTokens.append(msgTokens[i]).append(" ");
        }
        return sbTokens.toString().trim();
    }

    public static void main(String[] args) {

        String userData = obtainUserInputString("Enter a message: ");
        String reversedMsg = getReversedMessage(userData);

        System.out.printf("Reversed message: %s%n", reversedMsg);

    }
}
