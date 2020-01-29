package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Reads a user defined positive number and repeatedly adds all its     #
// #                     digits until the result has only one digit.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : January 29, 2020                                                     #
// #                                                                                          #
// ############################################################################################

import java.util.Scanner;

public class Exercise_183 {

    private static Scanner scanner = new Scanner(System.in);

    private static int readUserIntValue(String inputMess) {
        int userVal = 0;
        boolean cont = true;

        while (cont) {
            try {
                System.out.print(inputMess);
                userVal = scanner.nextInt();
                if (userVal < 0) {
                    throw new IllegalArgumentException("Only positive number required");
                }
                cont = false;

            } catch (IllegalStateException illegalStateExc) {

                System.out.print("[ERROR]: RE-BOOTING SCANNER ... ");
                scanner = new Scanner(System.in) ;
                System.out.println("[DONE]");

            } catch (IllegalArgumentException argumentExc) {

                System.out.printf("[ARG_ERROR]: %s\n", argumentExc.getMessage());

            } catch (Exception exc) {
                System.err.printf("[ERROR]: %s\n", exc.getMessage());
            }
        }
        return userVal;
    }

    private static boolean inRange(int low, int key, int high) {
        return low <= key && key <= high;
    }

    private static int doAdditions(int mainInt) {
        if (inRange(0, mainInt, 9)) {
            return mainInt;
        }
        int sum = 0;
        while (mainInt > 0) {
            sum += mainInt % 10;
            mainInt /= 10;
        }
        return sum % 10 == 0 ? sum : doAdditions(sum);
    }

    public static void main(String[] args) {
        int mainData = readUserIntValue("Enter a positive integer: ");
        System.out.printf("Sum is: %d\n", doAdditions(mainData));
    }
}
