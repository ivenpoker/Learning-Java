package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_12;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltDate date = new AltDate(1, 31, 2020);
        AltTime2 time = new AltTime2(23, 59, 59);
        AltDateAndTime dateAndTime = new AltDateAndTime(date, time);

        System.out.printf("Original date and time: %s%n", dateAndTime);

        // Incrementing to a new hour should change the date to new day
        // and new month.

        dateAndTime.incrementHour();
        System.out.printf("Changed date and time: %s%n", dateAndTime);
    }

}

class AltDateAndTime {
    private AltDate date;
    private AltTime2 time;

    public AltDateAndTime(AltDate newDate, AltTime2 newTime) {
        this.date = newDate;
        this.time = newTime;
    }

    public void incrementHour() {
        if (this.time.incrementHour()) {        // if we're into a new day
            this.date.nextDay();
        }
    }

    // ######################### [SETTER METHODS] ################################

    public void setDate(AltDate newDate) {
        this.date = newDate;
    }

    public void setTime(AltTime2 newTime) {
        this.time = newTime;
    }

    // ########################## [GETTERS METHOD] ###############################

    public AltDate getDate() {
        return this.date;
    }

    public AltTime2 getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.date, this.time);
    }
}

class AltDate {
    private int month;      // 1-12
    private int day;        // 1-31 based on month
    private int year;       // any year

    public static final int MIN_YEAR = 1970;
    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public AltDate(int month, int day, int year) {

        // check if month in range
        if (!this.inRange(0, month, 12)) {
            throw new IllegalArgumentException(String.format("month '%d' must be 1-12", month));
        }

        // check if day in range for month
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException(
                    String.format("day (%d) out-of-range for the specified month and year", day));
        }

        // check for leap year if month is 2 and day is 29
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 ==0 && year % 100 != 0))) {
            throw new IllegalArgumentException(
                    String.format("day (%d) out-of-range for the specified month and year", day));
        }

        // Validation for year.
        if (year < MIN_YEAR) {
            throw new IllegalArgumentException(
                    String.format("year(%d) is out-of-range must be > %d", year, MIN_YEAR));
        }

        this.month = month;
        this.day = day;
        this.year = year;

        // System.out.printf("Date object constructor for date %s%n", this);
    }

    public void nextDay() {
        if (this.day < AltDate.daysPerMonth[this.month]) {
            this.day += 1;
        } else {
            this.day = 1;
            if (this.month == 12) {
                this.month = 1;
                this.year += 1;
            } else {
                this.month += 1;
            }
        }
    }

    private boolean inRange(int low, int val, int high) {
        return low <= val && val <= high;
    }


    @Override
    public String toString() {
        return String.format("%d/%d/%d", this.month, this.day, this.year);
    }
}

class AltTime2 {
    private int hour;
    private int minute;
    private int second;

    public AltTime2() {
        this(0, 0, 0);
    }

    public AltTime2(int hour) {
        this(hour, 0, 0);
    }

    public AltTime2(int hour, int minute) {
        this(hour, minute, 0);
    }

    public AltTime2(int hour, int minute, int second) {
        if (!this.inBounds(0, hour, 23)) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        if (!this.inBounds(0, minute, 59)) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        if (!this.inBounds(0, second, 59)) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public AltTime2(AltTime2 altTime2) {
        this(altTime2.getHour(), altTime2.getMinute(), altTime2.getSecond());
    }


    public void tick() {
        if (this.second == 59) {
            this.second = 0;
            if (this.minute == 59) {
                this.minute = 0;
                this.hour = (this.hour == 23) ? 0 : this.hour + 1;
            } else {
                this.minute += 1;
            }
        } else {
            this.second += 1;
        }
    }

    public void incrementMinute() {
        if (this.minute == 59) {
            this.minute = 0;
            this.hour = (this.hour == 23) ? 0 : this.hour + 1;
        } else {
            this.minute += 1;
        }
    }

    public boolean incrementHour() {
        if (this.hour == 23) {
            this.minute = 0;
            this.hour = 0;
            return true;            // we've moved to the next day
        } else {
            this.hour += 1;
        }
        return false;               // we haven't move to the next day
    }


    // ####################### [SET METHODS] ##########################

    public void setTime(int hour, int minute, int second) {
        if (!this.inBounds(0, hour, 23)) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        if (!this.inBounds(0, minute, 59)) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        if (!this.inBounds(0, second, 59)) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public void setHour(int newHour) {
        if (!this.inBounds(0, newHour, 23)) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        this.hour = newHour;
    }

    public void setMinute(int newMinute) {
        if (!this.inBounds(0, newMinute, 59)) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        this.minute = newMinute;
    }

    public void setSecond(int newSecond) {
        if (!this.inBounds(0, newSecond, 59)) {
            throw new IllegalArgumentException("second must be 0-59");
        }
        this.second = newSecond;
    }

    // ####################### [GET METHODS] #########################

    public int getHour() {
        return this.hour;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getSecond() {
        return this.second;
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", this.getHour(), this.getMinute(), this.getSecond());
    }

    @Override
    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
                getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
    }

    private boolean inBounds(int low, int val, int high) {
        return low <= val && val <= high;
    }
}
