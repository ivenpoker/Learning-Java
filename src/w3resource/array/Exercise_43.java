package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds all combination of four elements of a given array whose sum   #
// #                     is equal to a given value.                                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import w3resource.utils.ArrayUtils;
import w3resource.utils.InputUtils;

public class Exercise_43 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 50;

    private static class Quadruplet {
        private final int valA;
        private final int valB;
        private final int valC;
        private final int valD;

        public Quadruplet(int valA, int valB, int valC, int valD) {
            this.valA = valA;
            this.valB = valB;
            this.valC = valC;
            this.valD = valD;
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

        public int getValD() {
            return this.valD;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d, %d)", this.getValA(), this.getValB(),
                    this.getValC(), this.getValD());
        }
    }

    private static List<Quadruplet> findAllFourElementCombination(int[] dataSource, int targetSum) {
        List<Quadruplet> quadruplets = new ArrayList<>();
        if (dataSource.length < 4) {
            return quadruplets;
        }
        for (int i = 0; i < dataSource.length; i++) {
            if (i + 4 < dataSource.length) {
                int tmpSum = dataSource[i] + dataSource[i+1] + dataSource[i+2] + dataSource[i+3];
                if (tmpSum == targetSum) {
                    quadruplets.add(new Quadruplet(dataSource[i], dataSource[i+1],
                            dataSource[i+2], dataSource[i+3]));
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        int[] dataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated array: %s%n", Arrays.toString(dataSource));

        int userTarget = InputUtils.obtainUserIntegerInput("Enter target sum: ");
        List<Quadruplet> allQuadruplet = findAllFourElementCombination(dataSource, userTarget);

        int[] cnt = {0};
        allQuadruplet.forEach((quad) -> {
            System.out.printf("[#%d] - %s%n", cnt[0]++, quad);
        });
    }
}
