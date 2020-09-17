package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds two elements from a given array of positive and negative      #
// #                     elements numbers such that their sum is closest to zero.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;
import java.util.Objects;
import w3resource.utils.ArrayUtils;

public class Exercise_40 {

    private static final int LOWER_BOUND = -2;
    private static final int UPPER_BOUND = 6;
    private static final int ARRAY_SIZE = 15;

    private static class TwoCloseToZero {
        private final int valA;
        private final int valB;

        public TwoCloseToZero(int valA, int valB) {
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
    }

    private static TwoCloseToZero findClosestToZero(int[] dataSource) {

        TwoCloseToZero closeToZero = null;
        int recentClosenessToZero = Integer.MAX_VALUE;

        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j < dataSource.length; j++) {
                int tmpClosenessToZero = Math.abs(dataSource[i]) + Math.abs(dataSource[j]);

                if (tmpClosenessToZero < recentClosenessToZero) {
                    closeToZero = new TwoCloseToZero(dataSource[i], dataSource[j]);
                    recentClosenessToZero = tmpClosenessToZero;
                }
            }
        }
        return closeToZero;
    }

    public static void main(String[] args) {

        int[] dataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Data source: %s%n", Arrays.toString(dataSource));

        TwoCloseToZero closeToZero = findClosestToZero(dataSource);
        System.out.printf("Closest sum values to zero from array: %s%n",
                Objects.isNull(closeToZero) ? "[NONE]" : closeToZero);


    }

}
