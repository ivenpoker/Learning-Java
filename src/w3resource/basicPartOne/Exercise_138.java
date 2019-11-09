package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Find all of the longest word in a given dictionary.                             #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : November 9, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

public class Exercise_138 {

    private static List<String> findAllTheLongestWords(String mainData) {
        if (mainData.length() == 0)
            return null;

        String[] words = mainData.split(" ");
        List<String> listData = new LinkedList<>();

        for (String word : words) {
            if (word.trim().length() > 0) {
                listData.add(word.trim());
            }
        }
        listData.sort(Collections.reverseOrder());
        int bigStrLen = listData.get(0).length();

        List<String> finalList = new LinkedList<>();
        for (String data : listData) {
            if (data.length() > bigStrLen) {
                bigStrLen = data.length();
                finalList.clear();
            }
            if (data.length() == bigStrLen)
                finalList.add(data);
        }
        return finalList;
    }

    public static void main(String[] args) {
        String mainText = "Lorem ipsum, or lipsum as it is sometimes known, is dummy text used in laying out print, " +
                "graphic or web designs. The passage is attributed to an unknown typesetter in the 15th century who " +
                "is thought to have scrambled parts of Cicero's De Finibus Bonorum et Malorum for use in a type" +
                " specimen book. It usually begins with:";
        List<String> newData = findAllTheLongestWords(mainText);
        System.out.printf("Result: %s\n", newData);
    }

}
