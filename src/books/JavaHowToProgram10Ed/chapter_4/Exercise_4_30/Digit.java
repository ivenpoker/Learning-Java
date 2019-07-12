// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.30 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_30;

public class Digit {

    public static boolean isNdigits(int _someNumber, int _digits) {
        int tmp = 0;
        while (_someNumber != 0) {
            _someNumber /= 10;
            tmp++;
        }
        return tmp == _digits;
    }
}
