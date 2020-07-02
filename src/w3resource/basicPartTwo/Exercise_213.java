package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Determines if given sides of a triangle forms right-angled triangle.  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 02, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_213 {

    private static Scanner scanner = new Scanner(System.in);

    private static boolean formsRightAngleTriangle(int sideA, int sideB, int sideC) {
        int maxSide = Math.max(sideA, Math.max(sideB, sideC));
        if (maxSide == sideA) {
            return Math.sqrt(Math.pow(sideB, 2) + Math.pow(sideC, 2)) == sideA;
        } else if (maxSide == sideB) {
            return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideC, 2)) == sideB;
        } else {
            return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2)) == sideC;
        }
    }

    private static int obtainUserInput(String inputMess) {
        boolean isValid = false;
        int sideVal = 0;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                sideVal = scanner.nextInt();

                if (sideVal < 0) {
                    throw new IllegalArgumentException("Length must be > 0");
                }
                isValid = true;

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-OPENING__SCANNER] ... ");
                scanner = new Scanner(System.in);

            } catch (IllegalArgumentException | InputMismatchException iAEe) {
                System.err.printf("[INPUT_ERROR]: %s%n", iAEe.getMessage());
                scanner.nextLine();     // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[CORE_EXCEPTION]: %s%n", exc.getMessage());
                scanner.nextLine();     // clear input stream.
            }
        }
        return sideVal;
    }

    public static void main(String[] args) {

        int sideA = obtainUserInput("Enter sideA's length: ");
        int sideB = obtainUserInput("Enter sideB's length: ");
        int sideC = obtainUserInput("Enter sideC's length: ");

        System.out.printf("Does sides form right angle triangle: %s%n",
                formsRightAngleTriangle(sideA, sideB, sideC) ? "YES" : "NO");

    }
}
