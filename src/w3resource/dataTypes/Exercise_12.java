package w3resource.dataTypes;

// ###########################################################################################
// #                                                                                         #
// #    Program Purpose: Compares two given signed and unsigned numbers.                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                               #
// #    Creation Date  : August 11, 2020                                                     #
// #                                                                                         #
// ###########################################################################################

public class Exercise_12 {

    private static void doTestAndProcessing() {
        int in1 = Integer.MIN_VALUE;
        int in2 = Integer.MAX_VALUE;

        System.out.printf("Signed integers: %d | %d%n", in1, in2);
        System.out.println("------------------------------------------");

        int compareSignedNum = Integer.compare(in1, in2);
        System.out.printf("Result of comparing signed numbers: %d%n", compareSignedNum);

        int compareUnsignedNum = Integer.compareUnsigned(in1, in2);
        System.out.printf("Result of comparing unsigned numbers: %d%n", compareUnsignedNum);

    }

    public static void main(String[] args) {
        doTestAndProcessing();
    }
}
