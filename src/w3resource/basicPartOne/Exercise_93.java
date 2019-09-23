package w3resource.basicPartOne;

// ##################################################################################################
// #                                                                                                #
// #    Program Purpose: Tests if any array of integers contains an element 10 next to 10 or an     #
// #                     element 20 next to 20, but not both.                                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                      #
// #    Creation Date  : September 20, 2019                                                         #
// #                                                                                                #
// ##################################################################################################

import java.security.SecureRandom;

public class Exercise_93 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size <= 0)
            throw new IllegalArgumentException("Invalid array size. Must be > 0");
        int[] newData = new int[size];
        for (int i = 0; i < newData.length; i++)
            newData[i] = low + random.nextInt(high);
        return newData;
    }

    private static boolean checkNextInteger(int[] data, int val, int next) {
        for (int i = 0; i < data.length; i++)
            if (data[i] == val && i <= data.length-2)
                if (data[i+1] == next)
                    return true;
        return false;
    }

    private static void printArrayData(String mess, int[] data) {
        System.out.print(mess);
        for (int i = 0; i < data.length; i++)
            System.out.printf("%d%s", data[i], i == data.length-1 ? "": " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(0, 10, 10);
        printArrayData("Generated data: ", newData);

        if (checkNextInteger(newData, 10, 10) && !checkNextInteger(newData, 20, 20)) {
            System.out.println("Generated data PASSES the condition");
        } else {
            System.out.println("Generated data does NOT PASS the condition");
        }

        int[] dataA = {1, 10, 10, 2, 4, 5, 9};
        int[] dataB = {1, 3, 4, 20, 10, 20, 20};

        System.out.printf("Does dataA passes condition: %s\n",
                checkNextInteger(dataA, 10, 10) && !checkNextInteger(dataA, 20, 20) ? "YES" : "NO");
        System.out.printf("Does dataB passes condition: %s\n",
                checkNextInteger(dataB, 20, 20) && !checkNextInteger(dataB, 10, 10)? "YES" : "NO");


    }
}
