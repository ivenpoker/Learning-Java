package w3resource.basicPartOne;

import java.security.SecureRandom;

// #################################################################################################
// #                                                                                               #
// #    Program Purpose: Checks if 2 or 4 is found in an array of size 2.                          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                     #
// #    Creation Date  : September 20, 2019                                                        #
// #                                                                                               #
// #################################################################################################

public class Exercise_78 {

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

    private static boolean checkContainment(int[] data) {
        for (int datum : data)
            if (datum == 2 || datum == 4)
                return true;
        return false;
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 2);
        printArrayData("Generated array: ", newData);
        System.out.printf("Array has 2 or 4: %s\n",
                checkContainment(newData) ? "YES" : "NO");
    }
}
