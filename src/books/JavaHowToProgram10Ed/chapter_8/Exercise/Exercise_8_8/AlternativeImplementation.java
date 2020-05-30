package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_8;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltDate date = new AltDate(1, 21, 2020);
        System.out.printf("%20s: %s%n", "Original date", date);

        // Incrementing day 10 times
        for (int i = 0; i < 10; i++) {
            date.nextDay();
        }
        System.out.printf("%20s: %s%n", "After 10 days shift", date);

        // Incrementing should move to next month and next day
        // should be 1.
        date.nextDay();
        System.out.printf("%20s: %s%n", "New month and day", date);

        System.out.println("==============================");

        // Last day of last month (Dec 31)
        AltDate date2 = new AltDate(12, 31, 2020);
        System.out.printf("%20s: %s%n", "New date", date2);

        // Next day should be the next year and 1st month
        date2.nextDay();
        System.out.printf("%20s: %s%n", "After next day", date2);
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
