// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.24 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_24 {

    public static void main(String[] args) {
        int fstInt = 0;
        int sndInt = 0;
        int thdInt = 0;
        int fourthInt = 0;
        int fifthInt = 0;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter integer 1: ");
        fstInt = input.nextInt();

        System.out.print("Enter integer 2: ");
        sndInt = input.nextInt();

        System.out.print("Enter integer 3: ");
        thdInt = input.nextInt();

        System.out.print("Enter integer 4: ");
        fourthInt = input.nextInt();

        System.out.print("Enter integer 5: ");
        fifthInt = input.nextInt();

        int largest = fstInt;

        if (largest < sndInt) largest = sndInt;
        if (largest < thdInt) largest = sndInt;
        if (largest < fourthInt) largest = fourthInt;
        if (largest < fifthInt) largest = fifthInt;

        int smallest = fstInt;

        if (smallest > sndInt) smallest = sndInt;
        if (smallest > thdInt) smallest = thdInt;
        if (smallest > fourthInt) smallest = fourthInt;
        if (smallest > fifthInt) smallest = fifthInt;

        System.out.printf("\nLargest integer: %d\nSmallest integer: %d\n",
                largest, smallest);

    }
}
