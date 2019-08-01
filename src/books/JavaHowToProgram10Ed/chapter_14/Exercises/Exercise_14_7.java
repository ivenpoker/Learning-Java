package books.JavaHowToProgram10Ed.chapter_14.Exercises;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the Exercise 14.7 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : August 1, 2019                                             #
// #                                                                                  #
// ####################################################################################

import java.util.Scanner;


public class Exercise_14_7 {

    public static String getUserInput() {
        Scanner input = new Scanner(System.in);
        System.out.printf("Enter some sentence: ");
        return input.nextLine().trim();
    }

    public static String convertToPigLatin(String someString) {
        String[] tokens = someString.split(" ");

        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].trim();
            tokens[i] = tokens[i].substring(1) + tokens[i].charAt(0) + "ay";
        }

        StringBuilder tmpStr = new StringBuilder(tokens[0]).append(" ");
        for (int i = 1; i < tokens.length; i++)
            tmpStr.append(tokens[i]).append(" ");
        String finalString = tmpStr.toString().trim();

        return finalString + ".";
    }

    public static void printLatinWork(String someString, String latinEquivalent) {
        System.out.printf("Original string: %s\nLatin equivalent: %s\n", someString, latinEquivalent);
    }

    public static void main(String[] args) {
        String userString = getUserInput();
        String userStringInPigLatin = convertToPigLatin(userString);

        printLatinWork(userString, userStringInPigLatin);
    }


}
