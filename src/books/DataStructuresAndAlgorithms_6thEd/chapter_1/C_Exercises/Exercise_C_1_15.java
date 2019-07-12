// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.15 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.security.SecureRandom;

public class Exercise_C_1_15 {

    private static SecureRandom random = new SecureRandom();

    public static int findLargest(int[] data) {
        int largest = data[0];
        for (int val : data)
            if (val > largest)
                largest = val;
        return largest;
    }

    public static int findLowest(int[] data) {
        int lowest = data[0];
        for (int val : data)
            if (val < lowest)
                lowest = val;
        return lowest;
    }

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

    public static void main(String[] args) {

        int[] data = generateRandom(10, 0, 10);
        printData("Generated data: ", data);

        System.out.printf("Lowest integer : %d\n", findLowest(data));
        System.out.printf("Largest integer: %d\n", findLargest(data));


        // ####################### COMPARISION #######################################
        //      Both algorithms, from Java API and the one designed in this program
        //      will have the same time, complexity which is O(n), where 'n' is the
        //      the size of the array. That is, program execution time, is proportional
        //      to the size of the array.
        //
        //      As far as the space complexity is concerned, there might be differences.
    }
}
