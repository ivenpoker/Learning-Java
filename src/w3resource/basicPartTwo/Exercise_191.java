package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Tests whether there are two integers x and y such that x^2 + y^2 is  #
// #                     equal to a given positive number.                                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : March 21, 2020                                                       #
// #                                                                                          #
// ############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_191 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserIntegerInput(String inputMessage) {
        int userInput = -1;
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMessage);
                userInput = scanner.nextInt();
                cont = false;

            } catch (InputMismatchException inputExc) {
                System.err.print("[ERROR]: Invalid input");

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s\n", exc.getMessage());
            }
        }
        return userInput;
    }

    private static boolean sumOfSquareNumbers(int n) {
        int leftNum = 0;
        int rightNum = (int) Math.sqrt(n);
        while (leftNum <= rightNum) {
            if (Math.pow(leftNum, 2) + Math.pow(rightNum, 2) == n) {
                return true;
            } else if (Math.pow(leftNum, 2) + Math.pow(rightNum, 2) < n) {
                leftNum++;
            } else {
                rightNum--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int userInput = obtainUserIntegerInput("Enter a positive integer: ");
        if (userInput > 0) {
            System.out.printf("Is '%d' sum of two square numbers ?: %b\n", userInput,
                    sumOfSquareNumbers(userInput));
        }
    }
}
