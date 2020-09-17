package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the sum of two elements of a given array which is equal to a  #
// #                     given integer.                                                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import w3resource.utils.ArrayUtils;
import w3resource.utils.InputUtils;

public class Exercise_35 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 5;
    private static final int ARRAY_SIZE = 10;

    private static class TwoVals {
        private final int valA;
        private final int valB;

        public TwoVals(int valA, int valB) {
            this.valA = valA;
            this.valB = valB;
        }

        public int getValA() {
            return this.valA;
        }

        public int getValB() {
            return this.valB;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", this.getValA(), this.getValB());
        }

        @Override
        public boolean equals(Object obj) {
            if (Objects.isNull(obj) || !(obj instanceof TwoVals)) {
                return false;
            }
            TwoVals otherObj = (TwoVals) obj;
            return otherObj.valA == this.valA && otherObj.valB == this.valB;
        }
    }

    private static List<TwoVals> findTwoThatSumToTarget(int[] dataSource, int target) {
        List<TwoVals> twoValsList = new ArrayList<>();
        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j < dataSource.length; j++) {
                if (dataSource[i] + dataSource[j] == target) {

                    TwoVals newTwoVal = new TwoVals(dataSource[i], dataSource[j]);
                    if (!twoValsList.contains(newTwoVal)) {
                        twoValsList.add(newTwoVal);
                    }
                }
            }
        }
        return twoValsList;
    }

    public static void main(String[] args) {

        int[] dataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Data source: %s%n", Arrays.toString(dataSource));

        int targetValue = InputUtils.obtainUserIntegerInput("Enter target sum value: ");
        List<TwoVals> allTwoValsSum = findTwoThatSumToTarget(dataSource, targetValue);

        int[] cnt = {0};
        allTwoValsSum.forEach((twoVal) -> {
            System.out.printf("[#%d] %s%n", cnt[0]++, twoVal);
        });
    }
}
