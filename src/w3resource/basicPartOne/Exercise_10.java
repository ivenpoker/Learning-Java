package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Perform some computation.                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 4, 2019                                                #
// #                                                                                      #
// ########################################################################################

public class Exercise_10 {

    public static void main(String[] args) {
        System.out.printf("%.1f * (%d - (%.1f/%d) + (%.1f/%d) - (%.1f/%d) + " +
                "(%.1f/%d) - (%.1f/%d)) = %.16f\n", 4.0, 1, 1.0, 3, 1.0, 5, 1.0, 7, 1.0, 9,
                1.0, 11, 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11)));
    }
}
