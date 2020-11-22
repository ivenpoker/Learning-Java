package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Creates a new String object with the contents of a character array. #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 22, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import java.util.Arrays;

public class Exercise_11 {

    public static void main(String[] args) {
        char[] testArray = {'J', 'a', 'v', 'a', ' ', 'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'i', 'n', 'g'};
        System.out.printf("Test Array: %s%n", Arrays.toString(testArray));

        String testData = String.copyValueOf(testArray, 0, testArray.length);

        System.out.printf("String version of array: %s%n", testData);
    }

}
