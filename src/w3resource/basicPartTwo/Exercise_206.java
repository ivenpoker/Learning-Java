package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds all unique combinations from a collection of candidate numbers. #
// #                     The sum of the numbers will be equal to a given target number.        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 24, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_206 {

    private static Scanner scanner = new Scanner(System.in);

    private static int obtainUserInput(String inputMess) {
        boolean valid = false;
        int userInt = -1;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInt = scanner.nextInt();
                if (userInt >= 0) {
                    valid = true;
                }
            } catch (InputMismatchException iMe) {
                System.err.println("[INVALID_INPUT]: Invalid input");
                scanner.nextLine();         // clear input stream

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-BOOTING_SCANNER] ... ");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");
            }
        }
        return userInt;
    }

    private static int[] obtainAllUserInput(String inputMess, int maxInputCnt) {
        int[] dataStore = new int[maxInputCnt];
        for (int i = 0; i < maxInputCnt; i++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    System.out.print(inputMess);
                    int userInt = scanner.nextInt();
                    validInput = true;

                    // we now store the data read from user
                    dataStore[i] = userInt;

                } catch (InputMismatchException iMe) {
                    System.err.println("[INVALID_INPUT]: Invalid input");

                } catch (IllegalStateException iSe) {
                    System.err.print("[RE-BOOTING_SCANNER] ... ");
                    scanner = new Scanner(System.in);
                    System.out.println("[DONE]");
                }
            }
        }
        System.out.println();
        return dataStore;
    }

    private static class SolSet {
        private final ArrayList<Integer> solutionSet;

        public SolSet() {
            this.solutionSet = new ArrayList<>();
        }

        public void add(Integer data) {
            this.solutionSet.add(data);
        }

        @Override
        public String toString() {
            return Arrays.toString(this.solutionSet.toArray(new Integer[0]));
        }
    }

    private static ArrayList<SolSet> findAllCombinationsForTarget(int[] mainData, int target) {
        ArrayList<SolSet> solSetsList = new ArrayList<>();

        for (int i = 0; i < mainData.length; i++) {
            int tempSum = mainData[i];
            SolSet tempSolSet = new SolSet();
            tempSolSet.add(tempSum);

            if (tempSum == target) {
                solSetsList.add(tempSolSet);
            } else {
                for (int j = i+1; j < mainData.length; j++) {
                    tempSum += mainData[j];
                    tempSolSet.add(mainData[j]);

                    if (tempSum == target) {
                        solSetsList.add(tempSolSet);
                    }
                }
            }
        }

        return  solSetsList;
    }

    private static void displayResults(ArrayList<SolSet> results) {
        for (int i = 0, len = results.size(); i < len; i++) {
            System.out.printf("Solution #%d: %s%n", i+1, results.get(i));
        }
    }

    public static void main(String[] args) {

        int userVal = obtainUserInput("Input number of elements in array: ");
        int[] userData = obtainAllUserInput("Enter number (as: 1 2 3): ", userVal);

        int targetSum = obtainUserInput("Enter target sum: ");

        ArrayList<SolSet> solutionSets = findAllCombinationsForTarget(userData, targetSum);

        displayResults(solutionSets);

    }
}
