package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_5;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltTime2 time1 = new AltTime2();
        AltTime2 time2 = new AltTime2(1, 45, 20);
        AltTime2 time3 = new AltTime2(12, 43, 12);

        System.out.printf("AltTime 1: %s%n", time1);
        System.out.printf("AltTime 2: %s%n", time2);
        System.out.printf("AltTime 3: %s%n", time3);

        time1.setHour(time1.getHour() + 1);                 // Add an hour to 'time1'
        time2.setMinute(time2.getMinute() - 5);             // subtract 5 minutes from 'time2'
        time3.setSecond(time3.getSecond() * 2);             // multiply the number of seconds of 'time3' by 2

        System.out.println("\n============== [UPDATED TIME] ================\n");

        System.out.printf("[UPDATED] AltTime 1: %s%n", time1);
        System.out.printf("[UPDATED] AltTime 2: %s%n", time2);
        System.out.printf("[UPDATED] AltTime 3: %s%n", time3);

    }
}

class AltTime2 {
    private int totalSeconds;

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
        this.totalSeconds = (hour * 60 * 60) + (minute * 60) + second;
    }

    public void setAltTime(int hour, int minute, int second) {
        this.totalSeconds = (hour * 60 * 60) + (minute * 60) + second;
    }

    public void setHour(int newHour) {
        if (!this.inBounds(0,  newHour,23)) {
            throw new IllegalArgumentException("hour must be 0-23");
        }
        int minuteBackup = this.getMinute();        // backup our number of minutes
        int secondBackup = this.getSecond();        // backup our number of seconds

        this.totalSeconds += (newHour * 60 * 60) + (minuteBackup * 60) + secondBackup;
    }

    public void setMinute(int newMinute) {
        if (!this.inBounds(0, newMinute, 59)) {
            throw new IllegalArgumentException("minute must be 0-59");
        }
        int hourBackup = this.getHour();            // backup our number of hours
        int secondBackup = this.getSecond();        // backup our number of seconds

        // set total seconds to reflect updated minute (which is converted to seconds)
        this.totalSeconds = (hourBackup * 60 * 60) + (newMinute * 60) + secondBackup;
    }

    public void setSecond(int newSecond) {
        if (!this.inBounds(0, newSecond, 59)) {
            throw new IllegalArgumentException("seconds must be 0-59");
        }
        int hourBackup = this.getHour();            // backup our number of hours
        int minuteBackup = this.getMinute();        // backup our number of minutes

        // set total seconds  to reflect update second (which is added at the end below)
        this.totalSeconds = (hourBackup * 60 * 60) + (minuteBackup * 60) + newSecond;
    }

    public int getHour() {
        int hour = 0;
        int tmpTotalSeconds = this.totalSeconds;

        while (tmpTotalSeconds >= 3600) {           // while seconds >= 1 hour (36000 secs)
            hour += 1;
            tmpTotalSeconds -= 3600;
        }
        return hour;
    }

    public int getMinute() {
        int hourlySeconds = this.getHour() * 60 * 60;
        int remainingTotSecs = this.totalSeconds - hourlySeconds;
        int minutes = 0;

        while (remainingTotSecs >= 60) {
            minutes += 1;
            remainingTotSecs -= 60;
        }
        return minutes;
    }

    public int getSecond() {
        int hourlySeconds = this.getHour() * 60 * 60;
        int minuteSeconds = this.getMinute() * 60;

        return this.totalSeconds - (hourlySeconds + minuteSeconds);
    }

    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", this.getHour(), this.getMinute(), this.getSecond());
    }

    public String toString() {
        return String.format("%d:%02d:%02d %s",
                ((this.getHour() == 0 || this.getHour() == 12) ? 12 : this.getHour() % 12),
                    this.getMinute(), this.getSecond(), (this.getHour() < 12 ? "AM" : "PM"));
    }

    private boolean inBounds(int low, int val, int high) {
        return low <= val && val <= high;
    }
}