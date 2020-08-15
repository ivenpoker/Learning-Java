package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Makes a pattern like right angle triangle with number increased by  #
// #                     1.                                                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 15, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_18 {

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
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static void printPatternLikeRightAngleTriangle(int numOfRows) {
        for (int i = 1, num = 1; i <= numOfRows; i++) {
            for (int j = 0; j < i; j++) {
                System.out.printf("%d ", num++);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        int userNumOfRows = readUserInputNumOfRows("Enter number of rows: ");
        printPatternLikeRightAngleTriangle(userNumOfRows);

    }

}


