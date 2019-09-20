package w3resource.basicPartOne;

// ##################################################################################################
// #                                                                                                #
// #    Program Purpose: Measure how long some code takes to execute in nanoseconds.                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                      #
// #    Creation Date  : September 20, 2019                                                         #
// #                                                                                                #
// ##################################################################################################

import java.util.LinkedList;
import java.util.List;
import java.security.SecureRandom;

public class Exercise_91 {

    private static SecureRandom random = new SecureRandom();

    private static int getRandomIntInRange(int low, int high) {
        return low + random.nextInt(high);
    }

    private static List<Integer> findNumOfPrimes(int someNum) {
        List<Integer> primeList = new LinkedList<>();
        for (int i = 1, primeCnt = 0; primeCnt != someNum; i++) {
            if (isPrime(i)) {
                primeList.add(i);
                primeCnt++;
            }
        }
        return primeList;
    }

    private static boolean isPrime(int someNum) {
        return numFactors(someNum) == 2;
    }

    private static int numFactors(int someNum) {
        int factCnt = 0;
        for (int i = 1; i <= someNum/2; i++)
            if (someNum % i == 0)
                factCnt++;
        return factCnt;
    }

    public static void main(String[] args) {

        int randInt = getRandomIntInRange(0, 100);
        System.out.printf("Searching for first %d primes.....", randInt);

        long startTime = System.nanoTime();
        List<Integer> primes = findNumOfPrimes(randInt);
        long endTime = System.nanoTime();
        System.out.printf("[DONE]\n[Primes: %s]\n", primes);
        System.out.printf("Time elapsed: %d nanoseconds\n", (endTime - startTime));

    }

}
