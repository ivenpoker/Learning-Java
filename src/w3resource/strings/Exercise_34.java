package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds the second most frequent character in a given string.         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Exercise_34 {

    private static Map<Character, Integer> createCharAndCountMap(String mainStr) {
        SortedMap<Character, Integer> charMap = new TreeMap<>();
        for (char ch : mainStr.toCharArray()) {
            if (charMap.containsKey(ch)) {
                int oldCnt = charMap.get(ch);
                charMap.put(ch, oldCnt + 1);
            } else {
                charMap.put(ch, 1);
            }
        }
        return charMap;
    }

    private static char findCharWithHighestCount(Map<Character, Integer> someMap) {

        if (someMap.keySet().size() < 2) {
            throw new IllegalArgumentException(
                    String.format("Expected map of size > 2 but got map of size %d.", someMap.size()));
        }

        // Let first character be the max character
        char fstMaxChar = someMap.keySet().toArray(new Character[0])[0];
        char sndMaxChar = someMap.keySet().toArray(new Character[0])[1];

        for (char ch : someMap.keySet()) {
            int currCnt = someMap.get(ch);

            if (currCnt > someMap.get(fstMaxChar)) {
                sndMaxChar = fstMaxChar;
                fstMaxChar = ch;
            } else {
                if (currCnt > someMap.get(sndMaxChar)) {
                    sndMaxChar = ch;
                }
            }
        }
        return sndMaxChar;
    }

    public static void main(String[] args) {
        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);

        Map<Character, Integer> mapData = createCharAndCountMap(mainStr);
        char secondMaxChar = findCharWithHighestCount(mapData);

        System.out.printf("The second most frequent char in the string is: %c%n", secondMaxChar);
    }
}
