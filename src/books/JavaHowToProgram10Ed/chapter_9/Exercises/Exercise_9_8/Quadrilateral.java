// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.8 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_8;

public class Quadrilateral {

    private Point upperLeft;
    private Point upperRight;
    private Point lowerLeft;
    private Point lowerRight;

    public Quadrilateral(Point upperLeft, Point upperRight,
                         Point lowerLeft, Point lowerRight) {
        this.upperLeft  = upperLeft;
        this.upperRight = upperRight;
        this.lowerLeft  = lowerLeft;
        this.lowerRight = lowerRight;
    }

    public Point getLowerLeft() {
        return this.lowerLeft;
    }
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    public Point getLowerRight() {
        return this.lowerRight;
    }

    public Point getUpperRight() {
        return this.upperRight;
    }

    public void setLowerLeft(Point newLowerLeft) {
        this.lowerLeft = newLowerLeft;
    }

    public void setLowerRight(Point newLowerRight) {
        this.lowerRight = newLowerRight;
    }

    public void setUpperLeft(Point newUpperLeft) {
        this.upperLeft  = newUpperLeft;
    }

    public void setUpperRight(Point newUpperRight) {
        this.upperRight = newUpperRight;
    }

    public static class Point {
        private int xCord;
        private int yCord;

        public Point(int xCord, int yCord) {
            this.xCord = xCord;
            this.yCord = yCord;
        }
        public Point() {
            this(0, 0);
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
    }

    @Override
    public String toString() {
        return String.format("Point: [(%d, %d), (%d, %d), (%d, %d) (%d, %d)]",
                this.getUpperLeft().getXCord(),  this.getUpperLeft().getYCord(),
                this.getUpperRight().getXCord(), this.getUpperRight().getYCord(),
                this.getLowerLeft().getXCord(),  this.getLowerLeft().getYCord(),
                this.getLowerRight().getXCord(), this.getLowerRight().getYCord());
    }
}
