package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Tests if the first and the last element of two array of integers are same #                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 17, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_76 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
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

    private static boolean sameLastElements(int[] dataA, int[] dataB) {
        if (dataA.length < 2)
            throw new IllegalArgumentException("First array length must be >= 2");
        if (dataB.length < 2)
            throw new IllegalArgumentException("Second array length must be >= 2");
        return dataA[dataA.length-1] == dataB[dataB.length-1];
    }

    public static void main(String[] args) {
        int[] dataA = randomIntegerArray(0, 10, 10);
        int[] dataB = randomIntegerArray(0, 10, 10);

        printArrayData("Generated array A: ", dataA);
        printArrayData("Generated array B: ", dataB);

        System.out.printf("Arrays have same last element: %s\n",
                sameLastElements(dataA, dataB) ? "YES" : "NO");
    }

}
