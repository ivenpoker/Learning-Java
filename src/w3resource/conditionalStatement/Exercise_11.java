package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays N terms of natural numbers and their sum.                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_11 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainNaturalNumberCountFromUser(String inputMess) {
        boolean inputValid = false;
        int userNum = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userNum = input.nextInt();
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", userNum);

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userNum;
    }

    private static int[] firstNNaturalNumbers(int nVal) {
        return IntStream.rangeClosed(1, nVal).toArray();
    }

    private static int findSumOfFirstNNaturalNumbers(int[] natNums) {
        return IntStream.of(natNums).sum();
    }

    public static void main(String[] args) {
        int userNum = obtainNaturalNumberCountFromUser("Enter number of natural to generate: ");

        int[] natNums = firstNNaturalNumbers(userNum);
        System.out.printf("Generated natural numbers: %s%n", Arrays.toString(natNums));

        int sum = findSumOfFirstNNaturalNumbers(natNums);
        System.out.printf("Sum of the first %d natural numbers: %d%n", userNum, sum);

    }

}
