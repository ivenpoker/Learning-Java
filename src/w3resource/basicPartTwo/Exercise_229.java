package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Reads the two adjoined sides and the diagonal of a parallelogram and  #
// #                     check whether the parallelogram is a rectangle or a rhombus.          #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 29, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_229 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int count_1 = 0,count_2 = 0;
        System.out.println("Input two adjoined sides and the diagonal of a parallelogram (comma separated):");
        String[] s = sc.nextLine().split(",");
        int len1 = Integer.parseInt(s[0]);
        int len2 = Integer.parseInt(s[1]);
        int len3 = Integer.parseInt(s[2]);
        if(len3*len3 == len1*len1 + len2*len2) count_1++;
        if(len1 == len2) count_2++;
        if(count_1>0)
            System.out.println("This is a rectangle.");
        if(count_2>0)
            System.out.println("This is a rhombus.");
    }
}
