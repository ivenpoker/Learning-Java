package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AlternativeImplementation {

    private static final Scanner scanner = new Scanner(System.in);

    private static String obtainUserInput(String inputMess) {
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
                scanner.nextLine();         // clear input stream

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
                scanner.nextLine();         // clear input stream
            }
        }
        return userData;
    }

    public static void main(String[] args) {
        String firstInput = obtainUserInput("Enter first string value: ");
        String secondInput = obtainUserInput("Enter second string value: ");

        int compResults = firstInput.compareTo(secondInput);
        if (compResults == 0) {
            System.out.printf("Both strings are equal%n");
        } else if (compResults < 0) {
            System.out.printf("First input string is less than the second input string%n");
        } else {
            System.out.printf("First input string is greater than the second input string%n");
        }
    }

}
