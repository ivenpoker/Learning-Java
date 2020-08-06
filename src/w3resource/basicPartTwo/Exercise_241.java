package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Finds the number of combinations that satisfy p + q + r + s = n,      #
// #                     where n is a given number <= 4000 and p, q, r, s in the range 0 to    #
// #                     1000.                                                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : August 06, 2020                                                       #
// #                                                                                           #
// #############################################################################################

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_241 {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int UPPER_BOUND = 4000;
    private static final int MAX_SUM_RANGE = 1000;

    private static int readUserInteger(String inputMess, int upperBound) {
        boolean valid = false;
        int userInt = 0;

        while (!valid) {
            try {
                System.out.print(inputMess);
                userInt = scanner.nextInt();

                if (userInt < 0) {
                    throw new IllegalArgumentException(
                            String.format("Must be in range [0, %d]", upperBound));
                }
                valid = true;
            } catch (InputMismatchException | IllegalArgumentException exc) {
                System.out.printf("[invalid_input]: %s%n", exc.getMessage());

            } catch (Exception exc) {
                System.err.printf("[EXCEPTION]: %s%n", exc.getMessage());
            }
        }
        return userInt;
    }

    private static int findNumberOfCombinationsA(int userNum) {
        int[] temp = new int[2001];
        int[] ans = new int[4001];
        for(int i=0;i<=1000;i++){
            for(int j=0;j<=1000;j++){
                temp[i+j]++;
            }
        }
        for(int i=0;i<=2000;i++){
            for(int j=0;j<=2000;j++){
                ans[i+j]+=temp[i]*temp[j];
            }
        }
//        System.out.println("Number of combinations of a,b,c,d:");
//        System.out.println(ans[userNum]);

        return ans[userNum];
    }

    private static ArrayList<String> findNumberOfCombinations(int mainSum, int elemUpperBound) {
        ArrayList<String> sumCombs = new ArrayList<>();

        for (int p = 0; p < elemUpperBound; p++) {
            int sum = p;
            if (sum == mainSum) {
                sumCombs.add(String.format("%d + %d + %d + %d = %d", p, 0, 0, 0, mainSum));
                continue;
            }
            for (int q = 0; q < elemUpperBound; q++) {
                if (sum + q > elemUpperBound) {
                    continue;
                } else if (sum + q == mainSum) {
                    sumCombs.add(String.format("%d + %d + %d + %d = %d", p, q, 0, 0, mainSum));
                    continue;
                }
                sum += q;
                for (int r = 0; r < elemUpperBound; r++) {
                    if (sum + r > elemUpperBound) {
                        continue;
                    } else if (sum + r == elemUpperBound) {
                        sumCombs.add(String.format("%d + %d + %d + %d = %d", p, q, r, 0, mainSum));
                        continue;
                    }
                    sum += r;
                    for (int s = 0; s < elemUpperBound; s++) {
                        if (sum + s == mainSum) {
                            sumCombs.add(String.format("%d + %d + %d + %d = %d", p, q, r, s, mainSum));
                        }
                    }
                }
            }
        }
        return sumCombs;
    }

    public static void main(String[] args) {

        int userSumVal = readUserInteger("Enter value to sum to (must be > 0): ", UPPER_BOUND);
//        ArrayList<String> sumCombinations = findNumberOfCombinations(userSumVal, MAX_SUM_RANGE);

        System.out.printf("Number of combinations of p,q,r and s: %d%n", findNumberOfCombinationsA(userSumVal));
//        System.out.printf("Number of combinations of p, q, r and s: %d%n", sumCombinations.size());


//        for (int i = 0, size = sumCombinations.size(); i < size; i++) {
//            System.out.printf("Sum combination #%d: %s%n", i+1, sumCombinations.get(i));
//        }

    }
}
