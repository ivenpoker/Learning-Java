package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Computes the maximum value of the sum of the passing integers from    #
// #                     a narrow hilltop.                                                     #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : August 06, 2020                                                       #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Exercise_240 {

    public static void main(String[] args) {
        System.out.println("Input the numbers (ctrl+c to exit):");
        Scanner sc = new Scanner(System.in);
        List<String> l = new ArrayList<String>();
        while(sc.hasNext())l.add(sc.next());
        int n = l.size();
        int[][] a = new int[n][];
        for(int i=0;i<n;i++){
            String[] s = l.get(i).split(",");
            int k = s.length;
            a[i] = new int[k];
            for(int j=0;j<k;j++)a[i][j]=Integer.parseInt(s[j]);
        }
        int[] sd = {a[0][0]};
        for(int i=1;i<n;i++){
            int[] tmp = new int[a[i].length];
            for(int j=0;j<tmp.length;j++){
                if(i<=n/2){
                    if(j==0)tmp[j]=sd[j]+a[i][j];
                    else if(j==tmp.length-1)tmp[j]=sd[j-1]+a[i][j];
                    else tmp[j]=Math.max(sd[j-1]+a[i][j], sd[j]+a[i][j]);
                }
                else{
                    tmp[j] = Math.max(sd[j]+a[i][j], sd[j+1]+a[i][j]);
                }
            }
            sd = tmp;
        }
        System.out.println("Maximum value of the sum of integers passing according to the rule on one line.");
        System.out.println(sd[0]);
    }


}
