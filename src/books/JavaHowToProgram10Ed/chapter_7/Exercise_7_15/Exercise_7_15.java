// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 7.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 10/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_15;

public class Exercise_7_15 {

    public static void main(String[] args) {

        int[] mainData;
        if (args.length > 0)
            mainData = new int[Integer.parseInt(args[0])];
        else
            mainData = new int[10];
        System.out.printf("%s%8s%n", "Index", "Value");
        for (int i = 0; i < mainData.length; i++)
            System.out.printf("%5d%8d%n", i, mainData[i]);
    }
}
