package w3resource.basicPartOne;

// ########################################################################################
// #                                                                                      #
// #    Program Purpose: Print the American flag.                                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                            #
// #    Creation Date  : September 4, 2019                                                #
// #                                                                                      #
// ########################################################################################

public class Exercise_14 {

    private static void printAmericanFlag() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 6; j++) {
                if (i % 2 != 0) {
                    System.out.printf("%s%s", "*", " ");
                } else {
                    System.out.printf("%s%s", " ", "*");
                }
            }
            System.out.print(" ");
            for (int j = 0; j < 40; j++)
                System.out.printf("%s", "=");
            System.out.println();
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 53; j++)
                System.out.printf("%s", "=");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        printAmericanFlag();

    }
}
