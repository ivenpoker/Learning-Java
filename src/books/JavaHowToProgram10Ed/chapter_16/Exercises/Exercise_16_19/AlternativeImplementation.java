package books.JavaHowToProgram10Ed.chapter_16.Exercises.Exercise_16_19;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

public class AlternativeImplementation {

    private static final Scanner input = new Scanner(System.in);

    private static int obtainNumberFromUser(String inputMess) {
        boolean inputValid = false;
        int userInt = -1;

        while (!inputValid) {
            try {
                System.out.print(inputMess);
                userInt = input.nextInt();

                if (userInt < 0) {
                    throw new InputMismatchException("please enter integer > 0");
                }
                inputValid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());

            } catch (Exception exc) {
                System.err.printf("[MAIN_EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static List<Integer> findFactors(int mainNum) {
        if (mainNum < 2) {
            return new LinkedList<>();
        }
        List<Integer> factors = new LinkedList<>();
        factors.add(1);

        for (int i = 2; i <= mainNum / 2; i++) {
            if (mainNum % i == 0) {
                factors.add(i);
            }
        }
        factors.add(mainNum);

        return factors;
    }

    private static boolean isPrime(int someNum) {
        List<Integer> numFacts = findFactors(someNum);
        return numFacts.size() == 2 && (numFacts.get(0) == 1 && numFacts.get(1) == someNum);
    }

    private static void processNum(int someNum) {
        List<Integer> numFactors = findFactors(someNum);

        // check if parameter is a prime number
        if (numFactors.size() == 2 && (numFactors.get(0) == 1 && numFactors.get(1) == someNum)) {
            System.out.printf("Unique prime factors of '%d': %s%n", someNum, numFactors);
        } else {

            Set<Integer> primeFactors = new HashSet<>();
            for (Integer fact : numFactors) {
                if (isPrime(fact)) {
                    primeFactors.add(fact);
                }
            }
            System.out.printf("Unique prime factors of '%d': %s%n", someNum, primeFactors);
        }
    }


    public static void main(String[] args) {

        int userMainNum = obtainNumberFromUser("Enter a whole number > 0: ");
        processNum(userMainNum);

    }
}
