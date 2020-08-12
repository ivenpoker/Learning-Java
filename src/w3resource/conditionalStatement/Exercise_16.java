package w3resource.conditionalStatement;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Displays the pattern like right angle triangle with a number.       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 12, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_16 {

    private static final Scanner input = new Scanner(System.in);

    private static int readNumberOfRowsFromUser(String inputMess) {
        boolean inputValid = false;
        int userInt = 0;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (userInt < 0) {
                    throw new InputMismatchException("please enter number > 0");
                }
                inputValid = true;

            } catch (InputMismatchException exc) {
                System.err.printf("[invalid_input]: %s%n", exc.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static void printTriangleForNumOfRows(int numOfRows) {

        for (int i = 1; i <= numOfRows; i++) {
            StringBuilder sb = new StringBuilder();
            IntStream.rangeClosed(1, i).forEach(sb::append);

            System.out.printf("%s%n", sb.toString());
        }
    }

    public static void main(String[] args) {

        int userNumOfRow = readNumberOfRowsFromUser("Enter number of rows: ");
        printTriangleForNumOfRows(userNumOfRow);
    }

}
