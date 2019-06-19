// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.8 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_8;

public class Rectangle extends Quadrilateral {
    private int sideA;
    private int sideB;

    public Rectangle(Point upperLeft, Point upperRight,
                     Point lowerLeft, Point lowerRight) {
        super(upperLeft, upperRight, lowerLeft, lowerRight);
        this.sideA = Math.abs(super.getUpperRight().getXCord() - super.getUpperLeft().getXCord());
        this.sideB = Math.abs(super.getUpperLeft().getYCord()  - super.getLowerLeft().getYCord());

    }

    public int getArea() {
        return this.sideA * this.sideB;
    }

    public int getLength() {
        return this.sideA >= this.sideB ? this.sideA : this.sideB;
    }

    public int getWidth() {
        return this.sideA <= this.sideB ? this.sideA : this.sideB;
    }

    private void computeSides() {
        this.sideA = Math.abs(super.getUpperRight().getXCord() - super.getUpperLeft().getXCord());
        this.sideB = Math.abs(super.getUpperLeft().getYCord()  - super.getLowerLeft().getYCord());
    }

    @Override
    public String toString() {
        return String.format("Rectangle: %s", super.toString());
    }
}
