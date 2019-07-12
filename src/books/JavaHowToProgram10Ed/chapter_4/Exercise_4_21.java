// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.21 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_4;

import java.util.Scanner;

public class Exercise_4_21 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int counter = 10;
        int largest = 0;

        while (counter > 0) {
            System.out.printf("[%d left] Enter an integer: ", counter);
            int number = input.nextInt();
            if (counter-- != 10) {
                if (number > largest)
                    largest = number;
            } else {
                largest = number;
            }
        }
        System.out.printf("\nLargest of all numbers: %d\n", largest);
    }
}
