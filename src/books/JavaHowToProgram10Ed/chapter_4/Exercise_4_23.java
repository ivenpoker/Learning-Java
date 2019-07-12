// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.23 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_4;

import java.util.Scanner;

public class Exercise_4_23 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxCnt = 10;
        int largestInt = 0;
        int sndLargestInt = 0;

        while (maxCnt > 0) {
            System.out.printf("Enter a number [%d left]: ", maxCnt);
            int numb = input.nextInt();

            if (maxCnt-- == 10) {
                largestInt = sndLargestInt = numb;
            } else {
                if (numb > largestInt) {
                    sndLargestInt = largestInt;
                    largestInt = numb;
                } else {
                    if (numb > sndLargestInt)
                        sndLargestInt = numb;
                }
            }
        }

        System.out.printf("\nLargest number: %d\n", largestInt);
        System.out.printf("Second largest number: %d\n", sndLargestInt);
    }
}
