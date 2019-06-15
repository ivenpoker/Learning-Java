// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.8 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_8;

public class Exercise_8_8 {

    public static void main(String[] args) {
        Date date1 = new Date(3, 31, 2019);
        Date date2 = new Date(12, 25, 2019);

        System.out.printf("Date 1: %s\n", date1);
        System.out.printf("Date 2: %s\n", date2);

        // Increment date 1 by a day, (moving to the next month)
        date1.nextDay();

        // Increment date 2 by 7 days, moving to the next year)
        for (int i = 0; i < 7; i++)
            date2.nextDay();

        System.out.println();

        System.out.printf("Date 1: %s\n", date1);
        System.out.printf("Date 2: %s\n", date2);
    }
}
