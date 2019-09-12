package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Prints odd numbers within a range.                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 12, 2019                                               #
// #                                                                                      #
// ########################################################################################

public class Exercise_49 {

    private static void printOddNumbersInRangeInclusively(int low, int high) {
        for (int i = low; i <= high; i++)
            if (i % 2 != 0)
                System.out.printf("%d\n", i);
    }

    public static void main(String[] args) {
        printOddNumbersInRangeInclusively(1, 99);
    }
}
