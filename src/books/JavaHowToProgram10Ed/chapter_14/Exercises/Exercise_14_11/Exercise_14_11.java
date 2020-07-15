package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_11;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.11 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 6, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_14_11 {

    private static int findCharOccurrencesInString(String someString, char ch) {
        int cnt = 0;
        for (int i = 0; i < someString.length(); i++) {
            int ind = someString.indexOf(ch);
            if (ind >= 0) {
                someString = someString.substring(ind+1);
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter main sentence: ");
        String sentence = input.nextLine();

        System.out.print("Enter search character: ");
        char ch = input.next().trim().charAt(0);

        System.out.printf("Character '%c' occurs %d time(s) in string", ch,
                findCharOccurrencesInString(sentence, ch));
    }
}
