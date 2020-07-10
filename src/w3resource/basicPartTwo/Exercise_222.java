package w3resource.basicPartTwo;

// #############################################################################################
// #                                                                                           #
// #    Program Purpose: Determines if two lines are parallel.                                 #
// #    Program Author : Happi Yvan <ivensteinpoker@gmail.com>                                 #
// #    Creation Date  : July 10, 2020                                                         #
// #                                                                                           #
// #############################################################################################

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exercise_222 {

    private static Scanner scanner = new Scanner(System.in);

    private static Point getPointFromUser(String inputMess) {
        Point newPoint = new Point(0, 0);
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(inputMess);
                newPoint.setXCord(scanner.nextInt());   // obtain x-cord
                newPoint.setYCord(scanner.nextInt());   // obtain y-cord
                valid = true;

            } catch (InputMismatchException iMe) {
                System.err.printf("[invalid_input]: %s%n", iMe.getMessage());
                scanner.nextInt();      // clear any remaining data in the input stream.

            } catch (IllegalStateException iSe) {
                System.err.print("[re-opening__scanner] ... ");
                scanner = new Scanner(System.in);
                scanner.nextLine();     // clear any remaining data in the input stream.

            } catch (Exception exc) {
                System.err.println(exc.getMessage());
            }
        }
        return newPoint;
    }

    private static double gradientOfLine(Line someLine) {
        double valA = someLine.getPtA().getYCord() - someLine.getPtB().getYCord();
        double valB = someLine.getPtA().getXCord() - someLine.getPtB().getXCord();

        return valA / valB;
    }

    private static Line getLineFromUser(String lineName) {
        Point pointA = getPointFromUser(String.format("[%s] Enter point cords (as: x y): ", lineName));
        Point pointB = getPointFromUser(String.format("[%s] Enter point cords (as: x y): ", lineName));

        return new Line(pointA, pointB);
    }

    public static void main(String[] args) {

        Line firstLine = getLineFromUser("Line #1");
        Line secondLine = getLineFromUser("Line #2");

        System.out.println();

        System.out.println(firstLine);
        System.out.println(secondLine);

        System.out.println();

        double line1Grad = gradientOfLine(firstLine);
        double line2Grad = gradientOfLine(secondLine);

        System.out.printf("Gradients: [%.2f | %.2f]%n", line1Grad, line2Grad);

        if (Double.parseDouble(String.format("%.2f", line1Grad)) ==
                Double.parseDouble(String.format("%.2f", line2Grad))) {
            System.out.println("Lines are parallel");
        } else {
            System.out.println("Lines are NOT parallel");
        }
    }

}

class Line {

    private Point ptA;
    private Point ptB;

    public Line(Point ptA, Point ptB) {
        this.setPtA(ptA);
        this.setPtB(ptB);
    }

    public void setPtA(Point newPtA) {
        this.ptA = newPtA;
    }

    public void setPtB(Point newPtB) {
        this.ptB = newPtB;
    }

    public Point getPtA() {
        return this.ptA;
    }

    public Point getPtB() {
        return this.ptB;
    }

    @Override
    public String toString() {
        return String.format("Line [%s, %s]",  this.ptA.toString(), this.ptB.toString());
    }
}

class Point {

    private int xCord;
    private int yCord;

    public Point(int xCord, int yCord) {
        this.setXCord(xCord);
        this.setYCord(yCord);
    }

    public void setXCord(int newXCord) {
        this.xCord = newXCord;
    }

    public void setYCord(int newYCord) {
        this.yCord = newYCord;
    }

    public int getXCord() {
        return this.xCord;
    }

    public int getYCord() {
        return this.yCord;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", this.xCord, this.yCord);
    }
}
