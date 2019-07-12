// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.15 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 19/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.C_Exercises;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;

public class Exercise_C_3_17 {

    // ################################## RESPONSE TO THE QUESTION HERE ##############################
    // Algorithm:
    //
    //       array (array of ints))
    //       somelist (a list that can hold integers);
    //
    //       WHILE there are at least 2 elements in the array:
    //             IF current element not found in list:
    //                  INSERT element in list.
    //             ELSE report the duplicate
    //
    //       RETURN NULL (no item repeats in
    //

    private static void randomFillArray(int[] data, int low, int high) {
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
    }

    public static void main(String[] args) {
        int[] data = new int[20];

        randomFillArray(data, 0, data.length);

        System.out.print("Original array: ");
        for (int intVal : data)
            System.out.printf("%d ", intVal);
        System.out.println();

        Integer repeat = findRepeatedInteger(data);
        if (repeat == null) {
            System.out.println("Array has no duplicate(s)");
        } else {
            System.out.printf("Duplicate integer: %d\n", repeat);
        }

    }

    private static Integer findRepeatedInteger(int[] data) {
        List<Integer> list = new LinkedList<>();    // could have used the chapter lists, but a method to check if an
        // item is found must be provided.

        for (int intVal : data) {
            if (list.contains(intVal))          // if current integer in array is already in list, it's a duplicate
                return intVal;                  // return the integer.
            list.add(intVal);                   // the current integer isn't a duplicate, add to list (of uniques).
        }
        return null;

    }

}
