package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_16;

public class HourlyEmployee extends Employee {
    private double wage;
    private double hours;

    public HourlyEmployee(String firstName, String lastName,
                          String socialSecurityNumber, double wage, double hours) {
        super(firstName, lastName, socialSecurityNumber);
        if (wage < 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        if (hours < 0.0 || (hours > 168.0))
            throw new IllegalArgumentException("Hours worked be >= 0.0 and <= 168.0");
        this.wage = wage;
        this.hours = hours;
    }

    public void setWage(double wage) {
        if (wage < 0.0)
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        this.wage = wage;
    }

    public void setHours(double hours) {
        if ((hours < 0.0) || (hours > 168.0))
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        this.hours = hours;
    }

    public double getHours() {
        return this.hours;
    }

    public double getWage() {
        return this.wage;
    }

    @Override
    public double earnings() {
        if (this.getHours() <= 40)
            return this.getHours() * this.getWage();
        else
            return 40 * this.getWage() + (this.getHours() - 40) * this.getWage() * 1;
    }

    @Override
    public String toString() {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
                super.toString(), "hourly wage", this.getWage(),
                "hours worked", this.getHours());
    }
}
