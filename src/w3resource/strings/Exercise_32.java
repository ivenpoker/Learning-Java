package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the longest Palindromic Substring within a string.            #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Exercise_32 {

    private static String findLongestPalindromeSubString(String mainStr) {
        List<String> palindromeList = new ArrayList<>();

        for (int i = 0, length = mainStr.length(); i < length; i++) {
            for (int j = i+1; j < length; j++) {
                String subStr = mainStr.substring(i, j);
                StringBuilder sb = new StringBuilder(subStr);

                // is string a palindrome
                if (subStr.equals(sb.reverse().toString())) {
                    palindromeList.add(subStr);
                }
            }
        }
        if (!palindromeList.isEmpty()) {
            Collections.sort(palindromeList, Comparator.comparingInt(String::length));
            return palindromeList.get(palindromeList.size()-1);
        }
        return null;
    }

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter your main string: ", true);

        String longestPalindrome = findLongestPalindromeSubString(mainStr);

        if (Objects.nonNull(longestPalindrome)) {
            System.out.printf("Longest palindrome: %s%n", longestPalindrome);
            System.out.printf("Length of the palindromic substring is: %d%n", longestPalindrome.length());
        } else {
            System.out.printf("[NO PALINDROME FOUND]%n");
        }
    }

}
