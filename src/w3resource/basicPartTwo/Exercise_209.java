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
import java.util.Objects;
import java.util.Scanner;

public class Exercise_209 {

    private static Scanner input = new Scanner(System.in);

    private static int obtainUserTargetSum(String inputMess) {
        boolean valid = false;
        int targetSum = 0;

        while (!valid) {
            try {
                System.out.print(inputMess);
                targetSum = input.nextInt();
                valid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[INVALID_INPUT]: %s%n", iMe.getMessage());
                input.nextLine();

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-BOOTING_SCANNER]: ... ");
                input = new Scanner(System.in);
            }
        }
        return targetSum;
    }

    private static int[] readAllUserInput(String inputMess) {
        ArrayList<Integer> userInts = new ArrayList<>();
        System.out.print(inputMess);

        String allUserData = input.nextLine().trim();

        Scanner stringInputSource = new Scanner(allUserData);

        while (stringInputSource.hasNextInt()) {
            try {
                userInts.add(stringInputSource.nextInt());

            } catch (InputMismatchException iMe) {
                System.err.printf("[INVALID_INPUT]: %s%n", iMe.getMessage());
                stringInputSource.nextLine();

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-BOOTING_SCANNER]: ... ");
                stringInputSource = new Scanner(allUserData);
            }
        }

        return Arrays.stream(userInts.toArray(new Integer[0])).mapToInt(v -> v).toArray();
    }

    private static ArrayList<SolSet_209> findAllSolutionSets(int[] mainData, int target) {
        ArrayList<SolSet_209> uniqueSolSet = new ArrayList<>();

        for (int i = 0; i < mainData.length; i++) {
            int tempSum =  mainData[i];
            SolSet_209 newTempSet = new SolSet_209(tempSum);

            if (tempSum == target) {
                if (!uniqueSolSet.contains(newTempSet)) {
                    uniqueSolSet.add(newTempSet);
                }
            } else {
                for (int j = i+1; j < mainData.length; j++) {
                    tempSum += mainData[j];
                    newTempSet.add(mainData[j]);

                    if (tempSum == target) {
                        if (!uniqueSolSet.contains(newTempSet)) {
                            uniqueSolSet.add(newTempSet);
                            break;
                        }
                    }
                }
            }
        }
        return uniqueSolSet;
    }

    public static void main(String[] args) {

        int[] userData = readAllUserInput("Enter elements: ");
        System.out.printf("Elements entered: %s%n", Arrays.toString(userData));

        int userTargetSum = obtainUserTargetSum("Enter target sum: ");

        ArrayList<SolSet_209> allUniqueSolutions = findAllSolutionSets(userData, userTargetSum);

        System.out.println();
        for (int i = 0, size = allUniqueSolutions.size(); i < size; i++) {
            System.out.printf("Solution #%d: %s%n", i+1, allUniqueSolutions.get(i));
        }

    }
}

class SolSet_209 {
    private final ArrayList<Integer> solSet;

    public SolSet_209() {
        this.solSet = new ArrayList<>();
    }

    public SolSet_209(int firstElem) {
        this.solSet = new ArrayList<>();
        this.solSet.add(firstElem);
    }

    public void add(int newInt) {
        this.solSet.add(newInt);
    }

    @Override
    public boolean equals(Object obj) {
        if (Objects.isNull(obj) || !(obj instanceof SolSet_209)) {
            return false;
        }
        SolSet_209 objSolSet = (SolSet_209) obj;
        if (objSolSet.solSet.size() != this.solSet.size()) {
            return false;
        }
        for (int i = 0, len = this.solSet.size(); i < len; i++) {
            if (!this.solSet.get(i).equals(objSolSet.solSet.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.solSet.toArray());
    }
}