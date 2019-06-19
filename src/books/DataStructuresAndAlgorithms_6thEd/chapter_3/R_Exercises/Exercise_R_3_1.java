// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.1 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 15/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.R_Exercises;

import java.util.Arrays;

public class Exercise_R_3_1 {

    public static void main(String[] args) {
        int a = 12;
        int curr = 92;
        int b = 5;
        int n = 100;

        int[] randVals = new int[5];
        for (int i = 0; i < randVals.length; i++)
            randVals[i] = (a * curr + b) % n;

        System.out.printf("Array contents: %s\n", Arrays.toString(randVals));
    }
}
