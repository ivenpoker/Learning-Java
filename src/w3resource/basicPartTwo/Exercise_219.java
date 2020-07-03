package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Checks if a point (x, y) is in a triangle or not. There is a triangle #
// #                     formed by three points.                                               #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 03, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_219 {

    private static double outer_product(double x, double y, double x1, double y1, double x2, double y2){
        x1 = x1 - x;
        y1 = y1 - y;
        x2 = x2 - x;
        y2 = y2 - y;
        double s = x1 * y2 - y1 * x2;
        return s;
    }
    public static void point(){
        Scanner sc = new Scanner(System.in);
        double [] x = new double[3];
        double [] y = new double[3];
        System.out.println("Input (x1, y1)");
        x[0] = sc.nextDouble();
        y[0] = sc.nextDouble();
        System.out.println("Input (x2, y2)");
        x[1] = sc.nextDouble();
        y[1] = sc.nextDouble();
        System.out.println("Input (x3, y3)");
        x[2] = sc.nextDouble();
        y[2] = sc.nextDouble();
        System.out.println("Input (xp, yp)");

        double xp = sc.nextDouble();
        double yp = sc.nextDouble();
        boolean [] ans = new boolean[3];
        for(int i=0; i < 3; i++){
            ans[i] = outer_product(xp, yp, x[i], y[i], x[(i+1)%3], y[(i+1)%3]) > 0.0;
        }
        if(ans[0] == ans[1] && ans[1] == ans[2]){
            System.out.println("The point is inside the triangle.");
        }
        else{
            System.out.println("The point is outside the triangle.");
        }
    }

    public static void main(String[] args) {
        point();
    }

}
