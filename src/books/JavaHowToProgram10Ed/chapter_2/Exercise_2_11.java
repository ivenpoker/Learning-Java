// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.11 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int p = 0;
        int i = 0;
        int j = 0;
        int value = 0;
        int k = 0;

        // Question a)
        // ANS: Values are modifiable
        p = i + j + k + 7;

        // Question b)
        // ANS: Values NOT modifiable (don't even have values)
        System.out.println("Variables whose values are modifiable");

        // Question c)
        // ANS: Values NOT modifiable (don't even have values)
        System.out.println("a = 5");

        // Question d)
        // ANS: Values NOT modifiable (dont't even have values)
        value = input.nextInt();

    }
}
