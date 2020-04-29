// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_16;

import java.util.Scanner;

public class Exercise_5_16 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int fstVal = 0;
        int sndVal = 0;
        int thdVal = 0;
        int fourthVal = 0;
        int fifthVal = 0;

        System.out.print("Enter five integers in [1, 30]: ");
        fstVal = input.nextInt();

        while (fstVal < 1 || fstVal > 30) {
            System.out.print("Enter VALID first integer in [1, 30]: ");
            fstVal = input.nextInt();
        }
        sndVal = input.nextInt();
        while (sndVal < 1 || sndVal > 30) {
            System.out.print("Enter VALID second integer in [1, 30]: ");
            sndVal = input.nextInt();
        }
        thdVal = input.nextInt();
        while (thdVal < 1 || thdVal > 30) {
            System.out.print("Enter VALID third integer in [1, 30]: ");
            thdVal = input.nextInt();
        }
        fourthVal = input.nextInt();
        while (fourthVal < 1 || fourthVal > 30) {
            System.out.print("Enter VALID fourth integer in [1, 30]: ");
            fourthVal = input.nextInt();
        }
        fifthVal = input.nextInt();
        while (fifthVal < 1 || fifthVal > 30) {
            System.out.print("Enter VALID third integer in [1, 30]: ");
            fifthVal = input.nextInt();
        }

        // Displaying chart
        printBarChart(fstVal);
        printBarChart(sndVal);
        printBarChart(thdVal);
        printBarChart(fourthVal);
        printBarChart(fifthVal);
    }


    public static void printBarChart(int val) {
        System.out.printf("%02d: ", val);
        for (int i = 0; i < val; i++)
            System.out.print('*');
        System.out.println();
    }
}
