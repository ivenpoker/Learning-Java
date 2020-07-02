package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Solves the equation:                                                  #
// #                                ax + by = c                                                #
// #                                dx + ey = f                                                #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 02, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Exercise_214 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Double> x = new ArrayDeque<Double>();
        ArrayDeque<Double> y = new ArrayDeque<Double>();
        System.out.println("Input the value of a, b, c, d, e, f:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();
        double t = (double)(d*c-a*f)/(d*b-a*e);
        double s = (double)(c-t*b)/a;
        x.push(s);
        y.push(t);
        int num = x.size();
        for(int i=0;i<num;i++){
            BigDecimal bdx = new BigDecimal(x.pollLast());
            BigDecimal bdy = new BigDecimal(y.pollLast());
            BigDecimal ansx = bdx.setScale(4, BigDecimal.ROUND_HALF_UP);
            BigDecimal ansy = bdy.setScale(4, BigDecimal.ROUND_HALF_UP);
            System.out.printf("%.3f", ansx.doubleValue());
            System.out.print(" ");
            System.out.printf("%.3f", ansy.doubleValue());
            System.out.println();
        }
    }
}
