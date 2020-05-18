// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 10/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_12;

import java.util.Scanner;

public class Exercise_7_12 {

    public static boolean isFound(int[] someData, int key) {
        for (int data : someData)
            if (data == key)
                return true;
        return false;
    }

    public static boolean inRange(int low, int val, int upper) {
        return (low <= (val) && (val) <= upper);
    }

    public static void main(String[] args) {
        int[] mainData = new int[5];
        Scanner input = new Scanner(System.in);

        int i = 0;
        while (i < mainData.length){
            System.out.printf("Enter some integer between 10 and 100: ");
            int userVal = input.nextInt();
            while (!inRange(10, userVal, 100)) {
                System.out.printf("Enter some integer BETWEEN 10 and 100: ");
                userVal = input.nextInt();
            }
            if (!isFound(mainData, userVal))
                mainData[i++] = userVal;
            System.out.print("Data: ");
            for (int data : mainData)
                System.out.printf("%d ", data);
            System.out.println();
        }

    }
}
