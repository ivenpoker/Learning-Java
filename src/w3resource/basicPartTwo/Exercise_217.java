package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds the number of prime numbers which are less than or equal to a   #
// #                     a given integer.                                                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 03, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_217 {

    private static Scanner scanner = new Scanner(System.in);

    private static int readUserMaxNumber(String inputMess) {
        boolean isValid = false;
        int userMaxNum = 0;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userMaxNum = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException iMe) {
                System.err.println("[INVALID__INPUT]: Input must be an integer");
                scanner.nextLine();         // clear input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-OPENING__SCANNER] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();         // clear input stream.
            }
        }
        return userMaxNum;
    }

    private static int numOfFactors(int someNum) {
        if (someNum <= 1) {
            throw new IllegalArgumentException(String.format("Invalid number %d. Must be > 1", someNum));
        }
        int cnt = 2;    // All number has 2 factors ... 1 and itself.
        for (int i = 2; i <= someNum/2; i++) {
            if (someNum % i == 0) {
                cnt += 1;
            }
        }
        return cnt;
    }

    private static boolean isPrime(int someNum) {
        return numOfFactors(someNum) == 2;
    }

    private static int findAllPrimesLessThanNum(int maxNum) {
        int cnt = 0;
        for (int i = 2; i < maxNum; i++) {
            if (isPrime(i)) {
                cnt += 1;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {

        int userNum = readUserMaxNumber("Enter the max number: ");
        System.out.printf("Number of prime numbers which are less than or equal to %d: %d%n",
                userNum, findAllPrimesLessThanNum(userNum));

    }
}
