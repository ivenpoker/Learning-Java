// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_14;

public class Date {
    private int _month;
    private int _day;
    private int _year;

    public static enum DateFormat {MONTH_DAY_YEAR, MONTH_DAY_YEAR_STRING, DAY_YEAR}

    private static final int[] _daysPerMonth =
            { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    private static final String[] _monthNames =
            {"", "January", "February", "March", "April", "May", "June", "July", "August", "September",
             "October", "November", "December"};

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

        System.out.printf("Date object constructor for date: %s%n", this);
    }

    public Date(String someMonth, int day, int year) {
        if (someMonth.isEmpty())
            throw new IllegalArgumentException("Invalid month name. Cannot be empty");

        int month = -1;
        for (int i = 1; i < Date._monthNames.length; i++) {
            if (Date._monthNames[i].toLowerCase().trim().equals(someMonth.trim().toLowerCase())) {
                month = i;
                break;
            }
        }
        if (month == -1) {
            throw new IllegalArgumentException("Invalid month name");
        }

        if (day <= 0 || (day > Date._daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException(String.format("month (%d) out-of-range for " +
                    "the specified month and year", month));
        if (month == 2 && day == 29 && !(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException(String.format("day (%d) out-of-range for " +
                    "the specified month and year", year));

        this._month = month;
        this._year  = year;
        this._day   = day;
    }

    public Date(int dayOfYear, int year) {
        if (dayOfYear < 0 || dayOfYear > 366)
            throw new IllegalArgumentException("Invalid day of year");
        int monthNum = 1;
        if (dayOfYear <= Date._daysPerMonth[monthNum]) {
            this._year = year;
            this._month = monthNum;
            this._day = dayOfYear;
        } else {
            dayOfYear -= 31;
            monthNum++;
            while (dayOfYear > Date._daysPerMonth[monthNum]) {
                dayOfYear -= Date._daysPerMonth[monthNum];
                monthNum++;

            }
            this._day   = dayOfYear;
            this._month = monthNum;
            this._year  = year;
        }
    }

    public String toString() {
        return String.format("%d/%d/%d", this._month, this._day, this._year);
    }
}
