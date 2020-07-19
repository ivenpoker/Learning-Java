package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Reads a date (from 2004/1/1 to 2004/12/31) and prints the day of the  #
// #                     date. Jan. 1, 2004, is Thursday. Note that 2004 is a leap year.       #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 19, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_225 {

    static int days[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String name[] = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input month and date(o o to exit)");

        for(;;){
            int m=in.nextInt(), d=in.nextInt();
            if(m==0&&d==0) break;
            System.out.println(solve(m,d));
        }
    }

    static String solve(int month, int date){
        int cur = 3;
        System.out.println("Name of the day:");
        for(int i=0; i<month-1; i++) cur += days[i];
        cur += date-1;
        return name[cur%7];
    }

}
