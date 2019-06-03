// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise P.1.26 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.P_Exercises;

import java.security.SecureRandom;

public class Exercise_P_1_27 {

    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private static SecureRandom random = new SecureRandom();

    /**
     * Generates <code>mainStr</code>, <code>times</code> times. Introducing a typo from the alphabet into
     * each generated string randomly. Uses <code>avoidThis</code> to 'know' which characters to
     * avoid replacing with 'typo characters'
     *
     * @param mainStr   Main string to produce samples with typos included.
     * @param avoidThis Set of characters to avoid.
     * @param times Number of times to generate random string.
     * @param numTypos Number of typos
     */
    public static void printStringNTimes(String mainStr, String avoidThis, int times, int numTypos) {
        String tmpHold = mainStr;
        for (int i = 0; i < times; i++) {
            char[] tmpData = tmpHold.toCharArray();
            for (int j = 0; j < numTypos; j++) {
                int k = random.nextInt(tmpHold.length());
                while (avoidThis.indexOf(tmpHold.charAt(k)) >= 0)
                    k = random.nextInt(mainStr.length());
                tmpData[k] = alphabet.charAt(random.nextInt(alphabet.length()));
            }
            StringBuilder tmpStr = new StringBuilder();
            for (char ch : tmpData)
                tmpStr.append(ch);
            System.out.printf("String #%02d: %s\n", i+1, tmpStr.toString());
            tmpHold = mainStr;
        }
    }

    public static void main(String[] args) {
        String mainData = "I will never spam my friends again.";
        printStringNTimes(mainData, ". ", 10, 5);

    }
}
