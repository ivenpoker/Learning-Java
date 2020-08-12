package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays the first N natural numbers.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_10 {

    private static final Scanner input = new Scanner(System.in);

    private static int[] firstNNaturalNumbers(int numOfNatural) {
        return IntStream.rangeClosed(1, numOfNatural).toArray();
    }

    private static int obtainUserSpecifiedNatural(String inputMess) {
        boolean inputValid = false;
        int numOfNaturalNum = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                numOfNaturalNum = input.nextInt();

                if (numOfNaturalNum < 0) {
                    throw new InputMismatchException("please number must be > 0");
                }
                inputValid = true;
            } catch (InputMismatchException exc) {
                System.err.printf("[invalid_input]: %s%n", exc.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return numOfNaturalNum;
    }

    public static void main(String[] args) {

        int userNum = obtainUserSpecifiedNatural("Enter number of natural numbers to generate: ");
        int[] naturalNums = firstNNaturalNumbers(userNum);

        System.out.printf("Generated natural numbers: %s%n", Arrays.toString(naturalNums));

    }

}
