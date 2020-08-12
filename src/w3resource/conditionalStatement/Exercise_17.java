package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Create a patten like a pyramid with a number which will repeat the  #
// #                     number in a row.                                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_17 {

    private static final Scanner input = new Scanner(System.in);

    private static int readUserInputNumOfRows(String inputMess) {
        boolean inputValid = false;
        int userInt = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (userInt < 0) {
                    throw new InputMismatchException("please enter a positive value");
                }
                inputValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static void printTriangleLikePattern(int maxRow) {
        for (int i = 1; i <= maxRow; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < i; j++) {
                sb.append(i);
            }
            System.out.printf("%s%n", sb.toString());
        }
    }

    public static void main(String[] args) {
        int userInt = readUserInputNumOfRows("Enter number of rows to generate: ");
        printTriangleLikePattern(userInt);
    }
}
