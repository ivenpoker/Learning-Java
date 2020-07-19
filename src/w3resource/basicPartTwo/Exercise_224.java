package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Determines if the circumference of one circle is inside another.      #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 19, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_224 {

    private static final Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Input x1, y1, r1: (numbers are separated by a space)");
        double x1 = in.nextDouble(),y1=in.nextDouble(),r1=in.nextDouble();
        System.out.println("Input x2, y2, r2: (numbers are separated by a space)");
        double x2 = in.nextDouble(),y2=in.nextDouble(),r2=in.nextDouble();

        double l = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));

        if(l>r1+r2)
            System.out.println("Circumference of C1  and C2  intersect");
        else if(r1>l+r2)
            System.out.println("C2  is in C1");
        else if(r2>l+r1)
            System.out.println("C1  is in C2");
        else
            System.out.println("C1 and C2  do not overlap");

    }
}
