package w3resource.basicPartTwo;

// ############################################################################################
// #                                                                                          #
// #    Program Purpose: Rearranges the alphabets in the order followed by the sum of digits  #
// #                     in a given string containing uppercase and integer digits (from 0 to #
// #                     9.                                                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                #
// #    Creation Date  : May 28, 2020                                                         #
// #                                                                                          #
// ############################################################################################

import java.util.Arrays;

public class Exercise_192 {

    private static String rearrangeAlphabet(String someStr) {
        someStr = someStr.toUpperCase();
        StringBuilder strSb = new StringBuilder();
        int tmpSum = 0;

        for (char ch : someStr.toCharArray()) {
            if (Character.isDigit(ch)) {
                tmpSum += Integer.parseInt(Character.toString(ch));
            } else {
                strSb.append(ch);
            }
        }
        char[] charArr = strSb.toString().toCharArray();
        Arrays.sort(charArr);
        String newStr = new String(charArr);
        return String.format("%s%d", newStr, tmpSum);
    }

    public static void main(String[] args) {

        String str1 = "AND456HSE8";
        String rearranged = rearrangeAlphabet(str1);
        System.out.printf("Re-arranged string: %s%n",rearranged);

    }
}
