// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.12 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_12;

public class DateAndTime {

    public static class Time {
        private int _hour;
        private int _minute;
        private int _second;

        public Time() {
            this(0, 0, 0);
        }

        public Time(int hour) {
            this(hour, 0, 0);
        }

        public Time(int hour, int minute, int second) {
            if (!this.inRange(0, hour, 24))  throw new IllegalArgumentException("Invalid number of hours");
            if (!this.inRange(0, minute, 59)) throw new IllegalArgumentException("Invalid number of minutes");
            if (!this.inRange(0, second, 59)) throw new IllegalArgumentException("Invalid number of seconds");

            this._hour = hour;
            this._minute = minute;
            this._second = second;
        }

        public Time(Time time) {
            this(time.getHour(), time.getMinute(), time.getSecond());
        }

        public void setTime(int hour, int minute, int second) {
            if (!this.inRange(0, hour, 24))  throw new IllegalArgumentException("Invalid number of hours");
            if (!this.inRange(0, minute, 59)) throw new IllegalArgumentException("Invalid number of minutes");
            if (!this.inRange(0, second, 59)) throw new IllegalArgumentException("Invalid number of seconds");

            this._hour = hour;
            this._minute = minute;
            this._second = second;
        }

        public void setHour(int newHour) {
            if (!this.inRange(0, newHour, 24))
                throw new IllegalArgumentException("Invalid hour.");
            this._hour = newHour;
        }

        public void tick() {
            if (this.getSecond() == 59) {
                if (this.getMinute() == 59) {
                    this.setHour((this.getHour() + 1) % 24);
                    this.setMinute(0);
                } else {
                    this.setMinute(this.getMinute() + 1);
                }
                this.setSecond(0);
            } else {
                this.setSecond(this.getSecond() + 1);
            }
        }

        public void incrementMinute() {
            if (this.getMinute() == 59) {
                this.setHour((this.getHour() + 1) %  24);
                this.setMinute(0);
            } else {
                this.setMinute(this.getMinute() + 1);
            }
        }

        public void incrementHour() {
            this.setHour((this.getHour() + 1) % 24);
        }

        public void setMinute(int newMinute) {
            if (!this.inRange(0, newMinute, 59))
                throw new IllegalArgumentException("Invalid minute.");
            this._minute = newMinute;
        }

        public void setSecond(int newSecond) {
            if (!this.inRange(0, newSecond, 59))
                throw new IllegalArgumentException("Invalid second.");
            this._second = newSecond;
        }

        public int getHour() {
            return this._hour;
        }
        public int getSecond() {
            return this._second;
        }
        public int getMinute() {
            return this._minute;
        }

        public String toUniversalString() {
            return String.format("%02d:%02d:%02d",
                    this.getHour(), this.getSecond(), this.getMinute());
        }

        public String toString() {
            return String.format("%d:%02d:%02d %s",
                    ((this.getHour() == 0 || this.getHour() == 12) ? 12 : this.getHour() % 12),
                    this.getMinute(), this.getSecond(), (this.getHour() < 12 ? "AM" : "PM"));
        }

        private boolean inRange(int low, int val, int high) {
            return low <= val && val <= high;
        }
    }
    public static class Date {
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

    private Time _time;
    private Date _date;

    public DateAndTime(Time time, Date date) {
        this._time = new Time(time);
        this._date = new Date(date._month, date._day, date._year);
    }

    public void incrementHour() {
        if (this._time._hour == 23) {
            this._time.incrementHour();
            this._date.nextDay();
        } else {
            this._time.incrementHour();;
        }
    }

    public void inrementMinute() {
        if (this._time._hour == 23 && this._time._minute == 59) {
            this._time.incrementMinute();
            this._date.nextDay();
        } else {
            this._time.incrementMinute();
        }
    }

    public String toString() {
        return String.format("[%s] -- [%s]", this._date, this._time);
    }
}
