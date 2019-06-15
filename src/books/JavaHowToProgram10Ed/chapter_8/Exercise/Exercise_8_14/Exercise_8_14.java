// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_14;

public class Exercise_8_14 {

    public static void main(String[] args) {
        Date date1 = new Date(12, 14, 2019);
        Date date2 = new Date("February", 13, 2018);
        Date date3 = new Date(32, 2019);

        System.out.printf("Date 1: %s\n", date1);
        System.out.printf("Date 2: %s\n", date2);
        System.out.printf("Date 3: %s\n", date3);
    }
}
