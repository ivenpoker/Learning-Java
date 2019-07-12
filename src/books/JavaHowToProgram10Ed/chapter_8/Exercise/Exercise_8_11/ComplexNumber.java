// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.11 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_11;

public class ComplexNumber {

    private double _realPart;
    private double _imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this._realPart = realPart;
        this._imaginaryPart = imaginaryPart;
    }

    public ComplexNumber() {
        this(0.0, 0.0);
    }

    public ComplexNumber add(ComplexNumber anotherComp) {
        return new ComplexNumber(this._realPart + anotherComp._realPart,
                this._imaginaryPart + anotherComp._imaginaryPart);
    }

    public ComplexNumber sub(ComplexNumber anotherComp) {
        return new ComplexNumber(this._realPart - anotherComp._realPart,
                this._imaginaryPart - anotherComp._imaginaryPart);
    }

    public String toString() {
        return String.format("(%.2f, %.2f)", this._realPart, this._imaginaryPart);
    }
}
