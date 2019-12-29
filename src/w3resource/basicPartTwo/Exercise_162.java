package w3resource.basicPartTwo;


// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Finds the numbers greater than the average of the numbers of #
// #                     a given array.                                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Arrays;

public class Exercise_162 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified " +
                    "size (%d) for new array.", size));
        }
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static double computeAverage(int[] mainData) {
        final int[] sum = {0};
        IntStream.of(mainData).forEach(val -> sum[0] += val);
        return (double) sum[0] / mainData.length;
    }

    private static Integer[] findAllLessThan(int[] someData, double keyVal) {
        List<Integer> newDataList = new LinkedList<>();
        for (int val : someData) {
            if (val > keyVal) {
                newDataList.add(val);
            }
        }
        return newDataList.toArray(new Integer[0]);
    }

    public static void main(String[] args) {

        int[] randomData = randomIntegerArray(0, 20, 15);
        System.out.printf("Randomly generated data: %s\n", Arrays.toString(randomData));

        double average = computeAverage(randomData);

        System.out.printf(" Average of new data is: %.2f\n", average);

        Integer[] lessThanData = findAllLessThan(randomData, average);

        System.out.printf("All array elements > '%.2f': %s\n", average, Arrays.toString(lessThanData));
    }
}
