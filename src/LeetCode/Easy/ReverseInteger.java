package LeetCode.Easy;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Reverse the digits of an Integer, handles overflows.         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Program Source : https://leetcode.com/problems/reverse-integer/               #
// #    Creation Date  : December 11, 2019                                            #
// #                                                                                  #
// ####################################################################################

public class ReverseInteger {

    public static int reverse(int x) {
        boolean isNegative = x < 0;
        x = Math.abs(x);

        int newNum = 0;
        while (x != 0) {
            int tmp = x % 10;
            if (newNum == 0) {
                newNum = tmp;
            } else {
                try {
                    newNum = Math.multiplyExact(newNum, 10);
                    newNum = Math.addExact(newNum, tmp);
                } catch (ArithmeticException exc) {
                    return 0;
                }
            }
            x /= 10;
        }
        return isNegative ? -newNum : newNum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(450));
        System.out.println(reverse(-120));
        System.out.println(reverse(946));
        System.out.println(reverse(1534236469));
    }
}
