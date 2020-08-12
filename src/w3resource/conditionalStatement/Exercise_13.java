package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays the cube of the number up to a given integer.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_13 {

    private static final Scanner input = new Scanner(System.in);

    private static int readUserInput(String inputMess) {
        boolean validInput = false;
        int userInput = 0;

        while (!validInput) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (userInput < 0) {
                    throw new InputMismatchException("please enter positive integer");
                }

                validInput = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static void processAndDisplayData(int maxVal) {
        IntStream.rangeClosed(1, maxVal).forEach((val) ->
                System.out.printf("Number is : %d and cube of %d is : %d%n", val, val, (int) Math.pow(val, 3) ));
    }

    public static void main(String[] args) {
        int mainInput = readUserInput("Enter number of terms: ");
        processAndDisplayData(mainInput);
    }

}
