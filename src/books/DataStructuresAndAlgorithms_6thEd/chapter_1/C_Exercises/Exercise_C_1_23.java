// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.23 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 3/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.security.SecureRandom;
import java.util.Objects;

public class Exercise_C_1_23 {

    public static SecureRandom random = new SecureRandom();

    public static void randomFillArray(int[] data, int low, int high) {
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
    }

    public static int[] dotProduct(int[] arrayA, int[] arrayB) {
        if (arrayA.length != arrayB.length)
            return null;
        int[] arrayC = new int[arrayA.length]; // could have been arrayB, doesn't really matters
        for (int i = 0; i < arrayA.length; i++)
            arrayC[i] = arrayA[i] * arrayB[i];
        return arrayC;
    }

    public static void printArrayData(String mess, int[] data) {
        System.out.printf("%s", mess);
        int i = 0;
        for (Integer intVal : data)
            System.out.printf("%02d%s", intVal, (i++ == data.length-1) ? "\n" : " ");
    }

    public static void main(String[] args) {

        int[] arrayA = new int[10];
        int[] arrayB = new int[10];

        randomFillArray(arrayA, 0, 10);
        randomFillArray(arrayB, 0, 10);

        printArrayData("Array A: ", arrayA);
        printArrayData("Array B: ", arrayB);

        int[] arrayC = dotProduct(arrayA, arrayB);

        if (Objects.isNull(arrayC)) {
            System.out.printf("[ERROR]: Size of arrays not same\n");
        } else {
            printArrayData("Array C: ", arrayC);
        }
    }
}
