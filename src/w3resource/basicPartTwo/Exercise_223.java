package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds the maximum sum of a contiguous subsequence from a given        #
// #                     sequence of numbers a1, a2, a3, ...an. A subsequence of one element   #
// #                     is also a continuous subsequence.                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 10, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_223 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserNumberOfInputsToEnter(String inputMess) {
        int userData = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userData = scanner.nextInt();
                valid = true;

            } catch (InputMismatchException iMe) {
                System.err.println("[invalid_input]");
                scanner.nextLine();     // clear input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
                scanner.nextLine();     // clear input stream.
            }
        }
        return userData;
    }

    private static int[] obtainAllUserSpecifiedNumbers(String inputMess, int maxIntRead) {
        if (maxIntRead <= 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified max read (%d). Must be > 0.", maxIntRead));
        }
        int[] intsRead = new int[maxIntRead];
        int read = 0;

        System.out.print(inputMess);
        while (read < intsRead.length) {
            try {
                intsRead[read] = scanner.nextInt();
                read += 1;

            } catch (InputMismatchException iMe) {
                System.err.println("[invalid_input]");
                scanner.nextLine();     // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[exception]: %s%n", exc.getMessage());
                scanner.nextLine();     // clear input stream.
            }
        }
        return intsRead;
    }

    private static int findMaximumSumOfContiguousSubsequence(int[] mainData) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < mainData.length; i++) {
            if (maxSum == Integer.MIN_VALUE) {
                maxSum = mainData[0];
            }
            int tmpSum = mainData[i];
            for (int j = i+1; j < mainData.length; j++) {
                if (mainData[i] <= mainData[j]) {
                    tmpSum += mainData[j];
                } else {
                    break;
                }
            }
            if (tmpSum > maxSum) {
                maxSum = tmpSum;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {

        // Obtain number of integers user is willing to enter.
        int userIntsSize = obtainUserNumberOfInputsToEnter("How many integers would you like to input ?: ");

        // Read all integers the user specified.
        int[] userInts = obtainAllUserSpecifiedNumbers("Input the integers: ", userIntsSize);

        int maxSum = findMaximumSumOfContiguousSubsequence(userInts);

        System.out.printf("Maximum sum of said contiguous subsequence: %d%n", maxSum);
    }
}
