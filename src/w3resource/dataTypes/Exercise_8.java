package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Reads a number and display the square, cube, and fourth power.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_8 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserNumber(String inputMess) {
        boolean validInput = false;
        int userNum = 0;

        while (!validInput) {
            try {
                System.out.print(inputMess);
                userNum = input.nextInt();
                validInput = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                input.nextLine();           // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userNum;
    }

    private static void printResults(int mainNum) {
        System.out.printf("Square of '%d': %.2f%n", mainNum, Math.pow(mainNum, 2));
        System.out.printf("Cube of '%d': %.2f%n", mainNum, Math.pow(mainNum, 3));
        System.out.printf("Fourth power of '%d': %.2f%n", mainNum, Math.pow(mainNum, 4));
    }

    public static void main(String[] args) {

        int mainUserNum = obtainUserNumber("Enter main number: ");
        printResults(mainUserNum);

    }

}
