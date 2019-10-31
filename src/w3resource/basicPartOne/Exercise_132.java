package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Find the new length of a given sorted array where duplicate elements appeared   #
// #                     at most thrice.                                                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 31, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.security.SecureRandom;
import java.util.stream.IntStream;

public class Exercise_132 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int size, int low, int high) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid array size. Size must be > 0");
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static int[] removeDuplicatesThrice(int[] mainData) {
        List<Integer> tempList = new LinkedList<>();
        for (int i = 0; i < mainData.length; i++) {
            int tmpCnt = 0;
            for (int j = i+1; j < mainData.length; j++)
                if (mainData[i] == mainData[j])
                    tmpCnt++;
            if (tmpCnt == 3)
                tempList.add(mainData[i]);
        }
        int[] newData = new int[mainData.length - (tempList.size() * 3)];
        for (int i = 0, j = 0; i < mainData.length; i++)
            if (!tempList.contains(mainData[i]))
                newData[j++] = mainData[i];
        return newData;
    }

    public static void main(String[] args) {

        int[] mainArrayData = randomIntegerArray(10, 0, 2);
        System.out.printf("Generated Array Data: %s [length: %d]\n",
                Arrays.toString(mainArrayData), mainArrayData.length);

        int[] newData = removeDuplicatesThrice(mainArrayData);
        System.out.printf("Non-duplicate (thrice) data: %s [length: %d]\n",
                Arrays.toString(newData), newData.length);
    }
}
