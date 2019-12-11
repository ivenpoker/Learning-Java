package LeetCode.Easy;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Determines if an integer is a palindrome or not.             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Program Source : https://leetcode.com/problems/palindrome-number/             #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

public class PalindromeNumber {

    private static boolean isPalindrome(int x) {
        String tmpVal = Integer.toString(x);
        if (tmpVal.length() == 1) {
            return true;
        }
        for (int i = 0, j = tmpVal.length()-1; i < j; i++, j--) {
            if (tmpVal.charAt(i) != tmpVal.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(123));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(1234321));
        System.out.println(isPalindrome(12301));
    }
}
