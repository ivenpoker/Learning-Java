// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise 5.24 in Book                   #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 5/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.JavaHowToProgram10Ed.chapter_5.Exercise_5_24;

public class Exercise_5_24 {

    public static void printStars(int size) {
        int tmpSize = size;
        for (int i = 0, k = 1; i < size/2; i++, k += 2) {
            for (int j = 0; j < tmpSize/2; j++)
                System.out.print(' ');
            for (int m = 0; m < k; m++)
                System.out.print('*');
            for (int j = 0; j < tmpSize/2; j++)
                System.out.print(' ');
            System.out.println();
            tmpSize -= 2;
        }
        tmpSize = size;
        for (int i = 0; i < size; i++)
            System.out.print('*');
        System.out.println();

        for (int i = 0, k = tmpSize-2; i < size/2; i++, k -= 2) {
            for (int j = 0; j < i+1; j++)
                System.out.print(' ');
            for (int m = 0; m < k; m++)
                System.out.print('*');
            for (int j = 0; j < i+1; j++)
                System.out.print(' ');
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printStars(9);
    }
}
