// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 6.32 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 09/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_6.Exercise_6_32;

import java.util.Scanner;

public class Exercise_6_32 {

    private static class Point {
        private int _xCord;
        private int _yCord;

        public Point(int xCord, int yCord) {
            this._xCord = xCord;
            this._yCord = yCord;
        }
        public int getX() {
            return this._xCord;
        }
        public int getY() {
            return this._yCord;
        }

        public String toString() {
            return "[" + this.getX() + ", " + this.getY() + "]";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter point A coordinates [as: x y]: ");
        Point pointA = new Point(input.nextInt(), input.nextInt());

        System.out.print("Enter point B coordinates [as: x y]: ");
        Point pointB = new Point(input.nextInt(), input.nextInt());

        System.out.printf("Distance between point %s and point %s: %.2f\n",
                pointA, pointB, distance(pointA, pointB));
    }

    private static double distance(Point pointA, Point pointB) {
        return Math.sqrt(Math.pow((pointB.getX() - pointA.getX()), 2)
                + Math.pow((pointB.getY() - pointA.getY()), 2));
    }
}
