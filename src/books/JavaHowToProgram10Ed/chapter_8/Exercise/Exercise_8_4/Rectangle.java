// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.4 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_4;

public class Rectangle {

    private float _length;
    private float _width;

    public Rectangle() {
        this(1, 1);
    }
    public Rectangle(int length, int width) {
        this._length = length;
        this._width  = width;
    }

    public float getLength() {
        return this._length;
    }

    public float getWidth() {
        return this._width;
    }

    public void setLength(int newLength) {
        if (newLength < 0.0 || newLength > 20.00)
            throw new IllegalArgumentException("Invalid length for rectangle");
        this._length = newLength;
    }

    public void setWidth(int newWidth) {
        if (newWidth < 0.0 || newWidth > 20.00)
            throw new IllegalArgumentException("Invalid width for rectangle");
        this._width = newWidth;
    }

    public float computeArea() {
        return this._length * this._width;
    }

    public float computePerimeter() {
        return 2 * (this._length + this._width);
    }

}
