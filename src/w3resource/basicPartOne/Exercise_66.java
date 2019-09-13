package w3resource.basicPartOne;

// ###############################################################################################
// #                                                                                             #
// #    Program Purpose: Compute the sum of the first 100 prime numbers.                         #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                   #
// #    Creation Date  : September 13, 2019                                                      #
// #                                                                                             #
// ###############################################################################################

public class Exercise_66 {

    private static int sumOfAllPrimes(int maxPrimes) {
        int someOfPrimes = 0;
        int primesFound = 0;
        int i = 1;
        while (primesFound != maxPrimes) {
            if (isPrime(i)) {
                someOfPrimes += i;
                primesFound += 1;
            }
            i++;
        }
        return someOfPrimes;
    }

    private static boolean isPrime(int someNum) {
        return numberOfFactors(someNum) == 2;
    }

    private static int numberOfFactors(int someNum) {
        int factCnt = 1;
        for (int i = 1; i <= someNum / 2; i++)
            if (someNum % i == 0)
                factCnt++;
        return factCnt;
    }

    public static void main(String[] args) {
        int maxPrimes = 100;
        int sum = sumOfAllPrimes(maxPrimes);
        System.out.printf("Sum of first %d primes: %d\n", maxPrimes, sum);
    }
}
