package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Generates array data randomly and removes duplicates from the data.             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 31, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise_131 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int size, int low, int high) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid array size. Size must be > 0");
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static Integer[] removeDuplicates(int[] mainArray) {
        List<Integer> tempList = new LinkedList<>();
        for (int value : mainArray)
            if (!tempList.contains(value))
                tempList.add(value);
        return tempList.toArray(new Integer[tempList.size()]);
    }

    public static void main(String[] args) {

        int[] mainArrayData = randomIntegerArray(10, 0, 5);
        System.out.printf("Generated array data: %s\n", Arrays.toString(mainArrayData));

        Integer[] uniqueData = removeDuplicates(mainArrayData);
        System.out.printf("Non-duplicate data: %s\n", Arrays.toString(uniqueData));

    }
}
