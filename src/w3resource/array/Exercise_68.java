package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Creates all possible permutations of a given array of distinct      #
// #                     integers.                                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 9, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_68 {

    private static final int MAX_LINE_LEN = 75;

    void permute(int[] mainArray, List<ArrayList<Integer>> store, int l, int r) {
        // Base case
        if (l == r) {
            ArrayList<Integer> newList = new ArrayList<>();
            for (int data : mainArray) {
                newList.add(data);
            }
            store.add(newList);
        } else {
            // Permutation made
            for (int i = l; i <= r; i++) {
                // swapping done
                swap(mainArray, l, i);

                // Recursion called
                permute(mainArray, store, l+1, r);

                // backtrack
                swap(mainArray, l, i);
            }
        }
    }

    void swap(int[] dataSource, int fst, int snd) {
        int tmp = dataSource[fst];
        dataSource[fst] = dataSource[snd];
        dataSource[snd] = tmp;
    }

    public static void main(String[] args) {

        int[] testArrayA = {1, 2, 3, 4};
        int[] testArrayB = {1, 2, 3};

        BasicUtils.printLineInfo("[ BETA TEST CASE ]", '=', MAX_LINE_LEN);
        System.out.printf("Generated array A: %s%n", Arrays.toString(testArrayA));
        System.out.printf("Generated array B: %s%n", Arrays.toString(testArrayB));

        System.out.print("Performing permutations ... ");

        List<ArrayList<Integer>> testAList = new ArrayList<>();
        (new Exercise_68()).permute(testArrayA, testAList, 0, testArrayA.length-1);

        List<ArrayList<Integer>> testBList = new ArrayList<>();
        (new Exercise_68()).permute(testArrayB, testBList, 0, testArrayB.length-1);

        System.out.println("[DONE]");

        BasicUtils.printLineInfo("[ PERMUTATION RESULTS (Test A) ]", '=', MAX_LINE_LEN);
        for (int i = 0, size = testAList.size(); i < size; i++) {
            System.out.printf("Permutation #%02d: %s%n", i+1,
                    Arrays.toString(testAList.get(i).toArray(new Integer[0])));
        }

        BasicUtils.printLineInfo("[ PERMUTATION RESULTS (Test B) ]", '=', MAX_LINE_LEN);
        for (int i = 0, size = testBList.size(); i < size; i++) {
            System.out.printf("Permutation #%02d: %s%n", i+1,
                    Arrays.toString(testBList.get(i).toArray(new Integer[0])));
        }
    }


}
