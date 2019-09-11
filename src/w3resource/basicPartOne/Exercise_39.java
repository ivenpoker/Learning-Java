package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Create and display unique three-digit number of certain size.    #
// #                     Also count how many three-digit numbers are there.               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 11, 2019                                               #
// #                                                                                      #
// ########################################################################################

import java.util.LinkedList;
import java.util.List;

public class Exercise_39 {

    private static List<String> threeDigitCombination(int maxSize) {
        List<String> data = new LinkedList<>();
        System.out.println("\nProcessing....\n");

        for (int i = 1; i <= maxSize; i++) {
            for (int j = 1; j <= maxSize; j++) {
                for (int k = 1; k <= maxSize; k++) {
                    if (k != i && k != j && i != j) {
                        System.out.printf("Found '%d%d%d'\n", i, j, k);
                        data.add(String.format("%d%d%d", i, j, k));
                    }
                }
            }
        }
        return data;
    }

    public static void main(String[] args) {
        List<String> newData = threeDigitCombination(4);
        System.out.println();
        for (int i = 1; i <= newData.size(); i++) {
            System.out.printf("Combination #%02d: %s\n", i, newData.get(i-1));
        }
        System.out.printf("\nTotal number of the three-digit-number is: %d\n", newData.size());
    }
}