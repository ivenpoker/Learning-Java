// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R-3.14 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 19/06/2019                                          #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_3.R_Exercises;

import java.util.Arrays;

public class Exercise_R_3_14 {

    public static void main(String[] args) {
        int[] original = new int[100];             // sample 'original'

        int[] newCopyOfOriginal = Arrays.copyOf(original, original.length);

        int[] anotherCopyOfOriginal = original.clone();

        int[] yetAnotherCopy = new int[original.length];
        for (int i = 0; i < original.length; i++) yetAnotherCopy[i] = original[i];
    }
}
