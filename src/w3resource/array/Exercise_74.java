package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds all triplets equal to a given sum in an unsorted array of     #
// #                     integers.                                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 21, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise_74 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LENGTH = 75;

    private static class Triplet {
        private final int valA;
        private final int valB;
        private final int valC;

        public Triplet(int valA, int valB, int valC) {
            this.valA = valA;
            this.valB = valB;
            this.valC = valC;
        }

        public int getValA() {
            return this.valA;
        }

        public int getValB() {
            return this.valB;
        }

        public int getValC() {
            return this.valC;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", this.getValA(),
                    this.getValB(), this.getValC());
        }
    }

    public static List<Triplet> findTripletsThatSumToTarget(int[] nums, int sum) {
        List<Triplet> tripletList = new ArrayList<>();
        for (int i = 0; i <= nums.length - 3; i++) {
            int k = sum - nums[i];
            int l_index = i + 1, h_index = nums.length - 1;

            while (l_index < h_index) {
                if (nums[l_index] + nums[h_index] < k) {
                    l_index++;
                } else if (nums[l_index] + nums[h_index] > k) {
                    h_index--;
                } else {
                    tripletList.add(new Triplet(nums[i], nums[l_index], nums[h_index]));
                    l_index++;
                    h_index--;
                }
            }
        }
        return tripletList;
    }

    public static void main(String[] args) {
        int[] testData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        BasicUtils.printLineInfo("[ TEST DATA ]", '=', MAX_LINE_LENGTH);

        int targetSum = 12;

        System.out.printf("Generated Test Data: %s%n", Arrays.toString(testData));
        System.out.printf("Target sum: %d%n", targetSum);

        BasicUtils.printLineInfo("[ TEST RESULTS ]", '=', MAX_LINE_LENGTH);

        Arrays.sort(testData);
        List<Triplet> foundTripletList = findTripletsThatSumToTarget(testData, targetSum);

        System.out.printf("Found %d triplet(s).%n", foundTripletList.size());
        System.out.printf("Triplets are ...%n%n");

        for (Triplet triplet : foundTripletList) {
            System.out.println(triplet);
        }

        BasicUtils.printLineInfo("[ MAIN TEST CASE]", '=', MAX_LINE_LENGTH);

        int[] newTestData = { 1, 6, 3, 0, 8, 4, 1, 7 };
        targetSum = 7;

        System.out.printf("Generated Test Data: %s%n", Arrays.toString(newTestData));
        System.out.printf("Target Sum is: %d%n", targetSum);

        BasicUtils.printLineInfo("[ TEST RESULTS ]", '=', MAX_LINE_LENGTH);

        Arrays.sort(newTestData);
        foundTripletList = findTripletsThatSumToTarget(newTestData, targetSum);

        System.out.printf("Found %d triplet(s).%n", foundTripletList.size());
        System.out.printf("Triplets are ...%n%n");

        for (Triplet triplet : foundTripletList) {
            System.out.println(triplet);
        }
    }
}
