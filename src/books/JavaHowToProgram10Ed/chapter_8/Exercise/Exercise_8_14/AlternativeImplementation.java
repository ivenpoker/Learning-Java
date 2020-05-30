package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_14;

public class AlternativeImplementation {

    private static void printDate(AltDate date) {
        System.out.printf("%10s: %s%n", "Date 1", date);
        System.out.printf("%10s: %s%n", "Date 2", date.getDateMMDDYYY());
        System.out.printf("%10s: %s%n", "Date 3", date.getDateDDDYYYY());
        System.out.printf("%10s: %s%n", "Date 4", date.getDatePretty());

    }

    public static void main(String[] args) {

        AltDate date1 = new AltDate(3, 3, 2010);
        printDate(date1);
        System.out.println();

        AltDate date2 = new AltDate(2, 1998);
        printDate(date2);
        System.out.println();

        AltDate date3 = new AltDate("May", 21, 2020);
        printDate(date3);
    }

}

class AltDate {

    private int month;                  // 1-12
    private int day;                    // 1-31 based on month
    private int year;                   // an year

    public static final int MIN_YEAR = 1970;
    public static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final String[] monthNames =
            {"", "January", "February", "March", "April", "May", "June", "July", "August",
                "September", "October", "November", "December"};

    public AltDate(String monthName, int day, int year) {

        // If month name is not a valid month name
        int idx = this.isMonthFound(monthName);
        if (idx == -1) {
            throw new IllegalArgumentException("Invalid month name");
        }
        this.month = idx;

        this.validateDay(day);
        this.validateYear(year);

        this.day = day;
        this.year = year;
    }

    public AltDate(int month, int day, int year) {

        this.validateMonth(month);
        this.month = month;

        this.validateDay(day);
        this.leapYearValidation(day, month);
        this.validateYear(year);

        this.day = day;
        this.year = year;
    }

    public AltDate(int day, int year) {
        // Here we'll use a default month of 1
        this.month = 1;

        this.validateDay(day);
        this.validateYear(year);

        this.day = day;
        this.year = year;
    }

    private int isMonthFound(String nameToCheck) {

        // Just checks if month name is valid.
        for (int i = 0; i < AltDate.monthNames.length; i++) {
            if (AltDate.monthNames[i].toLowerCase().equals(nameToCheck.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    private void validateMonth(int month) {
        // check if month in range
        if (!this.inRange(0, month, 12)) {
            throw new IllegalArgumentException(String.format("month '%d' must be 1-12", month));
        }
    }

    private void validateDay(int day) {
        // check if day in range for month
        if (day <= 0 ||
                (day > daysPerMonth[month] && !(month == 2 && day == 29))) {
            throw new IllegalArgumentException(
                    String.format("day (%d) out-of-range for the specified month and year", day));
        }
    }

    private void leapYearValidation(int day, int month) {
        // check for leap year if month is 2 and day is 29
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 ==0 && year % 100 != 0))) {
            throw new IllegalArgumentException(
                    String.format("day (%d) out-of-range for the specified month and year", day));
        }
    }

    private void validateYear(int year) {
        // Validation for year.
        if (year < MIN_YEAR) {
            throw new IllegalArgumentException(
                    String.format("year(%d) is out-of-range must be > %d", year, MIN_YEAR));
        }
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

    public String getDateMMDDYYY() {
        return String.format("%02d/%02d/%d", this.month, this.day, this.year);
    }

    public String getDatePretty() {
        return String.format("%s %d, %d", AltDate.monthNames[this.month], this.day, this.year);
    }

    public String getDateDDDYYYY() {
        return String.format("%d %d", this.day, this.year);
    }

    @Override
    public String toString() {
        return this.getDatePretty();
    }

}