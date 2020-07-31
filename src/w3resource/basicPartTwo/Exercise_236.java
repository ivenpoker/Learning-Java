package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Sums all numerical values (positive integers) embedded in a sentence. #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 31, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_236 {

    private static final Scanner scanner = new Scanner(System.in);

    private static String obtainUserInput(String inputMess) {
        boolean valid = false;
        String userInput = "";

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInput = scanner.nextLine().trim();

                if (userInput.isEmpty()) {
                    throw new IllegalArgumentException("Invalid input. please enter some input");
                }
                valid = true;
            } catch (IllegalArgumentException iAe) {
                System.err.printf("[invalid_input]: %s%n", iAe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static int processSumOfDigitsInString(String mainStr) {
        int sum = 0;

        for (char ch : mainStr.toCharArray()) {
             if (Character.isDigit(ch)) {
                 sum += Integer.parseInt("" + ch);
             }
        }

        return sum;
    }

    public static void main(String[] args) {

        String userInput = obtainUserInput("Enter some text value: ");
        System.out.printf("Sum of all digits in string: %d%n", processSumOfDigitsInString(userInput));
    }

}
