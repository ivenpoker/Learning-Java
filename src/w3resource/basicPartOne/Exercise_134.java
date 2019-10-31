package w3resource.basicPartOne;

// #######################################################################################################
// #                                                                                                     #
// #    Program Purpose: Finds the distinct ways someone can climb to the top (n steps to reach to the   #
// #                     top) of stairs. Each time, one can either climb 1 or 2 steps.                   #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                           #
// #    Creation Date  : October 31, 2019                                                                #
// #                                                                                                     #
// #######################################################################################################

import java.util.Scanner;

public class Exercise_134 {

    private static int climbStairs(int n) {
        if (n <= 1)
            return 1;
        int[] s_case = new int[n+1];
        s_case[0] = 1;
        s_case[1] = 1;
        for (int i = 2; i <= n; i++)
            s_case[i] = s_case[i-1] + s_case[i-2];
        return s_case[n];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of steps: ");
        int numSteps = input.nextInt();

        while (numSteps < 0) {
            System.out.print("Enter number of steps (> 0): ");
            numSteps = input.nextInt();
        }
        System.out.printf("Distinct ways one can climb to the top: %d\n", climbStairs(numSteps));
    }

}
