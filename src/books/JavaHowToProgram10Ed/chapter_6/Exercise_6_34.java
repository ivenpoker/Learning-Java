// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.34 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 09/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6;

public class Exercise_6_34 {

    private static final int maxTableSize = 256;

    public static void main(String[] args) {
        displayNumberSystems();
    }

    private static void displayNumberSystems() {
        System.out.printf("%s\t%s\t%s\t%s\n", "Number", "Binary", "Octal", "Hexadecimal");
        for (int i = 1; i <= Exercise_6_34.maxTableSize; i++)
            System.out.printf("%d\t%9d\t%5d\t%5s\n", i, Integer.parseInt(Integer.toBinaryString(i)),
                    Integer.parseInt(Integer.toOctalString(i)), Integer.toHexString(i));
    }
}
