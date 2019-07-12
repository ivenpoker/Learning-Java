// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.9 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises;

import java.util.Scanner;

public class Exercise_R_1_9 {

    public static String removeAllPunctuations(String someString) {
        String punctuations = ",!.'";
        StringBuilder newStr = new StringBuilder();

        for (char ch : someString.toCharArray())
            if (!(punctuations.indexOf(ch) >= 0))
                newStr.append(ch);
        return newStr.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter your string: ");
        String userStr = input.nextLine();

        System.out.printf("After removing punctuations: %s\n",
                Exercise_R_1_9.removeAllPunctuations(userStr));
    }
}
