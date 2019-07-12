// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.8 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 15/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_8;

public class Date {

    private int _month;
    private int _day;
    private int _year;

    private static final int[] _daysPerMonth =
            { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException(String.format("month (%d) must be 1-12", month));
        if (day <= 0 || (day > Date._daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException(String.format("month (%d) out-of-range for " +
                    "the specified month and year", month));
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException(String.format("day (%d) out-of-range for " +
                    "the specified month and year", year));
        this._month = month;
        this._year  = year;
        this._day   = day;

       // System.out.printf("Date object constructor for date: %s%n", this);
    }

    public void nextDay() {
        if (this._day == Date._daysPerMonth[this._month]) {
            this._day = 1;
            if (this._month == 12) {
                this._month = 1;
                this._year  += 1;
            } else {
                this._month += 1;
            }
        } else {
            this._day += 1;
        }
    }

    public String toString() {
        return String.format("%d/%d/%d", this._month, this._day, this._year);
    }
}
