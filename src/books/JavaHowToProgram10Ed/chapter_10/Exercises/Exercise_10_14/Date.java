package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_14;

public class Date {

    private int month;
    private int day;
    private int year;

    public static final int[] daysPerMonth =
            { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public Date(int month, int day, int year) {
        if (month <= 0 || month > 12)
            throw new IllegalArgumentException("month [" + month + "] must be 1-12");
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");
        if (month == 2 && day == 29 && !(year % 400 == 0 ||  (year % 4 == 0 && year % 100 != 0)))
            throw new IllegalArgumentException("day (" + day + ") out-of-range for the specified month and year");

        this.month = month;
        this.year  = year;
        this.day   = day;

    }

    public int getMonth() {
        return this.month;
    }

    public String toString() {
        return String.format("%d/%d/%d", this.month, this.day, this.year);
    }
}
