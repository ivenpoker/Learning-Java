package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_20;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_14_20 {

    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_NUMBER_OF_INPUT_DIGITS = 9;

    private static double obtainUserInputString(String inputMess) {
        boolean valid = false;
        double userInputDouble = 0.0;
       // String mainAmount = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                String userInputDoubleStr = scanner.next().trim();

                if (userInputDoubleStr.isEmpty()) {
                    throw new IllegalArgumentException("please enter an amount");
                }
                userInputDouble = Double.parseDouble(userInputDoubleStr);

                if (userInputDoubleStr.length() > MAX_NUMBER_OF_INPUT_DIGITS) {
                    throw new IllegalArgumentException(
                            String.format("Maximum number of digits must be %d", MAX_NUMBER_OF_INPUT_DIGITS));
                }
               // mainAmount = NumberFormat.getCurrencyInstance().format(userInputDouble);

                valid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextLine();                 // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInputDouble;
    }

    private static String processInput(String mainAMount) {

        // if string's length is less than the application's
        // maximum number of supported digits, we fill up
        // the lacking digits, with asterisks

        if (mainAMount.length() < MAX_NUMBER_OF_INPUT_DIGITS) {
            StringBuilder tmpSb = new StringBuilder();
            int amountLen = mainAMount.length();

            for (int i = 0; i < MAX_NUMBER_OF_INPUT_DIGITS - amountLen; i++) {
                tmpSb.append("*");
            }
            return tmpSb.append(mainAMount).toString();
        } else {
            return mainAMount;
        }
    }

    private static void printLine(char ch, int maxTimes) {

        // prints a line using specified characters 'ch' a
        // number of times 'maxTimes'
        for (int i = 0; i < maxTimes; i++) {
            System.out.printf("%c", ch);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Obtain user input
        double mainAmount = obtainUserInputString("Enter an amount (max digits is 9): ");
        System.out.printf("Entered amount: %.2f%n", mainAmount);

        // Process input and attach asterix if necessary.
        String processedAmount = processInput(String.format("%.2f", mainAmount));

        // Display the results as shown.
        System.out.printf("%s%n", processedAmount);
        printLine('-', MAX_NUMBER_OF_INPUT_DIGITS);

        for (int i = 1; i <= MAX_NUMBER_OF_INPUT_DIGITS; i++) {
            System.out.printf("%d", i);
        }
        System.out.println();
    }

}
