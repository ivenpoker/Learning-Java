package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds the contiguous subarray of given length k which has the maximum #
// #                     average value of a given array of integers. Displays the maximum      #
// #                     average value.                                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 16, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_203 {

    private static Scanner input = new Scanner(System.in);
    private static final SecureRandom random = new SecureRandom();

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int MAX_SIZE = 15;

    private static int[] randomIntegerArrays(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size (%d) for new array data.", size));
        }
        return Arrays.stream(new int[size]).map((val) -> low + random.nextInt(high)).toArray();
    }

    private static int obtainUserKValue(String inputMess) {
        boolean isValid = false;
        int userKValue = -1;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userKValue = input.nextInt();

                isValid = true;
            } catch (InputMismatchException iMe) {
                System.err.printf("[INVALID_INPUT]: Please enter valid input%n");
                input.nextLine();

            } catch (IllegalStateException iSe) {
                System.out.print("\n[RE-OPENING_SCANNER] ... ");
                input = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        return userKValue;
    }

    private static double findMaximumAverageValue(int[] mainData, int kValue) {
        double maxAvgValue = 0.0;

        for (int i = 0; i < mainData.length; i++) {
            if (i + kValue <  mainData.length) {
                int tempSum = 0;
                for (int j = i; j < (i + kValue); j++) {
                    tempSum += mainData[j];
                }
                double newAvg = (double) tempSum / kValue;
                maxAvgValue = Math.max(maxAvgValue, newAvg);
            }
        }
        return maxAvgValue;
    }

    public static void main(String[] args) {
        int[] newArrayData = randomIntegerArrays(LOWER_BOUND, UPPER_BOUND, MAX_SIZE);
        System.out.printf("Generated Array: %s%n", Arrays.toString(newArrayData));

        int userKValue = obtainUserKValue("Enter value of K: ");
        double maxAvgValue = findMaximumAverageValue(newArrayData, userKValue);

        System.out.printf("Maximum average value: %f%n", maxAvgValue);
    }
}
