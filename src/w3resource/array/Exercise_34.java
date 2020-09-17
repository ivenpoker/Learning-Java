package w3resource.array;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the longest consecutive elements sequence from a given        #
// #                     unsorted array of integers.                                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : September 17, 2020                                                  #
// #                                                                                         #
// ###########################################################################################

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.List;
import w3resource.utils.ArrayUtils;

public class Exercise_34 {

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 20;
    private static final int ARRAY_SIZE = 10;

    private static List<Integer> findLengthOfLongestConsecutiveElements(int[] dataSource) {
        int[] sortedData = IntStream.of(dataSource).sorted().toArray();
        // System.out.printf("Sorted data: %s%n", Arrays.toString(sortedData));

        List<Integer> longestIntsList = new ArrayList<>();

        for (int i = 0; i < sortedData.length; i++) {
            List<Integer> tmpList = new ArrayList<>();
            tmpList.add(sortedData[i]);

            for (int j = i+1; j < sortedData.length; j++) {
                if (sortedData[j] - sortedData[j-1] == 1){
                    tmpList.add(sortedData[j]);
                } else {
                    break;
                }
            }
            if (tmpList.size() > longestIntsList.size()) {
                longestIntsList = tmpList;
            }
        }
        return longestIntsList;
    }

    public static void main(String[] args) {
        int[] mainDataSource = ArrayUtils.randomIntArrayData(LOWER_BOUND, UPPER_BOUND, ARRAY_SIZE);
        System.out.printf("Main data source: %s%n", Arrays.toString(mainDataSource));

        List<Integer> longestSeq = findLengthOfLongestConsecutiveElements(mainDataSource);
        System.out.printf("Length of longest consecutive: %d%n", longestSeq.size());
        System.out.println();

        // Another test case
        int[] testCase = {49,1, 3, 200, 2, 4, 70, 5};
        System.out.printf("Another data source: %s%n", Arrays.toString(testCase));

        longestSeq = findLengthOfLongestConsecutiveElements(testCase);
        System.out.printf("Length of longest consecutive: %d%n", longestSeq.size());


    }
}
