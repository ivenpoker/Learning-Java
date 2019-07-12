// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.4 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################


package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises;

import java.util.Scanner;

public class Exercise_R_1_4 {

    public static boolean isEven(int someVal) {
        if (someVal < 0)
            someVal = Math.abs(someVal);

        while (someVal > 0)
            someVal -= 2;

        return someVal == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter integer value to check: ");
        int val = input.nextInt();

        if (Exercise_R_1_4.isEven(val)) {
            System.out.printf("The integer '%d' is EVEN\n", val);
        } else {
            System.out.printf("The integer '%d' is NOT EVEN\n", val);
        }
    }
}
