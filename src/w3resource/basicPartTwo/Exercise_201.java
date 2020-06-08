package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Divide a given array of integers into given non-empty subsets whose   #
// #                     sums are all equal.                                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 8, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Exercise_201 {

    private static final SecureRandom randomNumber = new SecureRandom();
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 15;

    private static HashMap<Integer, ArrayList<Subset>> findKSubsets(int[] mainArr) {
        HashMap<Integer, ArrayList<Subset>> numAndSetSum = new HashMap<>();

        for (int currSum : mainArr) {
            ArrayList<Subset> currSumSet = new ArrayList<>();

            // find all subsets whose sum is 'currSumSet'
            if (!numAndSetSum.containsKey(currSum)) {
                for (int i = 0; i < mainArr.length; i++) {
                    for (int j = 0; j < mainArr.length; j++) {
                        if (i == j) {
                            Subset tmpSubset = new Subset(currSum, 0);
                            if (!currSumSet.contains(tmpSubset)) {
                                currSumSet.add(tmpSubset);
                            }
                        } else if (mainArr[i] + mainArr[j] == currSum) {
                            Subset tmpSubset = new Subset(mainArr[i], mainArr[j]);
                            if (!currSumSet.contains(tmpSubset)) {
                                currSumSet.add(tmpSubset);
                            }
                        }
                    }
                }
            }

            if (numAndSetSum.containsKey(currSum)) {
                ArrayList<Subset> oldSet = numAndSetSum.get(currSum);
                for (Subset someSet : currSumSet){
                    if (!oldSet.contains(someSet)) {
                        oldSet.add(someSet);
                    }
                }
                numAndSetSum.put(currSum, oldSet);
            } else {
                numAndSetSum.put(currSum, currSumSet);
            }
        }

        return numAndSetSum;
    }

    private static int[] randomData(int lower, int upper, int size) {
        return Arrays.stream(new int[size]).map((val) -> lower + randomNumber.nextInt(upper)).toArray();
    }

    private static void printDetails(HashMap<Integer, ArrayList<Subset>> mainData) {
        for (Integer key : mainData.keySet()) {
            System.out.printf("%2d: %s%n", key, mainData.get(key));
        }

    }

    public static void main(String[] args) {
        int[] mainData = randomData(LOWER_BOUND, UPPER_BOUND, 100);
        System.out.printf("Generated Array: %s%n", Arrays.toString(mainData));

        HashMap<Integer, ArrayList<Subset>> foundData = findKSubsets(mainData);
        printDetails(foundData);
    }

}

class Subset {
    public int valA;
    public int valB;

    public Subset(int valA, int valB) {
        this.valA = valA;
        this.valB = valB;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Subset)) {
            return false;
        }
        Subset otherObj = (Subset) obj;
        return (this.valA == otherObj.valA && this.valB == otherObj.valB) ||
                (this.valA == otherObj.valB && this.valB == otherObj.valA);
    }

    @Override
    public String toString() {
        if (this.valA == 0 && this.valB != 0) {
            return String.format("(%d)", this.valB);
        } else if (this.valA != 0 && this.valB == 0) {
            return String.format("(%d)", this.valA);
        } else {
            return String.format("(%d, %d)", this.valA, this.valB);
        }
    }
}
