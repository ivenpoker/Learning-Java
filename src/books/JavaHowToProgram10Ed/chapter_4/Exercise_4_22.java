// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.22 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4;

public class Exercise_4_22 {

    public static void main(String[] args) {
        int maxN = 1;

        System.out.print("N\t10*N\t100*N\t1000*N\n\n");
        while (maxN <= 5) {
            System.out.printf("%d\t%d\t\t%d\t\t%d\n", maxN, 10*maxN, 100*maxN, 1000*maxN);
            maxN++;
        }
    }
}
