// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.8 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################


package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_8;

public class Exercise_9_8 {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(new Quadrilateral.Point(1, 10), new Quadrilateral.Point(10, 10),
                                       new Quadrilateral.Point(1, 1),  new Quadrilateral.Point(10, 1));

        System.out.printf("%s\nRectangle length: %d\nRectangle width: %d\nArea of rectangle: %d\n", rect, rect.getWidth(),
                rect.getLength(), rect.getArea());
        System.out.println();

        Square square = new Square(new Quadrilateral.Point(1, 5), new Quadrilateral.Point(5, 5),
                                   new Quadrilateral.Point(1, 1), new Quadrilateral.Point(5, 1));

        System.out.println(square);
        System.out.printf("Area of square: %d\n", square.getArea());
    }
}
