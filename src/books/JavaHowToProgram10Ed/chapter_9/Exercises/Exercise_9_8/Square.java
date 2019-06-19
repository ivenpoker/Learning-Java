// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.8 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_8;

public class Square extends Quadrilateral {
    private int sideA;
    private int sideB;

    public Square(Point upperLeft, Point upperRight,
                     Point lowerLeft, Point lowerRight) {
        super(upperLeft, upperRight, lowerLeft, lowerRight);
        this.sideA = Math.abs(super.getUpperRight().getXCord() - super.getUpperLeft().getXCord());
        this.sideB = Math.abs(super.getUpperLeft().getYCord()  - super.getLowerLeft().getYCord());

        if (this.sideA != this.sideB)
            throw new IllegalArgumentException("Points don't constitute a square");
    }

    public int getArea() {
        return this.sideA * this.sideB;
    }

    public int getSide() {
        return this.sideA;  // could have been 'this.sideB'
    }

    private void computeSides() {
        this.sideA = Math.abs(super.getUpperRight().getXCord() - super.getUpperLeft().getXCord());
        this.sideB = Math.abs(super.getUpperLeft().getYCord()  - super.getLowerLeft().getYCord());
    }

    @Override
    public String toString() {
        return String.format("Square: %s", super.toString());
    }
}
