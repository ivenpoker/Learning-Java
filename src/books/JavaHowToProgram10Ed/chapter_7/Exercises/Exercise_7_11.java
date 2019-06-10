// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.11 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 10/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercises;

public class Exercise_7_11 {

    public static void main(String[] args) {

        // Question a) Set the elements of integer array counts to zero

        int[] counts = new int[10];
        for (int i = 0; i < counts.length; i++)
            counts[i] = 0;

        // Question b)
        int[] bonus = new int[15];
        for (int i = 0; i < bonus.length; i++)
            bonus[i] += 1;

        // Question c)
        int[] bestScores = new int[5];
        System.out.printf("Index\tValue\n");
        for (int i = 0; i < bestScores.length; i++)
            System.out.printf("%d\t\t%d\n", i, bestScores[i]);
    }
}
