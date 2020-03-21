package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Given two non-negative integers num1 and num2 represented as string, #
// #                     return the sum of num1 and num2.                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : March 21, 2020                                                       #
// #                                                                                          #
// ############################################################################################

public class Exercise_189 {

    private static int addTwoStrings(String str1, String str2) {
        return Integer.parseInt(str1) + Integer.parseInt(str2);
    }


    public static void main(String[] args) {
        System.out.printf("Test case: %d\n", addTwoStrings("12", "12"));
        System.out.printf("Test case: %d\n", addTwoStrings("0", "130"));
        System.out.printf("Test case: %d\n", addTwoStrings("-12", "+12"));
        System.out.printf("Test case: %d\n", addTwoStrings("2", "8943"));
        System.out.printf("Test case: %d\n", addTwoStrings("1", "-8923"));
    }
}
