// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.38 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 29/05/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_38;

import java.util.Scanner;

public class Exercise_4_38 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter digit to encrypt: ");
        int digit = input.nextInt();

        while (!Digits.isNDigit(digit, 4)) {
            System.out.print("Enter a FOUR digit to encrypt: ");
            digit = input.nextInt();
        }
        int encrypt = FourDigitEncryption.encrypt(digit);
        System.out.printf("Encrypted digit: %d\n", encrypt);
        System.out.printf("Decrypted digit: %d\n", FourDigitEncryption.decrypt(encrypt));
    }
}
