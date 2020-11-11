package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Program that finds the largest number from a given list of non      #
// #                     negative integers.                                                  #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 11, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.ArrayUtils;
import w3resource.utils.BasicUtils;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise_71 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int ARRAY_SIZE = 15;
    private static final int MAX_LINE_LENGTH = 75;

    private static long findLargestNumberA(int[] dataSource) {
        StringBuilder sb = new StringBuilder();
        int[] dataCopy = IntStream.of(dataSource).toArray();

        Arrays.sort(dataCopy);

        for (int data : dataCopy) {
            sb.append(data);
        }
        return Long.parseLong(sb.reverse().toString());
    }

    private static String findLargestNumberB(int[] dataSource) {
        String[] arrayNums = Arrays.stream(dataSource).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(arrayNums, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));

        return Arrays.stream(arrayNums).reduce((a, b) -> a.equals("0") ? b : a + b).get();
    }

    public static void main(String[] args) {

        int[] testData = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        BasicUtils.printLineInfo("[ TEST DATA ]", '=', MAX_LINE_LENGTH);

        System.out.printf("Generated Test Data: %s%n", Arrays.toString(testData));

        BasicUtils.printLineInfo(" [ RESULTS ]", '=', MAX_LINE_LENGTH);

        long largestNumA = findLargestNumberA(testData);
        String largestNumB = findLargestNumberB(testData);

        System.out.printf("Largest Number (using algo #A): %d%n", largestNumA);
        System.out.printf("Largest Number (using algo #B): %s%n", largestNumB);

    }
}
