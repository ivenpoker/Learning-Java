package w3resource.basicPartOne;

// ##########################################################################################
// #                                                                                        #
// #    Program Purpose: Prints number between 1 to 100 which are divisible by 3, 5 and by  #
// #                     both.                                                              #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                              #
// #    Creation Date  : September 12, 2019                                                 #
// #                                                                                        #
// ##########################################################################################

public class Exercise_51 {

    private static void printNumbersInDivisibilityRange(int num, int low, int high) {
        System.out.printf("Divided by %d:\n", num);
        for (int i = low; i < high; i++)
            if (i % num == 0)
                System.out.printf("%d, ", i);
        System.out.println("\n");
    }

    private static void printNumbersInDivisibilityRange(int numA, int numB, int low, int high) {
        System.out.printf("Divided by %d & %d:\n", numA, numB);
        for (int i = low; i < high; i++)
            if (i % numA == 0 && i % numB == 0)
                System.out.printf("%d, ", i);
        System.out.println("\n");
    }

    public static void main(String[] args) {
        printNumbersInDivisibilityRange(3, 1, 100);
        printNumbersInDivisibilityRange(5, 1, 100);
        printNumbersInDivisibilityRange(3, 5, 1, 100);
    }

}
