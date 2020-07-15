package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_10;

import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner scanner = new Scanner(System.in);

    private static String obtainUserInput(String inputMess) {
        boolean isValid = false;
        String userData = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userData = scanner.nextLine().trim();

                if (userData.isEmpty()) {
                    throw new IllegalArgumentException("Please provided input.");
                }
                isValid = true;
            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening_scanner] ... ");
                scanner = new Scanner(System.in);

                System.err.println("[done]");
                scanner.nextLine();                     // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
                scanner.nextLine();                     // clear input stream.
            }
        }
        return userData;
    }

    public static void main(String[] args) {

        String mainText = obtainUserInput("Enter a text message: ");
        System.out.printf("Uppercase version: %s%n", mainText.toUpperCase());
        System.out.printf("Lowercase version: %s%n", mainText.toLowerCase());

    }

}
