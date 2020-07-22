package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_15;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AlternativeImplementation {

    private static Scanner scanner = new Scanner(System.in);
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 255;

    private static int obtainIntegerCodeFromUser(String inputMess) {
        boolean isValid = false;
        int charCode = 0;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                charCode = scanner.nextInt();

                if (charCode < 0) {
                    throw new InputMismatchException("Character code must be >= 0");
                }
                isValid = true;

            } catch (InputMismatchException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());
                scanner.nextLine();                 // clear input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

                scanner.nextLine();                 // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
                scanner.nextLine();                 // clear input stream.
            }
        }
        return charCode;
    }

    private static void printAllCharacterInCharCodeRange(int lower, int upper) {
        for (int i = lower; i < upper; i++) {
            System.out.printf("Character equivalent for '%d': %c%n", i, (char) i);
        }
    }

    public static void main(String[] args) {

        int userCharCode = obtainIntegerCodeFromUser("Enter integer character code for target character: ");
        System.out.printf("Character equivalent for '%d': %c%n", userCharCode, (char) userCharCode);

        System.out.println();

        printAllCharacterInCharCodeRange(LOWER_BOUND, UPPER_BOUND);
    }

}
