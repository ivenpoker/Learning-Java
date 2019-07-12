// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise R.1.8 in Book                  #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.R_Exercises;

import java.util.Scanner;

public class Exercise_R_1_8 {

    public static long countVowels(String someString) {
        String vowels = "aeiou";
        int cnt = 0;
        for (char ch : someString.toCharArray())
            if (vowels.indexOf(ch) >= 0)
                cnt++;
        return cnt;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter some string: ");
        String userStr = input.nextLine();

        System.out.printf("Number of vowels in string: %d\n",
                Exercise_R_1_8.countVowels(userStr));
    }
}
