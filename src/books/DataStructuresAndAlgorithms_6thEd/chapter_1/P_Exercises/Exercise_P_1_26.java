// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise P.1.26 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.P_Exercises;

import java.util.Scanner;

public class Exercise_P_1_26 {

    public static void readInputPrintInReverse() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter lines of strings [CTRL-D or CTRL-Z to stop input]");

        StringBuilder userStr = new StringBuilder();
        while (input.hasNextLine()) {
            userStr.append(String.format("%s\n", input.nextLine()));
        }
        String[] individualLines = userStr.toString().split("\n");

        System.out.println("Lines entered in reverse:\n");
        for (int i = individualLines.length-1; i >= 0; i--)
            System.out.printf("%s\n", individualLines[i]);

    }

    public static void main(String[] args) {
        readInputPrintInReverse();
    }

}
