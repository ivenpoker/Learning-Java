package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Checks whether an given integer is a power of another or not.                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : September 25, 2019                                                              #
// #                                                                                                     #
// #######################################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_110 {

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

    public static void main(String[] args) {
        int intA = getIntegerFromUser("Enter integer A: ");
        int intB = getIntegerFromUser("Enter integer B to check if A is one of it's power: ");
        System.out.printf("Is %d a power of %d: %s\n", intA, intB, Math.sqrt(intA) == intB ? "YES" : "NO");
    }
}
