package w3resource.basicPartTwo;

// ####################################################################################
// #                                                                                  #
// #    Program Purpose: Creates a 2D array (m x m) A[][] such that A[i][j] is true   #
// #                     if i and j are prime and have no common factors, otherwise   #
// #                     A[i][j] becomes false.                                       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                        #
// #    Creation Date  : December 29, 2019                                            #
// #                                                                                  #
// ####################################################################################

public class Exercise_158 {

    private static int primeCell(int a, int b) {
        if (a == 0 || b == 0) {
            return 1;
        }
        if (a < b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a % b == 0) {
            return b;
        } else {
            return primeCell(b, a % b);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        boolean[][] A = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = primeCell(i, j) == 1;
                System.out.print(A[i][j] + " ");
            }
            System.out.println();
        }
    }
}
