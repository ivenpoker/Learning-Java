package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Computes the sum of the first 'n' prime numbers.                      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 30, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_232 {

    private static Scanner input = new Scanner(System.in);

    private static int obtainUserInteger(String inputMess) {
        boolean valid = false;
        int userInt = 0;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (userInt < 0) {
                    throw new IllegalArgumentException("Invalid input. Must integer be > 0");
                }
                valid = true;
            } catch (IllegalArgumentException | InputMismatchException iiAe) {
                System.err.printf("[invalid_input]: %s%n", iiAe.getMessage());
                input.nextLine();               // clear input stream.

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static int numFactors(int num) {
        int numFacts = 2;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                numFacts += 1;
            }
        }
        return numFacts;
    }

    private static boolean isPrime(int num) {
        return numFactors(num) == 2;
    }

    private static int computePrimesSum(int maxPrimes) {
        int sum = 0;
        int numPrimesFound = 0;

        for (int i = 2; numPrimesFound < maxPrimes; i++) {
            if (isPrime(i)) {
                numPrimesFound += 1;
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int numberOfPrimes = obtainUserInteger("How many primes to compute sum ?: ");
        System.out.printf("Sum of first %d prime numbers: %d%n", numberOfPrimes, computePrimesSum(numberOfPrimes));
    }

}
