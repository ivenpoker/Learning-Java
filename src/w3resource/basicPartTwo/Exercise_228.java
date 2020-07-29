package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds possible sum from a target in a combination.                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 19, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_228 {

    private static Scanner scanner = new Scanner(System.in);
    private static final SecureRandom random = new SecureRandom();

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 9;

    private static int[] randomIntsInRange(int lower, int upper, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("Invalid specified size (%d). Must be > 0", size));
        }
        if (lower > upper) {
            throw new IllegalArgumentException("Lower bound must be > upper bound");
        }
        return Arrays.stream(new int[size]).map((i) -> lower + random.nextInt(upper)).toArray();
    }

    private static int readUserInput(String inputMess) {
        boolean isValid = false;
        int userInt = 0;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userInt = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException iMe) {
                System.err.println("[invalid_input]: enter only integer");
                scanner.nextLine();                     // clear input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening_scanner] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[done]");
                scanner.nextLine();                     // clear input stream.
            }
        }
        return userInt;
    }

    private static ArrayList<String> findAllSumCombination(int sumTarget, int[] mainData) {
        ArrayList<String> allSumsStr = new ArrayList<>();

        for (int i = 0; i < mainData.length; i++) {
            int tmpCurrSum = mainData[i];
            ArrayList<Integer> digitSums = new ArrayList<>();
            digitSums.add(tmpCurrSum);
            boolean foundASum  = false;

            for (int j = i + 1; j < mainData.length; j++) {
                tmpCurrSum += mainData[j];
                if (tmpCurrSum == sumTarget && !digitSums.contains(mainData[j])) {
                    digitSums.add(mainData[j]);
                    foundASum = true;
                    break;
                } else if (tmpCurrSum > sumTarget) {
                    break;
                }
            }
            if (foundASum) {

                // Sort digits in list in ascending order.
                Collections.sort(digitSums);
                StringBuilder sb = new StringBuilder();

                for (int k = 0, size = digitSums.size(); k < size; k++) {
                    if (!(k == 0 || k == size-1)) {
                        sb.append(digitSums.get(k)).append(" + ");
                    } else {
                        sb.append(digitSums.get(k));
                    }
                }

                // Keep track of this sum
                allSumsStr.add(sb.toString());
            }
        }
        return  allSumsStr;
    }

    public static void main(String[] args) {

        int[] randIntsInRange = randomIntsInRange(LOWER_BOUND, UPPER_BOUND, 20);

        System.out.printf("Generated data: %s%n", Arrays.toString(randIntsInRange));
        int sumTarget = readUserInput("Enter number to sum to: ");

        ArrayList<String> allSumsAsSumStrings = findAllSumCombination(sumTarget, randIntsInRange);
        if (!allSumsAsSumStrings.isEmpty()) {
            for (String sumStr : allSumsAsSumStrings) {
                System.out.printf("%s = %d", sumStr, sumTarget);
            }
        } else {
            System.out.printf("[NO SUMS]%n");
        }
    }
}
