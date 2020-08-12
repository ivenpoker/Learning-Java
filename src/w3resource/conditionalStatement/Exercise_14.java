package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays the multiplication table from a given number.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_14 {

    private static final Scanner input = new Scanner(System.in);

    private static int readUserNumberOfTerms(String inputMess) {
        boolean validInput = false;
        int userInput = 0;

        while (!validInput) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();

                if (userInput < 0) {
                    throw new InputMismatchException("please input must be positive");
                }
                validInput = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static void processAndDisplay(int mainNum) {
        IntStream.rangeClosed(0, mainNum).forEach((num) ->
                System.out.printf("%d X %d = %d%n", mainNum, num, (mainNum * num)));
    }

    public static void main(String[] args) {
        int userNum = readUserNumberOfTerms("Enter number of terms: ");
        processAndDisplay(userNum);
    }

}
