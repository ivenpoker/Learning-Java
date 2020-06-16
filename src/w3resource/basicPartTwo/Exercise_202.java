package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds the total number of continuous sub-arrays in a given array of   #
// #                     integers whose sum equals to an integer.                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 16, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class Exercise_202 {

    private static Scanner input = new Scanner(System.in);
    private static final SecureRandom random = new SecureRandom();

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int MAX_SIZE = 15;

    private static int[] randomArrayData(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid size (%d) for new array", size));
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
                System.err.printf("[INPUT_ERROR]: %s%n", iMe);

            } catch (IllegalStateException iSe) {
                System.out.print("[RE-OPENING_SCANNER] ... ");
                input = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        return userKValue;
    }

    private static int listSum(ArrayList<Integer> list) {
        int sum = 0;
        for (Integer intVal : list) {
            sum += intVal;
        }
        return sum;
    }

    private static int findNumberOfContinuousSubArrays(int[] mainData, int keyVal) {
        int cnt = 0;

        for (int i = 0; i < mainData.length; i++) {

            // Temporal list to hold all numbers from 'i' onwards in
            // mainData

            ArrayList<Integer> tempList = new ArrayList<>();
            tempList.add(mainData[i]);

            for (int j = i+1; j < mainData.length; j++) {
                tempList.add(mainData[j]);
                if (listSum(tempList) == keyVal) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] newArrayData = randomArrayData(LOWER_BOUND, UPPER_BOUND, MAX_SIZE);
        System.out.printf("Generated Array: %s%n", Arrays.toString(newArrayData));

        int userKValue = obtainUserKValue("Enter the value for K: ");
        int kSumCnt = findNumberOfContinuousSubArrays(newArrayData, userKValue);

        System.out.printf("Total number of continuous sub-arrays: %d%n", kSumCnt);

    }
}
