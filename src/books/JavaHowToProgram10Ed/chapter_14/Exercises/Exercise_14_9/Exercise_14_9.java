package books.JavaHowToProgram10Ed.chapter_14.Exercises.Exercise_14_9;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.9 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 6, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;

public class Exercise_14_9 {

    private static String [] cleanSentence(String [] tokens) {

        StringBuilder sb = new StringBuilder();
        for (String token : tokens) {
            if (token.trim().length() != 0)
                sb.append(token).append(" ");
        }
        return sb.toString().trim().split(" ");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String someSentence = input.nextLine();

        String[] tokenizedSentence = someSentence.split(" ");

        // Now lets make sure not token has trailing spaces
        tokenizedSentence = cleanSentence(tokenizedSentence);

        // Now lets print the string in reverse
        System.out.print("Reverse of sentence: ");
        for (int i = tokenizedSentence.length-1; i >= 0; i--)
            System.out.printf("%s%s", tokenizedSentence[i], (i == 0 ? "\n" : " "));

    }
}
