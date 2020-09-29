package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Counts the number of possible triangles from a given unsorted array #
// #                     of positive integers.                                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 29, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.stream.IntStream;
import w3resource.utils.ArrayUtils;

public class Exercise_44 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 15;

    private static class Triangle {
        private int sideA;
        private int sideB;
        private int sideC;

        public Triangle(int sideA, int sideB, int sideC) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

        public int getSideA() {
            return this.sideA;
        }

        public int getSideB() {
            return this.sideB;
        }

        public int getSideC() {
            return this.sideC;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d, %d)", this.getSideA(), this.getSideB(),
                    this.getSideC());
        }
    }

    private static List<Triangle> findPossibleTriangles(int[] dataSource) {
        List<Triangle> triangleList = new ArrayList<>();

        for (int i = 0; i < dataSource.length; i++) {
            for (int j = i+1; j+1 < dataSource.length; j++) {
                int[] sides = IntStream.of(dataSource[i], dataSource[j], dataSource[j+1]).sorted().toArray();
                if ((sides[0] + sides[1] >= sides[2]) || (sides[2] + sides[1] >= sides[0]) ||
                        (sides[0] +  sides[2] >= sides[1])) {
                    triangleList.add(new Triangle(sides[0], sides[1], sides[2]));
                }
            }
        }
        return triangleList;
    }

    public static void main(String[] args) {

        int[] arrayData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Generated array: %s%n", Arrays.toString(arrayData));

        List<Triangle> trianglesFound = findPossibleTriangles(arrayData);
        System.out.printf("Triangles found (%d): %s%n", trianglesFound.size(), trianglesFound);

    }
}
