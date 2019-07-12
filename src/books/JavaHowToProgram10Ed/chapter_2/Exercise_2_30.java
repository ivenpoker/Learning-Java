// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.30 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_30 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a five digit number: ");
        int digit = input.nextInt();

        int fstDigit = digit / 10000;
        int sndDigit = (digit / 1000) % 10;
        int thdDigit = (digit / 100) % 10;
        int frthDigit = (digit / 10) % 10;
        int fifthDigit = digit % 10;

        System.out.printf("%d %d %d %d %d", fstDigit, sndDigit, thdDigit, frthDigit, fifthDigit);
    }
}
