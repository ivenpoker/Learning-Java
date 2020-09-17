package w3resource.utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils {

    private static final Scanner scanner = new Scanner(System.in);

    public static int obtainUserIntegerInput(String inputMess) {
        boolean inputValid = false;
        int userInput = -1;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();             // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[INPUT_EXCEPTION]: %s%n", exc.getCause().getMessage());
            }
        }
        return userInput;
    }
}
