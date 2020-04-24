// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.16 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 25/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_16;

import java.time.LocalDateTime;

public class HeartRates {

    private String _firstName;
    private String _lastName;
    private int _month;
    private int _day;
    private int _year;

    public HeartRates(String _firstName, String _lastName,
                      int _month, int _day, int _year) {
        this._firstName = _firstName;
        this._lastName  = _lastName;
        this._month     = _month;
        this._day       = _day;
        this._year      = _year;
    }

    public void setFirstName(String _newFirstName) {
        this._firstName = _firstName;
    }

    public void setLastName(String _lastName) {
        this._lastName = _lastName;
    }

    public void setMonth(int _newMonth) {
        this._month = _newMonth;
    }

    public void setDay(int _newDay) {
        this._day = _newDay;
    }

    public void setYear(int _newYear) {
        this._year = _newYear;
    }

    public int computeAge() {
        return (LocalDateTime.now()).getYear() - this._year;
    }

    public int maximumHeartRate() {
        return 220 - this.computeAge();
    }

    public double computeTargetHeartRate() {
        double rangeSum = (50 + 80);
        return ((rangeSum/2)/100) * this.maximumHeartRate();
    }

    public String getFirstName() {
        return this._firstName;
    }

    public String getLastName() {
        return this._lastName;
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
}
