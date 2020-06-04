package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Get the position of a prime number.                                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : June 4, 2020                                                          #
// #                                                                                           #
// #############################################################################################

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_198 {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainUserInput(String mess) {
        boolean isValid = false;
        int userVal = 0;

        while (!isValid) {
            try {
                System.out.print(mess);
                userVal = input.nextInt();
                isValid = true;

            } catch (InputMismatchException iMe) {
                System.out.printf("[INPUT_ERROR]: %s%n", iMe.getMessage());
            }
        }
        return userVal;
    }

    private static ArrayList<Integer> factors(int someNum) {
        ArrayList<Integer> facts = new ArrayList<>();
        facts.add(1);
        for (int i = 2; i <= someNum / 2; i++) {
            if (someNum % i == 0) {
                facts.add(i);
            }
        }
        if (someNum > 1) {
            facts.add(someNum);
        }
        return facts;
    }

    private static ArrayList<Integer> primesInRange(int maxPrimes) {
        ArrayList<Integer> primesFound = new ArrayList<>();

        for (int i = 2; i <= maxPrimes; i++) {
            ArrayList<Integer> ithFacts = factors(i);
            if (ithFacts.size() == 2) {
                primesFound.add(i);
            }
            System.out.printf("\rComputing primes .... [%.2f%%]", ((double) i / maxPrimes) * 100);
        }
        System.out.printf("%8s%n", "[DONE]");
        return primesFound;
    }

    private static int obtainUserPrimeSearchKey(String mess) {
        boolean isValid = false;
        int userPrimeKey = 0;

        while (!isValid) {
            try {
                System.out.print(mess);
                userPrimeKey = input.nextInt();
                if (factors(userPrimeKey).size() == 2) {
                    isValid = true;
                }
            } catch (InputMismatchException iMe) {
                System.err.printf("[INPUT_ERROR]: %s%n", iMe.getMessage());
            }
        }
        return userPrimeKey;
    }

    public static void main(String[] args) {

        // Obtain user maximum numbers to work with
        int userMax = obtainUserInput("Enter maximum primes to work with: ");

        // Find all primes from 2 till that max
        ArrayList<Integer> primesFound = primesInRange(userMax);

        // Obtain prime to locate in computed primes
        int userPrimeSearchKey = obtainUserPrimeSearchKey("Enter prime to search for: ");

        // Check to see if prime key is in the primes found so far
        int idx = primesFound.indexOf(userPrimeSearchKey);

        if (idx == -1) {
            System.out.printf("[NOT FOUND]: Couldn't find prime number '%d' in range.%n", userPrimeSearchKey);
        } else {
            System.out.printf("[FOUND]: Found prime '%d' at position %d.%n", userPrimeSearchKey, idx);
        }

    }

}
