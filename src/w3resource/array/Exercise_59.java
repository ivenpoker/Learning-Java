package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the maximum product of two integers in a given array of       #
// #                     integers.                                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 8, 2020                                                    #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;
import java.util.Objects;

public class Exercise_59 {

    private static final int LOWER_BOUND = -5;
    private static final int UPPER_BOUND = 25;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LEN = 70;

    private static class ProductPair<T extends Number> {
        private T fstVal;
        private T sndVal;

        public ProductPair(T fstVal, T sndVal) {
            this.fstVal = fstVal;
            this.sndVal = sndVal;
        }

        public T getFirstValue() {
            return this.fstVal;
        }

        public T getSecondValue() {
            return this.sndVal;
        }

        public void setFirstValue(T fstVal) {
            Objects.requireNonNull(fstVal);
            this.fstVal = fstVal;
        }

        public void setSecondValue(T sndVal) {
            Objects.requireNonNull(sndVal);
            this.sndVal = sndVal;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)",
                    this.getFirstValue(), this.getSecondValue());
        }
    }

    private static ProductPair<Integer> findMaxProductPair(int[] dataSource) {
        if (dataSource.length <= 1) {
            throw new IllegalArgumentException(
                    String.format("Invalid argument. Has length of %d, but must be of length >= 2",
                            dataSource.length));
        }
        ProductPair<Integer> maxProdPair = new ProductPair<>(0, 0);

        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j < dataSource.length; j++) {
                int newProd = dataSource[i] * dataSource[j];
                if (newProd > (maxProdPair.getFirstValue() * maxProdPair.getSecondValue())) {
                    maxProdPair.setFirstValue(dataSource[i]);
                    maxProdPair.setSecondValue(dataSource[j]);
                }
            }
        }
        return maxProdPair;

    }

    public static void main(String[] args) {
        int[] randomIntA = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);

        System.out.println();
        BasicUtils.printLineMessage("[ FIRST TEST ]", '=', MAX_LINE_LEN);
        System.out.println();

        System.out.printf("Generated Array: %s%n", Arrays.toString(randomIntA));

        ProductPair<Integer> maxProdPair = findMaxProductPair(randomIntA);
        System.out.printf("Pair is %s, Maximum Product: %d%n", maxProdPair,
                maxProdPair.getFirstValue() * maxProdPair.getSecondValue());

        System.out.println();
        BasicUtils.printLineMessage("[ SECOND TEST ]", '=', MAX_LINE_LEN);
        System.out.println();

        int[] testData = {2, 3, 5, 7, -7, 5, 8, -5};
        System.out.printf("Test data array: %s%n", Arrays.toString(testData));

        maxProdPair = findMaxProductPair(testData);

        System.out.printf("Pair is %s, Maximum Product: %d%n", maxProdPair,
                maxProdPair.getFirstValue() * maxProdPair.getSecondValue());

    }
}
