// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.17 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.security.SecureRandom;

public class Exercise_C_1_17 {

    private static SecureRandom random = new SecureRandom();

    public static int[] generateRandom(int size, int low, int high) {
        int[] data = new int[size];
        for (int i = 0; i < data.length; i++)
            data[i] = low + random.nextInt(high);
        return data;
    }

    public static void printData(String mess, int[] data) {
        System.out.print(mess);
        int i = 0;
        for (int val : data)
            System.out.printf("%d%s", val, (i++ == data.length-1 ? "\n" : " "));
    }

    public static boolean isProductOfTwoElementsEvenAndDistinct(int[] data) {
        for (int i = 0; i < data.length; i++)
            for (int j = i+1; j < data.length; j++)
                if (isEven(data[i] * data[j]))
                    return true;
        return false;
    }

    public static boolean isEven(int someInt) {
        return someInt % 2 == 0;
    }

    public static void main(String[] args) {

        int[] data = generateRandom(10, 0, 20);
        printData("Generated data: ", data);
        System.out.printf("Is there any even product: %s\n",
                isProductOfTwoElementsEvenAndDistinct(data));
    }
}
