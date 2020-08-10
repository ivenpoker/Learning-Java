package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_19;

// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 16.19 from book.                      #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : September 15, 2019                                         #
// #                                                                                  #
// ####################################################################################

import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.Iterator;
import java.util.LinkedList;

public class Exercise_16_19 {

    private static Scanner scanner = new Scanner(System.in);

    private static void readAndProcessData(String message) {
        boolean isValid = false;
        int mainInt = 0;
        HashSet<Integer> uniquePrimesFactors = new HashSet<>();

        do {
            try {
                System.out.print(message);
                mainInt = scanner.nextInt();

                if (isPrime(mainInt)) {
                    System.out.printf("[PRIME] Factors are: %d %d\n", 1, mainInt);
                } else {
                    List<Integer> factorsOfNum = findFactors(mainInt);
                    for (Integer intVal : factorsOfNum) {
                        if (isPrime(intVal))
                            uniquePrimesFactors.add(intVal);
                    }

                    System.out.print("[NOT_PRIME] Factors are: ");
                    Iterator<Integer> iter = uniquePrimesFactors.iterator();

                    for (int i = 0; i < uniquePrimesFactors.size(); i++)
                        System.out.printf("%d%s", iter.next(), i == uniquePrimesFactors.size()-1 ? "" : " ");
                    System.out.println();

                }
                isValid = true;


            } catch (IllegalStateException illegalStateException) {
                System.err.print("Scanner is closed. Re-opening...");
                scanner = new Scanner(System.in);
                System.out.println("[DONE]");

            } catch (Exception exception) {
                System.err.println(exception.getMessage());
                System.out.println("Try again.");
            }
        } while (!isValid);
    }

    private static boolean isPrime(int someNum) {
        return numberOfFactors(someNum) == 2;
    }

    private static int numberOfFactors(int someNum) {
        int factCnt = 1;
        for (int i = 1; i <= someNum/2; i++)
            if (someNum % i == 0)
                factCnt++;
        return factCnt;
    }

    private static List<Integer> findFactors(int someNum) {
        List<Integer> factors = new LinkedList<>();
        for (int i = 1; i <= someNum / 2; i++)
            if (someNum % i == 0)
                factors.add(i);
        factors.add(someNum);
        return factors;
    }

    public static void main(String[] args) {
        readAndProcessData("Enter some integer: ");
    }
}
