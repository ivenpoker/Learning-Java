// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.11 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5;

import java.util.Scanner;

public class Exercise_5_11 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter max integer to input: ");
        int max = input.nextInt();

        while (max <= 0) {
            System.out.print("Enter max integer [> 0] to input: ");
            max = input.nextInt();
        }
        System.out.println("-----------------------------");
        int userInput = 0, cnt = 0;
        int smallestInt = 0;
        while (cnt < max) {
            System.out.printf("Enter an integer [%d left]: ", max-cnt);
            userInput = input.nextInt();
            if (cnt++ == 0) {
                smallestInt = userInput;
            } else if(userInput < smallestInt) {
                smallestInt = userInput;
            }
        }
        System.out.printf("\n-----[Smallest is: %d]------\n", smallestInt);
    }
}
