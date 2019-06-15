// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.7 from book.                        #
// #      Program Purpose: Answers the question 8.7 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 14/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_7;

public class Time {

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
