package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Prints mode values from a given sequence of integers. The mode value  #
// #                     is the element which occurs most frequently. If there are several     #
// #                     mode values, print them in ascending order.                           #
// #    Creation Date  : July 19, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class Exercise_226 {

    private static SecureRandom random = new SecureRandom();

    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 10;
    private static final int MAX_ARRAY_SIZE = 10;

    private static int[] mapOccurrences(int[] someData) {
        HashMap<Integer, Integer> intsMap = new HashMap<>();
        int maxCnt = 0;
        for (int val : someData) {
            if (intsMap.containsKey(val)) {
                int oldCnt = intsMap.get(val);
                intsMap.put(val, oldCnt + 1);

                if (oldCnt + 1 > maxCnt) {
                    maxCnt = oldCnt +1;
                }
            } else {
                intsMap.put(val, 1);
            }
        }
        HashMap<Integer, Integer> mostFrequentMap = new HashMap<>();
        for (int key : intsMap.keySet()) {
            if (intsMap.get(key) == maxCnt) {
                mostFrequentMap.put(key, intsMap.get(key));
            }
        }
        ArrayList<Integer> mostFreqList = new ArrayList<>();
        mostFrequentMap.forEach((key, val) -> mostFreqList.add(key));

        Collections.sort(mostFreqList);

        return mostFreqList.stream().mapToInt((v) -> v).toArray();
    }

    private static int[] simulateUserInput(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(
                    String.format("New array size (%d) must be > 0", size));
        }
        if (low > high) {
            throw new IllegalArgumentException("Lower bound must be < upper bound");
        }
        return Arrays.stream(new int[size]).map((i) -> low + random.nextInt(high)).toArray();
    }

    public static void main(String[] args) {

        int[] simulatedData = simulateUserInput(LOWER_BOUND, UPPER_BOUND, MAX_ARRAY_SIZE);
        System.out.printf("Simulated array data: %s%n", Arrays.toString(simulatedData));

        int[] mostFreqInt = mapOccurrences(simulatedData);
        System.out.printf("Most frequent values: %s%n", Arrays.toString(mostFreqInt));
    }

}
