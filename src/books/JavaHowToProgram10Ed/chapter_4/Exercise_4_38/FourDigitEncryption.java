// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.38 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_38;

public class FourDigitEncryption {

    public static int encrypt(int digits) {
        int last = digits % 10;
        digits /= 10;
        int third = digits % 10;
        digits /= 10;
        int second = digits % 10;
        int first  = digits /= 10;

        first  = (first + 7) % 10;
        second = (second + 7) % 10;
        third  = (third + 7) % 10;
        last   = (last + 7) % 10;

        int tmp = first;
        first = third;
        third = tmp;

        // swap second and last
        tmp = second;
        second = last;
        last = tmp;

        String intStr = String.format("%d%d%d%d", first, second, third, last);
        int encyptedDigit = Integer.parseInt(intStr);

        if (encyptedDigit < 1000)
            encyptedDigit *= 10;
        return encyptedDigit;
    }

    public static int decrypt(int digits) {
        int last = digits % 10;
        digits /= 10;
        int third = digits % 10;
        digits /= 10;
        int second = digits % 10;
        int first  = digits /= 10;

        // let swap back first and third
        int tmp = first;
        first = third;
        third = tmp;

        // let swap back second and fourth
        tmp = second;
        second = last;
        last = tmp;

        first = (first + 10) % 7;
        second = (second + 10) % 7;
        third  = (third + 10) % 7;
        last   = (last + 10) % 7;

        String intStr = String.format("%d%d%d%d", first, second, third, last);
        int decryptedDigit = Integer.parseInt(intStr);

        if (last == 0)
            decryptedDigit += 7;
        return decryptedDigit;
    }


}
