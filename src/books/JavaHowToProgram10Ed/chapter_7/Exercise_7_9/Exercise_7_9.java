package books.JavaHowToProgram10Ed.chapter_7.Exercise_7_9;

import java.util.Scanner;

public class Exercise_7_9 {

    public static void main(String[] args) {

        // Question a)
        int[][] t = new int[2][3];

        // Question b) Number of rows in 't': 2
        // Question c) Number of columns in 't': 3
        // Question d) Number of elements in 't': 2 * 3 = 6

        // Question e)
        int tmpA = t[1][0];
        int tmpB = t[1][1];
        int tmpC = t[1][2];

        // Question f)
        int tmpD = t[0][1];
        int tmpE = t[1][1];

        // Question g)
        t[0][1] = 23;

        // Question h)
        t[0][0] = 1;
        t[0][1] = 2;
        t[0][2] = 3;

        t[1][0] = 4;
        t[1][1] = 5;
        t[1][2] = 6;

        // Question i)
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = 0;
            }
        }

        // Question j)
        Scanner input = new Scanner(System.in);

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                System.out.printf("Enter data for t[%d][%d]: ", i, j);
                t[i][j] = input.nextInt();
            }
            System.out.println();
        }

        // Question k)
        int smallest = t[0][0];         // default smallest value in 't'

        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (t[i][j] < smallest) {
                    smallest = t[i][j];
                }
            }
        }
        System.out.printf("Smallest: %d%n", smallest);

        // Question l)
        System.out.printf("First row data: [%d %d %d]%n", t[0][0], t[0][1], t[0][2]);

        // Question m)
        int total = 0;
        total += t[0][2];
        total += t[1][2];

        // Question n)
        System.out.printf("%n===================================%n");
        System.out.printf("%18s %5s %5s%n", "C#0", "C#1", "C#2");
        System.out.printf("===================================%n");
        for (int i = 0; i < t.length; i++) {
            System.out.printf("%10s:", String.format("row #%d -> ", i));
            for (int j = 0; j < t[i].length; j++) {
                System.out.printf("%5s ", t[i][j]);
            }
            System.out.println();
        }

    }

}





































