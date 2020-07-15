package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner scanner = new Scanner(System.in);

    private static String obtainUserInputString(String inputMess) {
        boolean isValid = false;
        String userData = "";

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userData = scanner.nextLine().trim();

                if (userData.isEmpty()) {
                    throw new IllegalArgumentException("Please provide an input");
                }
                isValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();             // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
                scanner.nextLine();
            }
        }
        return userData;
    }

    private static int obtainUserInputInt(String inputMess) {
        boolean isValid = false;
        int userInt = 0;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userInt = scanner.nextInt();

                if (userInt < 0) {
                    throw new IllegalArgumentException("Please enter positive number");
                }
                isValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();             // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
                scanner.nextLine();
            }
        }
        return userInt;
    }


    public static void main(String[] args) {

        String firstStr = obtainUserInputString("Enter first string for comparison: ");
        String secondStr = obtainUserInputString("Enter second string for comparison: ");

        int numOfCharsToCompare = obtainUserInputInt("Enter number of characters to compare: ");
        int startingIdx = obtainUserInputInt("Enter starting index: ");

        String firstStrExtract = firstStr.substring(startingIdx, startingIdx + numOfCharsToCompare);
        String secondStrExtract = secondStr.substring(startingIdx, startingIdx + numOfCharsToCompare);

        if (firstStrExtract.equalsIgnoreCase(secondStrExtract)) {
            System.out.printf("%nStrings are equal on specified locations");
        } else {
            System.out.printf("%nStrings are NOT equal on specified locations");
        }

    }
}
