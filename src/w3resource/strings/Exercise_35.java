package w3resource.strings;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Finds all permutations of a string without repetition.              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : November 23, 2020                                                   #
// #                                                                                         #
// ###########################################################################################

import w3resource.utils.BasicUtils;

import java.util.ArrayList;
import java.util.List;

public class Exercise_35 {

    void permuteChar(char[] mainArray, List<String> store, int l, int r) {
        if (l == r) {
            StringBuilder sb = new StringBuilder();
            for (char ch : mainArray) {
                sb.append(ch);
            }
            store.add(sb.toString());
        } else {
            // Permutation made
            for (int i = l; i <= r; i++) {
                //swapping done
                swapChar(mainArray, l, i);

                // Recursion called
                permuteChar(mainArray, store, l+1, r);

                // backtrack
                swapChar(mainArray, l, i);
            }
        }
    }

    void swapChar(char[] charsSource, int fst, int snd) {
        char tmp = charsSource[fst];
        charsSource[fst] = charsSource[snd];
        charsSource[snd] = tmp;
    }

    public static void main(String[] args) {

        String mainStr = BasicUtils.readUserInputString("Enter main string: ", true);
        List<String> allPermutations = new ArrayList<>();

        (new Exercise_35()).permuteChar(mainStr.toCharArray(), allPermutations, 0, mainStr.length()-1);

        System.out.printf("%nAll permutations:%n");
        for (int i = 0, size = allPermutations.size(); i < size; i++) {
            System.out.printf("%2d: %s%n", i+1, allPermutations.get(i));
        }
    }

}
