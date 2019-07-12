// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_14;

public class Date {

    private int _month;
    private int _day;
    private int _year;

    public Date(int _month, int _day, int _year) {
        this._month = _month;       // could validate.
        this._day   = _day;         // could validate.
        this._year  = _year;        // could validate.
    }
    public void setMonth(int _newMonth) {
        this._month = _newMonth;    // could validate.
    }
    public void setDay(int _newDay) {
        this._day = _newDay;        // could validate.
    }
    public void setYear(int _newYear) {
        this._year = _newYear;      // could validate.
    }
    public int getMonth() {
        return this._month;
    }
    public int getYear() {
        return this._year;
    }
    public int getDay() {
        return this._day;
    }
    public void displayDate() {
        System.out.printf("%d/%d/%d\n", this._month, this._day, this._year);
    }
}
