package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Reads a mass data and finds the number of islands.                    #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 31, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.Scanner;

public class Exercise_237 {

    public static boolean[][] map;

    public static int[][] move = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void fds(int i, int j){
        map[i][j] = false;
        for(int k=0;k<4;k++){
            int i2 = i+move[k][0];
            int j2 = j+move[k][1];
            if(0<=i2&&i2<10&&0<=j2&&j2<10&&map[i2][j2])fds(i2,j2);
        }
    }
    public static void main(String[] args) {
        System.out.println("Input 10 rows of 10 numbers representing green squares (island) as 1 and blue squares (sea) as zeros");
        Scanner sc = new Scanner(System.in);
        map = new boolean[10][10];
        for(int i=0;i<10;i++){
            char[] s = sc.next().toCharArray();
            for(int j=0;j<10;j++){
                map[i][j] = s[j]=='1';
            }
        }
        int x = 0;
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(map[i][j]){
                    fds(i, j);
                    x++;
                }
            }
        }
        System.out.println("Number of islands:");
        System.out.println(x);
    }
}
