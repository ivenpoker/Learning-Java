// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.13 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.util.Scanner;

public class Exercise_C_1_16 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the values of a, b and c: ");
        int aVal = input.nextInt();
        int bVal = input.nextInt();
        int cVal = input.nextInt();

        System.out.printf("Can be used in '%d + %d = %d': %s\n", aVal, bVal, cVal, (aVal + bVal) == cVal);
        System.out.printf("Can be used in '%d = %d - %d': %s\n", aVal, bVal, cVal, aVal == (bVal - cVal));
        System.out.printf("Can be used in '%d * %d = %d': %s\n", aVal, bVal, cVal, (aVal * bVal) == cVal);
    }
}
