// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.3 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises;

import java.util.Scanner;

public class Exercise_R_1_3 {

    public static boolean isMultiple(int nVal, int mVal) {
        return nVal % mVal == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter values of n and m: ");
        int nVal = input.nextInt();
        int mVal = input.nextInt();

        if (Exercise_R_1_3.isMultiple(nVal, mVal)) {
            System.out.printf("%d is a multiple of %d\n", nVal, mVal);
        } else {
            System.out.printf("%d is NOT a multiple of %d\n", nVal, mVal);
        }

    }
}
