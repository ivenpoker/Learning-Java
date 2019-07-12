// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 8.5 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 11/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_5;

public class Time2 {

    private int _totalSeconds;

    public Time2() {
        this(0, 0, 0);
    }

    public Time2(int hour) {
        this(hour, 0, 0);
    }

    public Time2(int hour, int minute) {
        this(hour, minute, 0);
    }

    public Time2(int hour, int minute, int second) {
        if (!this.inRange(0, hour, 24))
            throw new IllegalArgumentException("Invalid hour for the time");
        if (!this.inRange(0, minute, 59))
            throw new IllegalArgumentException("Invalid minute for the time");
        if (!this.inRange(0, second, 59))
            throw new IllegalArgumentException("Invalid seconds for the time");

        this._totalSeconds += second;
        while (hour > 0) {
            minute += 60;
            --hour;
        }
        while (minute > 0) {
            this._totalSeconds += 60;
            --minute;
        }
    }

    public void setHour(int hour) {
        if (!this.inRange(0, hour, 24))
            throw new IllegalArgumentException("Invalid hour for time");
        int tmpMins = this.secsToMins();                   // save the number of mins
        int tmpSecs = this._totalSeconds - (tmpMins * 60); // save the time seconds

        this._totalSeconds = 0;         // reset the seconds.
        while (hour > 0) {
            this._totalSeconds += (60 * 60);
            hour--;
        }
        this._totalSeconds += (tmpMins * 60);    // restore the minutes from backup
        this._totalSeconds += tmpSecs;           // restore the seconds from backup
    }

    public void setMinute(int minute) {
        if (!this.inRange(0, minute, 59))
            throw new IllegalArgumentException("Invalid minute for time");
        int tmpHour = this.getHour();       // backup the current hour(s)
        int tmpSecs = this.getSecond();     // backup the current second(s)

        this._totalSeconds = 0;             // reset the total seconds
        while (minute-- > 0)
            this._totalSeconds += 60;
        this._totalSeconds += (tmpHour * 60 * 60); // restore the hours from backup
        this._totalSeconds += tmpSecs;             // restore the seconds from backup
    }

    public void setSecond(int second) {
        if (!this.inRange(0, second, 59))
            throw new IllegalArgumentException("Invalid second for time");

        int tmpHour = this.getHour();           // backup the hours
        int tmpMins = this.getMinute();         // backup the minutes

        this._totalSeconds = second;                    // set the new hour
        this._totalSeconds += (tmpHour * 60 * 60);      // restore the backuped hours
        this._totalSeconds += (tmpMins * 60);           // restore the backuped minutes
    }

    public int getHour() {
        int totalMins = this.secsToMins();
        return totalMins / 60;
    }

    public int getMinute() {
        int totMins = this.secsToMins();
        return totMins % 60;
    }

    public int getSecond() {
        int totalMins = this.secsToMins();
        return this._totalSeconds - (totalMins * 60);
    }

    private int secsToMins() {
        int tmpCnt = 0;
        int tmpSec = this._totalSeconds;
        while (tmpSec >= 60) {
            tmpCnt++;
            tmpSec -= 60;
        }
        return tmpCnt;
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:02d",
                this.getHour(), this.getMinute(), this.getSecond());
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((this.getHour() == 0 || this.getHour() == 12) ? 12 : this.getHour() % 12),
                    this.getMinute(), this.getSecond(), (this.getHour() < 12 ? "AM" : "PM"));
    }

    private boolean inRange(int lower, int val, int upper) {
        return lower <= val && val <= upper;
    }

}
