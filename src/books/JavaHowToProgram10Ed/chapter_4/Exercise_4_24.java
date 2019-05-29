// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.24 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

import java.util.Scanner;

public class Exercise_4_24 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int passes = 0;
        int failures = 0;
        int studentCounter = 1;

        while (studentCounter <= 10) {
            System.out.printf("Enter result (1 = pass, 2 = fail): ");
            int result = input.nextInt();
            if (result == 1) {
                passes = passes + 1;
                studentCounter = studentCounter + 1;
            } else if (result == 2) {
                failures = failures + 1;
                studentCounter = studentCounter + 1;
            }
        }
        System.out.printf("Passed: %d%nFailed: %d%n", passes, failures);
        if (passes > 8)
            System.out.println("Bonus to instructor!");
    }
}
