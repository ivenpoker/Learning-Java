// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 5.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_5;

public class Exercise_5_15 {

    public static void main(String[] args) {
        int maxLines = 10;

        // Printing the first pattern.
        System.out.println("============[ Pattern A ]==============\n");
        for (int i = 0; i < maxLines; i++) {
            for (int j = i+1; j > 0; j--)
                System.out.print('*');
            System.out.println();
        }

        // Printing the second pattern
        System.out.println("\n============[ Pattern B ]==============\n");
        for (int i = 0; i < maxLines; i++) {
            for (int j = maxLines-i; j > 0; j--)
                System.out.print('*');
            System.out.println();
        }

        // Printing the third pattern
        System.out.println("\n============[ Pattern C ]==============\n");
        for (int i = 0; i < maxLines; i++) {
            for (int k = i; k > 0; k--)
                System.out.print(' ');
            for (int k = maxLines-i; k > 0; k--)
                System.out.print('*');
            System.out.println();
        }

        // Printing the fourth pattern
        System.out.println("\n============[ Pattern D ]==============\n");
        for (int i = 0; i < maxLines; i++) {
            for (int k = maxLines-i; k > 0; k--)
                System.out.print(' ');
            for (int k = i+1; k > 0; k--)
                System.out.print('*');
            System.out.println();
        }
    }
}
