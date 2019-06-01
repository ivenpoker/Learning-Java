// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.7 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises;

import java.util.Scanner;

public class Exercise_R_1_7 {

    public static long computeSumOfSquares(int someVal) {
        int sum = 0;
        for (int i = 0; i <= someVal; i++)
            sum += Math.pow(i, 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter max integer: ");
        int val = input.nextInt();

        System.out.printf("Sum of all squares of integers <= %d: %d",
                val, Exercise_R_1_7.computeSumOfSquares(val));
    }
}
