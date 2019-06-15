// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.4 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_4;

public class Exercise_8_4 {

    public static void main(String[] args) {

        Rectangle rect1 = new Rectangle();                   // defaults to length of 1 and width of 1
        Rectangle rect2 = new Rectangle(4, 12);

        System.out.printf("rect1 --> length: %.1f, width: %.1f\n", rect1.getLength(), rect1.getWidth());
        System.out.printf("rect2 --> length: %.1f, width: %.1f\n", rect2.getLength(), rect2.getWidth());

        System.out.println();

        System.out.printf("Area of rect1: %.1f | Perimeter: %.1f\n", rect1.computeArea(), rect1.computePerimeter());
        System.out.printf("Area of rect2: %.1f | Perimeter: %.1f\n", rect2.computeArea(), rect2.computePerimeter());

    }
}
