// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.28 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_28;

import java.util.Scanner;

public class Exercise_6_28 {

    private static boolean inRange(int lowerBound, int val, int upperBound) {
        return lowerBound <= val && val <= upperBound;
    }
    private static int qualityPoints(int studAvg) {
        if (inRange(90, studAvg, 100)) return 4;
        if (inRange(80, studAvg, 89)) return 3;
        if (inRange(70, studAvg, 79)) return 2;
        if (inRange(60, studAvg, 69)) return 1;
        return 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your average: ");
        int studentAverage = input.nextInt();

        System.out.printf("Your point is: %d\n", qualityPoints(studentAverage));
    }
}
