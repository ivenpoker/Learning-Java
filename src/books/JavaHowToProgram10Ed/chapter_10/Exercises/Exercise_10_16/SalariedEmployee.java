package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_16;

public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String firstName, String lastName,
                            String socialSecurityNumber, double weeklySalary) {
        super(firstName, lastName, socialSecurityNumber);
        if (weeklySalary < 0.0)
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0)
            throw new IllegalArgumentException("weekly salary must be >= 0.0");
        this.weeklySalary = weeklySalary;
    }

    public double getWeeklySalary() {
        return this.weeklySalary;
    }

    @Override
    public double earnings() {
        return this.getWeeklySalary();
    }

    @Override
    public String toString() {
        return String.format("salaried employee: %s%n%s: $%,.2f",
                super.toString(), "weekly salary", this.getWeeklySalary());
    }
}
