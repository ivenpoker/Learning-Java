package w3resource.basicPartOne;

// ##################################################################################################
// #                                                                                                #
// #    Program Purpose: Counts the number of even and odd elements in a given array of integers.   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                      #
// #    Creation Date  : September 20, 2019                                                         #
// #                                                                                                #
// ##################################################################################################

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

public class Exercise_92 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static Map<String, Integer> findNumberOfEvensAndOdds(int[] someData) {
        Map<String, Integer> evensAndOdds = new HashMap<>();
        for (int someDatum : someData) {
            if (someDatum % 2 == 0) {
                if (evensAndOdds.containsKey("evens")) {
                    int temp = evensAndOdds.get("evens");
                    evensAndOdds.put("evens", temp + 1);
                } else {
                    evensAndOdds.put("evens", 1);
                }
            } else {
                if (evensAndOdds.containsKey("odds")) {
                    int temp = evensAndOdds.get("odds");
                    evensAndOdds.put("odds", temp + 1);
                } else {
                    evensAndOdds.put("odds", 1);
                }
            }
        }
        return evensAndOdds;
    }

    private static void printIntegerArray(String outputMessage, int[] mainData, int breakPoint) {
        System.out.print(outputMessage);
        for (int i = 0; i < mainData.length; i++) {
            if (i % (breakPoint - 1) == 0) {
                System.out.println();
            } else {
                System.out.printf("%d ", mainData[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 100);
        printIntegerArray("Generated data: \n", newData, 10);
        Map<String, Integer> infoData= findNumberOfEvensAndOdds(newData);

        System.out.println();
        System.out.printf("Number of evens: %d\nNumber of odds: %d\n",
                infoData.get("evens"), infoData.get("odds"));

    }
}
