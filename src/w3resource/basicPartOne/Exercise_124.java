package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Finds the index of a value in sorted array. If the value does not find return   #
// #                     the index, where it would be if it were inserted in order.                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 26, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.util.Arrays;
import java.util.stream.IntStream;
import java.security.SecureRandom;

public class Exercise_124 {

    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newData = new int[size];
        newData = IntStream.of(newData).map(val -> low + random.nextInt() % high).toArray();
        return newData;
    }

    private static void displayArrayData(String message, int[] data) {
        System.out.print(message);
        final int[] i = {0};
        System.out.print("[");
        IntStream.of(data).forEach(val -> System.out.printf("%2d%s", val,
                (i[0]++ == data.length-1) ? "": ", "));
        System.out.print("]\n");
    }

    public static void main(String[] args) {
        int[] mainData = randomIntegerArray(0, 10, 10);
        displayArrayData("Generated data: ", mainData);

        Arrays.sort(mainData);

        System.out.println();

        // lets do 5 trials
        for (int i = 0; i < 5; i++) {
            int randInd = random.nextInt(15);
            System.out.printf("Testing '2%d' in '%s': %d (index)\n",
                    randInd, Arrays.toString(mainData), Arrays.binarySearch(mainData, randInd));
        }

    }
}
