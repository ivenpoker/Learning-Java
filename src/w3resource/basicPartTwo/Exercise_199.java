package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Checks if a string follows a given pattern.                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 8, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.util.ArrayList;
import java.util.HashMap;

public class Exercise_199 {

    private static boolean followsPattern(String pattern, String str)  {
        String[] patternArr = pattern.split("");
        String[] strArr = str.split(" ");

        if (patternArr.length != strArr.length) {
            return false;
        }
        HashMap<String, ArrayList<String>> patternMap = new HashMap<>();
        for (int i = 0; i < strArr.length; i++) {

            if (!patternMap.containsKey(patternArr[i])) {
                ArrayList<String> newValue = new ArrayList<>();
                newValue.add(strArr[i]);
                patternMap.put(patternArr[i], newValue);

            } else {
                ArrayList<String> oldValues = patternMap.get(patternArr[i]);

                // Making sure all values are the same for same key
                for (String oldVal : oldValues) {
                    if (!oldVal.equals(strArr[i])) {
                        return false;
                    }
                }

                oldValues.add(strArr[i]);
                patternMap.put(patternArr[i], oldValues);
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.printf("Is the string and pattern matched ?: %s%n", followsPattern("xyyx", "red black black red"));
        System.out.printf("Is the string and pattern matched ?: %s%n", followsPattern("xyyx", "red black black green"));
        System.out.printf("Is the string and pattern matched ?: %s%n", followsPattern("xxxx", "red black black red"));
        System.out.printf("Is the string and pattern matched ?: %s%n", followsPattern("xxxx", "red red red red"));

    }
}

