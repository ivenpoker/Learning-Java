package w3resource.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static void printLine(char ch, int maxLineLength) {
        for (int i = 0; i < maxLineLength; i++) {
            System.out.printf("%c", ch);
        }
        System.out.println();
    }

    public static void printLineMessage(String mess, char ch, int maxLineLength) {
        if (mess.length() > maxLineLength) {
            throw new IllegalArgumentException(
                    String.format("Message length (%d) must be greater than" +
                            " specified char line length (%d)", mess.length(), maxLineLength));
        }
        if (mess.length() == maxLineLength) {
            System.out.println(mess);
        }
        int maxSideChars = (maxLineLength - mess.length()) / 2;
        for (int i = 0; i < maxSideChars; i++) {
            System.out.printf("%c", ch);
        }
        System.out.printf("%s", mess);
        for (int i = 0; i < maxSideChars; i++) {
            System.out.printf("%c", ch);
        }
        System.out.println();
    }

    public static void printLineInfo(String mess, char ch, int maxLineLength) {
        System.out.println();
        BasicUtils.printLineMessage(mess, ch, maxLineLength);
        System.out.println();
    }

    public static String readUserInputString(String inputMess, boolean handleErrors) {
        boolean isInputValid = false;
        String userInput = "";

        if (!handleErrors) {
            System.out.print(inputMess);
            return scanner.nextLine().trim();

        } else {
            while (!isInputValid) {
                try {
                    System.out.print(inputMess);
                    userInput = scanner.nextLine().trim();

                    if (userInput.isEmpty()) {
                        throw new InputMismatchException("Missing input");
                    }
                    isInputValid = true;
                } catch (InputMismatchException iMe) {
                    System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

                } catch (Exception exc) {
                    System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getCause().getMessage());
                }
            }
        }

        return userInput;
    }

}
