package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Reads five (5) integers from the user. Computes their sum and       #
// #                     average.                                                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_12 {

    private static Scanner input = new Scanner(System.in);
    private static int MAX_NUMBER_OF_READS = 5;

    private static int obtainUserInput(String inputMess) {
        boolean validInput = false;
        int userInput = 0;

        while (!validInput) {
            try {
                System.out.print(inputMess);
                userInput = input.nextInt();
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

    private static int[] readAllNUserInput(int maxRead) {
        int[] userData = new int[maxRead];
        for (int i = 0; i < maxRead; i++) {
            userData[i] = obtainUserInput(String.format("Enter number #%d: ", i));
        }
        return userData;
    }

    private static int findSumOfIntegers(int[] data) {
        return IntStream.of(data).sum();
    }

    private static double findAverageOfIntegers(int[] data) {
        return IntStream.of(data).average().orElse(0.0d);
    }

    public static void main(String[] args) {

        int[] allDataRead = readAllNUserInput(MAX_NUMBER_OF_READS);
        System.out.printf("Obtained data: %s%n", Arrays.toString(allDataRead));

        System.out.printf("Sum of all integers: %d%n", findSumOfIntegers(allDataRead));
        System.out.printf("Average of all integers: %.2f%n", findAverageOfIntegers(allDataRead));

    }
}
