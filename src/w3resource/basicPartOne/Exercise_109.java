package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Forms a staircase shape of n coins where every k-th row must have exactly       #
// #                     k coins.                                                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_109 {

    private static Scanner scanner = new Scanner(System.in);

    private static int getIntegerFromUser(String mess) {
        boolean isValid = false;
        int userVal = 0;
        while (!isValid) {
            try {
                System.out.print(mess);
                userVal = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException inputMismatchException) {
                System.err.printf("[ERROR]: %s\n", inputMismatchException.getMessage());

            } catch (IllegalStateException illegalStateException) {
                System.err.print("[WARNING]: Scanner closed unexpectedly. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }
        }
        return userVal;
    }

    private static void displayRows(int numCoins) {
        int temp = numCoins;
        for (int i = 1; temp >= 0; i++) {
            for (int j = 0; j < i; j++, temp--) {
                if (temp > 0) {
                    System.out.print("$ ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int userVal = getIntegerFromUser("Enter some value for n: ");
        displayRows(userVal);
    }
}
