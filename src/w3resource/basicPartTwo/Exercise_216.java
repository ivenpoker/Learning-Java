package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Reads an integer and finds the number of combinations that sum up to  #
// #                     to a specified number, with a specified count.                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 03, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_216 {

    private static Scanner scanner = new Scanner(System.in);
    private static final int LOWER_BOUND = -1000;
    private static final int UPPER_BOUND = 1000;

    private static int readUserNumber(String inputMess) {
        boolean isValid = false;
        int userNum = 0;

        while (!isValid) {
            try {
                System.out.print(inputMess);
                userNum = scanner.nextInt();
                isValid = true;

            } catch (InputMismatchException iMe) {
                System.err.println("[INVALID__INPUT]: Input must be an integer");
                scanner.nextLine();                 // clear input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[RE-OPENING__SCANNER] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine() ;                // clear input stream.
                System.out.println("[DONE]");

            } catch (Exception exc) {
                System.err.printf("[CORE__EXC]: %s%n", exc.getMessage());
                scanner.nextLine();
            }
        }
        return userNum;
    }

    private static ArrayList<SolutionSet> findAllSolutionsForNum(int mainNum, int min, int maxExc) {

        ArrayList<SolutionSet> solutionSetsList = new ArrayList<>();

        for (int i = min; i < maxExc; i++) {
            SolutionSet tmpSolSet = new SolutionSet();
            tmpSolSet.add(i);
            int tmpSum = i;
            boolean found = false;

            for (int j = i+1; j < maxExc; j++) {
                if (tmpSum + j == mainNum) {
                    found = true;
                    tmpSolSet.add(j);
                    // at this point, adding new numbers is assumed not to EVER yield 'mainNum'
                    break;
                }
                tmpSolSet.add(j);
                tmpSum += j;
            }
            if (found) {
                solutionSetsList.add(tmpSolSet);
            }
        }
        return solutionSetsList;
    }

    private static ArrayList<SolutionSet> filterSolutionSetByLength(ArrayList<SolutionSet> solutionSets, int length) {
        ArrayList<SolutionSet> filteredSet = new ArrayList<>();

        solutionSets.forEach((solutionSet) -> {
            if (solutionSet.solSet.size() == length) {
                filteredSet.add(solutionSet);
            }
        });
        return filteredSet;
    }

    private static void printAllSolutions(ArrayList<SolutionSet> solutionSets) {
        if (solutionSets.isEmpty()) {
            System.out.printf("[NO RESULTS]%n");
        }
        for (int i = 0, len = solutionSets.size(); i < len; i++) {
            System.out.printf("Solution #%02d: %s%n", i+1, solutionSets.get(i));
        }
    }

    public static void main(String[] args) {

        int mainNum = readUserNumber("Enter main number: ");
        ArrayList<SolutionSet> solutionSetsList = findAllSolutionsForNum(mainNum, LOWER_BOUND, UPPER_BOUND);

        ArrayList<SolutionSet> solutionSetOfLength4 = filterSolutionSetByLength(solutionSetsList, 4);

        System.out.printf("All solutions for sum '%d' in [%d, %d]:%n%n", mainNum, LOWER_BOUND, UPPER_BOUND);
        printAllSolutions(solutionSetsList);

        System.out.printf("%nSolution set of length 4 (count: %d):%n%n", solutionSetOfLength4.size());
        printAllSolutions(solutionSetOfLength4);

    }
}

class SolutionSet {
    public ArrayList<Integer> solSet;

    public SolutionSet() {
        this.solSet = new ArrayList<>();
    }

    public void add(int solNum) {
        this.solSet.add(solNum);
    }

    @Override
    public String toString() {
        return Arrays.toString(this.solSet.toArray(new Integer[0]));
    }
}











































