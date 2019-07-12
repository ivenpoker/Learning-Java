// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.32 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_32 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter five numbers: ");
        int int1 = input.nextInt();
        int int2 = input.nextInt();
        int int3 = input.nextInt();
        int int4 = input.nextInt();
        int int5 = input.nextInt();

        int numOfZeroes    = 0;
        int numOfPositives = 0;
        int numOfNegatives = 0;

        if (int1 > 0) numOfPositives = numOfPositives + 1;
        if (int1 < 0) numOfNegatives = numOfNegatives + 1;
        if (int1 == 0) numOfZeroes = numOfZeroes + 1;

        if (int2 > 0) numOfPositives = numOfPositives + 1;
        if (int2 < 0) numOfNegatives = numOfNegatives + 1;
        if (int2 == 0) numOfZeroes = numOfZeroes + 1;

        if (int3 > 0) numOfPositives = numOfPositives + 1;
        if (int3 < 0) numOfNegatives = numOfNegatives + 1;
        if (int3 == 0) numOfZeroes = numOfZeroes + 1;

        if (int4 > 0) numOfPositives = numOfPositives + 1;
        if (int4 < 0) numOfNegatives = numOfNegatives + 1;
        if (int4 == 0) numOfZeroes = numOfZeroes + 1;

        if (int5 > 0) numOfPositives = numOfPositives + 1;
        if (int5 < 0) numOfNegatives = numOfNegatives + 1;
        if (int5 == 0) numOfZeroes = numOfZeroes + 1;

        System.out.printf("Number of positives: %d\nNumber of negatives: %d\n" +
                "Number of zeroes: %d\n", numOfPositives, numOfNegatives, numOfZeroes);
    }
}
