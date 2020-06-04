package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Checks if three given side lengths (integers) can make a triangle or  #
// #                     not.                                                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 4, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_195 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String mess) {
        boolean isValid = false;
        int userNum = 0;
        while (!isValid) {
            try {
                System.out.print(mess);
                userNum = input.nextInt();
                isValid = true;

            } catch (InputMismatchException exc) {
                System.out.printf("[INPUT_ERROR]: %s%n", exc.getMessage());
            }
        }
        return userNum;
    }

    private static boolean isTriangle(int sideA, int sideB, int sideC) {
        if (!(sideA < (sideB + sideC) && (sideA > Math.abs(sideB - sideC)))) {
            return false;
        } else if (!(sideB < (sideA + sideC) && (sideB > Math.abs(sideA - sideC)))) {
            return false;
        } else if (!(sideC < (sideA + sideB) && (sideC > Math.abs(sideA - sideB)))) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int sideA = obtainUserInput("Enter side A: ");
        int sideB = obtainUserInput("Enter side B: ");
        int sideC = obtainUserInput("Enter side C: ");

        System.out.printf("Is the said sides form a triangle: %s%n",
                isTriangle(sideA, sideB, sideC) ? "YES" : "NO");
    }
}
