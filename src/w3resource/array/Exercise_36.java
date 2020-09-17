package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Find all unique triplets such that sum of all three elements equals #
// #                     a specific number.                                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.List;

import w3resource.utils.ArrayUtils;
import w3resource.utils.InputUtils;

public class Exercise_36 {

    private static final int LOWER_BOUND = -2;
    private static final int UPPER_BOUND = 5;
    private static final int ARRAY_SIZE = 15;


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
        public boolean equals(Object obj) {
            if (Objects.isNull(obj) || !(obj instanceof Triplet)) {
                return false;
            }
            Triplet otherObj = (Triplet) obj;
            return otherObj.valA == this.valA && otherObj.valB == this.valB
                    && otherObj.valC == this.valC;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", this.getValA(), this.getValB(),
                    this.getValC());
        }
    }

    private static List<Triplet> findAllUniqueTriplets(int[] dataSource, int target) {
        List<Triplet> tripletsFoundList = new ArrayList<>();

        for (int i = 0; i < dataSource.length; i++) {
            if (i + 3 < dataSource.length) {
                int sum = dataSource[i] + dataSource[i+1] + dataSource[i+2];
                if (sum == target) {
                    Triplet newTriplet = new Triplet(dataSource[i], dataSource[i+1], dataSource[i+2]);
                    if (!tripletsFoundList.contains(newTriplet)) {
                        tripletsFoundList.add(newTriplet);
                    }
                }

            }
        }
        return tripletsFoundList;
    }

    public static void main(String[] args) {

        int[] dataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Data source: %s%n", Arrays.toString(dataSource));

        int userTargetValue = InputUtils.obtainUserIntegerInput("Enter your target triplet sum value: ");
        List<Triplet> foundTriplets = findAllUniqueTriplets(dataSource, userTargetValue);

        int[] cnt = {0};
        foundTriplets.forEach((triplet) -> System.out.printf("[#%d]: %s%n", cnt[0]++,triplet));

    }
}
