package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Creates maximum number of regions obtained by drawing n given         #
// #                     straight lines                                                        #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 31, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_234 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input number of straight lines:");
        int n=scan.nextInt();
        System.out.println("Number of regions:");
        System.out.println((n * (n + 1) >> 1) + 1);
    }
}
