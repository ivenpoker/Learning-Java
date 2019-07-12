// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.17 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_17;

import java.time.LocalDateTime;

public class HealthProfile {

    private String _firstName;
    private String _lastName;
    private String _gender;
    private int _month;
    private int _year;
    private int _day;
    private int _height;
    private int _weight;

    public HealthProfile(String _firstName, String _lastName, String _gender,
                         int _month, int _day, int _year, int _height, int _weight) {
        this._firstName = _firstName;
        this._lastName  = _lastName;
        this._gender    = _gender;
        this._month     = _month;
        this._day       = _day;
        this._year      = _year;
        this._height    = _height;
        this._weight    = _weight;
    }

    public void setFirstName(String _newFirstName) {
        this._firstName = _newFirstName;
    }

    public void setLastName(String _newLastName) {
        this._lastName  = _newLastName;
    }

    public void setGender(String _newGender) {
        this._gender = _newGender;
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

    public void setHeight(int _newHeight) {
        this._height = _newHeight;
    }

    public void setWeight(int _newWeight) {
        this._weight = _newWeight;
    }

    public String getFirstName() {
        return this._firstName;
    }

    public String getLastName() {
        return this._lastName;
    }

    public String getGender() {
        return this._gender;
    }

    public int getMonth() {
        return this._month;
    }

    public int getDay() {
        return this._day;
    }

    public int getYear() {
        return this._year;
    }

    public int getHeight() {
        return this._height;
    }

    public int getWeight() {
        return this._weight;
    }

    public int computeAge() {
        return (LocalDateTime.now()).getYear() - this._year;
    }

    public int computeMaximumHeartRate() {
        return 220 - this.computeAge();
    }

    public double computeTargetHeartRate() {
        return (75.0/100) * this.computeMaximumHeartRate();
    }

    public double computeBMI() {
        return (this._weight * 703) / (this._height * this._height);
    }
}
