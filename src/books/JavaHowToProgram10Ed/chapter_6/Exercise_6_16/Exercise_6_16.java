// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.16 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 07/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_16;

import java.util.Scanner;

public class Exercise_6_16 {

    private static boolean isMultiple(int valA, int valB) {
        return valA % valB == 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter two numbers to validate [0 0 to stop]: ");
        int valA = input.nextInt();
        int valB = input.nextInt();

        while (valA != 0 && valB != 0) {
            System.out.printf("Is %d a multiple of %d: %s\n",
                    valA, valB, isMultiple(valA, valB) ? "YES" : "NO");
            System.out.print("Enter two numbers to validate [0 0 to stop]: ");
            valA = input.nextInt();
            valB = input.nextInt();
        }

    }
}
