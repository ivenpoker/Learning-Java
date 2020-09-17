package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Program that removes duplicate elements of a given array and return #
// #                     the new length of the array.                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;
import w3resource.utils.ArrayUtils;

public class Exercise_33 {

    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 100;
    private static final int SIZE = 10;

    private static int removeDuplicatesAndGetLength_A(int[] dataSource) {
        List<Integer> uniqueInts = new ArrayList<>();
        for (int datum : dataSource) {
            if (!uniqueInts.contains(datum)) {
                uniqueInts.add(datum);
            }
        }
        return uniqueInts.size();
    }

    private static int removeDuplicatesAndGetLength_B(int[] dataSource) {
        return IntStream.of(dataSource).distinct().toArray().length;
    }

    public static void main(String[] args) {

        int[] dataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, SIZE);
        System.out.printf("Random generated data: %s | Length: %d%n",
                Arrays.toString(dataSource), dataSource.length);

        System.out.printf("[A] Length with no duplicates: %d%n", removeDuplicatesAndGetLength_A(dataSource));
        System.out.printf("[B] Length with no duplicates: %d%n", removeDuplicatesAndGetLength_B(dataSource));
    }

}
