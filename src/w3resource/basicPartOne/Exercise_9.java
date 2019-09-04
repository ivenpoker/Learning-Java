package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Display results of a certain computation.                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 4, 2019                                                #
// #                                                                                      #
// ########################################################################################

public class Exercise_9 {

    public static void main(String[] args) {

        System.out.printf("((%.1f * %.1f - %.1f * %.1f) / (%.1f - %.1f)) = %.15f",
                25.5, 3.5, 3.5, 3.5, 40.5, 4.5, ((25.5 * 3.5 - 3.5 * 3.5) / (40.5 - 4.5)));

    }

}
