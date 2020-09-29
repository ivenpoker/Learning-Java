package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Checks whether there is a pair with a specified sum of a given      #
// #                     sorted and rotated array.                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 29, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import w3resource.utils.ArrayUtils;
import w3resource.utils.InputUtils;

public class Exercise_46 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 20;

    private static class Pairs {
        private final List<Integer> intList;

        public Pairs() {
            this.intList = new ArrayList<>();
        }

        public void add(Integer newElem) {
            this.intList.add(newElem);
        }

        public int sum() {
            return this.intList.stream().reduce(0, (acc, val) -> acc + val);
        }

        @Override
        public String toString() {
            return this.intList.toString();
        }
    }

    private static List<Pairs> findAllSumPairs(int[] dataSource, int sumTarget) {
        List<Pairs> foundPairs = new ArrayList<>();

        for (int i = 0; i < dataSource.length; i++) {
            Pairs pairs = new Pairs();
            pairs.add(dataSource[i]);

            for (int j = i+1; j < dataSource.length; j++) {
                int tmpSum = pairs.sum() + dataSource[j];
                if (tmpSum == sumTarget) {

                    pairs.add(dataSource[j]);
                    foundPairs.add(pairs);

                } else if (tmpSum < sumTarget) {
                    pairs.add(dataSource[j]);
                } else {
                    break;
                }
            }
        }
        return foundPairs;
    }

    public static void main(String[] args) {

        int[] mainData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated data: %s%n", Arrays.toString(mainData));

        int userTargetSum = InputUtils.obtainUserIntegerInput("Enter target sum: ");

        List<Pairs> foundPairs = findAllSumPairs(mainData, userTargetSum);
        System.out.println("Found pairs ...");

        for (int i = 0, size = foundPairs.size(); i < size; i++) {
            System.out.printf("#%d - %s%n", (i+1), foundPairs.get(i));
        }

    }
}
