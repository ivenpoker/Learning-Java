package w3resource.basicPartTwo;


// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Moves every +ve number to the right and every -ve number to  #
// #                     the left of a given array of integers.                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise_165 {

    private static SecureRandom random = new SecureRandom();
    private static Scanner scanner = new Scanner(System.in);

    private static int[] randomIntegerArray(int low, int high, int size) {
        if (size < 0) {
            throw new IllegalArgumentException(String.format("Invalid specified " +
                    "size (%d) for new array data.", size));
        }
        int[] newArrayData = new int[size];
        newArrayData = IntStream.of(newArrayData).map(val ->
                                low + random.nextInt(high+1)).toArray();
        return newArrayData;
    }

    private static void magnitudeMovement(int[] someData) {

        // Using the 'Selection Sort' algorithm

        for (int i = 0; i < someData.length; i++) {
            for (int j = 0; j < someData.length; j++) {
                if (someData[i] < someData[j]) {
                    int temp = someData[i];
                    someData[i] = someData[j];
                    someData[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] newData = randomIntegerArray(-5, 20, 15);
        System.out.printf("Random array data: %s\n", Arrays.toString(newData));

        // Make the +ve and -ve movements
        magnitudeMovement(newData);

        System.out.printf("After moving data contents: %s\n", Arrays.toString(newData));
    }
}
