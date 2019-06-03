// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise C.1.22 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 3/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.C_Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise_C_1_22 {

    public static void printAndDisplayAllCombinations(String someStr) {
        List<Character> strList = new ArrayList<>();
        for (Character ch : someStr.toCharArray())
            strList.add(ch);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("Enter string to find possible combinations: ");
        String someStr = input.next().trim();

    }
}
