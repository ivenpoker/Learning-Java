package w3resource.basicPartOne;

// ##############################################################################
// #                                                                            #
// #    Program Purpose: Removes all occurrences of a specified value in a      #
// #                     given array of integers and return the new length of   #
// #                     the array.                                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                  #
// #    Creation Date  : November 13, 2019                                      #
// #                                                                            #
// ##############################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_144 {

    private static Scanner scanner = new Scanner(System.in);
    private static SecureRandom random = new SecureRandom();

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0)
            throw new IllegalArgumentException("Invalid size of array. Must be > 0");
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val -> low + random.nextInt(high)).toArray();
        return newArrayData;
    }

    private static int getUserData(String inputMessage) {
        int userData = -1;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.print(inputMessage);
                userData = scanner.nextInt();
                isValid = true;

            } catch (Exception ex) {
                System.err.printf("[ERROR]: %s", ex);
            }
        }
        return userData;
    }

    private static int doTheProcessing(int[] mainData, int keyVal) {
        final int[] i = {0};
        IntStream.of(mainData).forEach(val -> {
            if (val == keyVal)
                i[0]++;
        });
        return mainData.length - i[0];
    }

    public static void main(String[] args) {

        int[] newData = randomIntegerArray(0, 50, 15);
        System.out.printf("Generated Array data: %s ---- [size: %d]\n",
                Arrays.toString(newData), newData.length);

        int userInd = getUserData("Enter integer to remove: ");
        int newLength = doTheProcessing(newData, userInd);

        System.out.printf("The length of the new array: %d\n", newLength);
    }
}
