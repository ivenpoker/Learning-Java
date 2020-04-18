// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 2.17 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 23/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_2;

import java.util.Scanner;

public class Exercise_2_17 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int fstInt = input.nextInt();

        System.out.print("Enter second integer: ");
        int sndInt = input.nextInt();

        System.out.print("Enter third integer: ");
        int thirdInt = input.nextInt();

        System.out.printf("Sum of three integers: %d%n", (fstInt + sndInt + thirdInt));
        System.out.printf("Average of three integers: %d%n", (fstInt + sndInt + thirdInt) / 3);
        System.out.printf("Product of three integers: %d%n", (fstInt * sndInt * thirdInt));

        int smallest = fstInt;
        if (smallest > sndInt) {
            smallest = sndInt;
        }
        if (smallest > thirdInt) {
            smallest = thirdInt;
        }

        System.out.printf("Smallest of three integers: %d%n", smallest);

        int largest = fstInt;
        if (sndInt > largest) largest = sndInt;
        if (thirdInt > largest) largest = thirdInt;

        System.out.printf("Largest of three integers: %d%n", (largest));
    }

}
