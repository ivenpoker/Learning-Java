package w3resource.basicPartOne;


// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Print certain results.                                           #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 3, 2019                                                #
// #                                                                                      #
// ########################################################################################

public class Exercise_4 {

    public static void main(String[] args) {

        System.out.printf("%d + %d * %d = %d\n", -5, 8, 6, (-5 + 8 * 6));
        System.out.printf("(%d + %d) %% %d = %d\n", 55, 9, 9, (55 + 9) % 9);
        System.out.printf("%d + %d * %d / %d = %d\n", 20, -3, 5, 8, (20 + -3 * 5 / 8));
        System.out.printf("%d + %d / %d * %d - %d %% %d\n", 5, 15, 3, 2, 8, 3, (5 + 15 / 3 * 2 - 8 % 3));

    }
}
