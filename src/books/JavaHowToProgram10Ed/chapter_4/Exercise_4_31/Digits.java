// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.31 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_31;

public class Digits {

    public static boolean isBinaryNumber(int _binaryNumber) {
        if (_binaryNumber < 0) return false;
        boolean isValid = true;

        while (_binaryNumber > 0) {
            int tmp = _binaryNumber % 10;
            if (tmp != 1 && tmp != 0) {
                isValid = false;
                break;
            }
            _binaryNumber /= 10;
        }
        return isValid;
    }

    public static int digitCount(int _someNumber) {
        int cnt = 0;
        while (_someNumber > 0) {
            _someNumber /= 10;
            cnt++;
        }
        return cnt;
    }
}
