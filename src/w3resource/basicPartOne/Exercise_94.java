package w3resource.basicPartOne;

// ####################################################################################################
// #                                                                                                  #
// #    Program Purpose: Rearranges all the elements of an array of integers so that all odd numbers  #
// #                     come before all the even numbers.                                            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                        #
// #    Creation Date  : September 23, 2019                                                           #
// #                                                                                                  #
// ####################################################################################################

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise_94 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);

        return newData;
    }

    private static void printArrayData(String mess, int[] data) {
        System.out.print(mess);
        for (int i = 0; i < data.length; i++)
            System.out.printf("%d%s", data[i], i == data.length-1 ? "" : " ");
        System.out.println();
    }

    private static void orderArrayDataIntoOddsAndEvens(int[] data) {
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();

        for (int datum : data) {
            if (datum % 2 == 0) {
                evenList.add(datum);
            } else {
                oddList.add(datum);
            }
        }
        Collections.sort(oddList);
        Collections.sort(evenList);

        int i = 0;
        for (; i < oddList.size(); i++)
            data[i] = oddList.get(i);
        for (int j = 0; j < evenList.size(); i++, j++)
            data[i] = evenList.get(j);
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 10);
        printArrayData("Generated array data: ", newData);

        orderArrayDataIntoOddsAndEvens(newData);

        printArrayData("Sorted array data: ", newData);
    }
}
