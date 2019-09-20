package w3resource.basicPartOne;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Creates a new array of size 2 from two arrays of size 3. New array will   #
// #                     contain the last integer from both arrays.                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 20, 2019                                                        #
// #                                                                                               #
// #################################################################################################

import java.security.SecureRandom;

public class Exercise_77 {

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


    private static int[] createNewArray(int[] dataA, int[] dataB) {
        if (dataA.length != 3)
            throw new IllegalArgumentException("First array must have length of 3");
        if (dataB.length != 3)
            throw new IllegalArgumentException("Second array must have length of 3");

        return new int[] {dataA[dataA.length-1], dataB[dataB.length-1]};
    }

    public static void main(String[] args) {

        int[] dataA = randomIntegerArray(0, 10, 3);
        int[] dataB = randomIntegerArray(0, 10, 3);
        int[] dataC = createNewArray(dataA, dataB);

        printArrayData("Generated dataA: ", dataA);
        printArrayData("Generated dataB: ", dataB);
        printArrayData("Generated dataC: ", dataC);
    }

}
