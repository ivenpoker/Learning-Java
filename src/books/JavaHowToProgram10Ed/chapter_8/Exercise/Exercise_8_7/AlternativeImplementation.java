package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_7;

public class AlternativeImplementation {

    public static void main(String[] args) {

        // JUST SOME TEST CODE HERE

        AltTime2 time2 = new AltTime2(23, 58, 59);
        System.out.printf("%15s: %s%n", "Original time", time2);

        time2.tick();   // increment seconds
        System.out.printf("%15s: %s%n", "After a tick", time2);

        // Perform 59 ticks
        for (int i = 0; i < 59; i++) {
            time2.tick();
        }
        System.out.printf("%15s: %s%n", "After 59 ticks", time2);

        // This tick should shift date to next day
        time2.tick();
        System.out.printf("%15s: %s%n", "Final tick", time2);

        System.out.println("==================================");

        // ADD 25 MINUTES TO THE TIME

        for (int i = 0; i < 25; i++) {
            time2.incrementMinute();
        }
        System.out.printf("%s: %s%n", "After adding 25 mins", time2);

        // ADD 5 HOURS TO THE CURRENT TIME

        for (int i = 0; i < 5; i++) {
            time2.incrementHour();
        }
        System.out.printf("%s: %s%n", "After adding 5 hours", time2);

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

    public void incrementHour() {
        if (this.hour == 23) {
            this.minute = 0;
            this.hour = 0;
        } else {
            this.hour += 1;
        }
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






























