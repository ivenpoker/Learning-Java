package w3resource.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicUtils {

    private static final Scanner scanner = new Scanner(System.in);

    private static boolean inRange(int lower, int val, int upper) {
        return lower <= val && val <= upper;
    }

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
                    userInput = scanner.nextLine();

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

    public static char readUserChar(String inputMess) {
        boolean isInputValid = false;
        char userChar = ' ';

        while (!isInputValid) {
            try {
                System.out.print(inputMess);
                userChar = scanner.next().trim().charAt(0);

                isInputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userChar;
    }

    public static int getUserIntInput(String inputMess) {
        boolean isInputValid = false;
        int userInt = Integer.MIN_VALUE;

        while (!isInputValid) {
            try {
                System.out.print(inputMess);
                userInt = scanner.nextInt();

                isInputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    public static int getUserIntInputBounds(String inputMess, int lowerBound, int upperBound) {
        boolean isInputValid = false;
        int userInt = Integer.MIN_VALUE;

        while (!isInputValid) {
            try {
                System.out.print(inputMess);
                userInt = scanner.nextInt();

                if (!inRange(lowerBound, userInt, upperBound)) {
                    throw new InputMismatchException(
                            String.format("Integer value must be bounds [%d, %d]",
                                    lowerBound, upperBound));
                }
                isInputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

}
