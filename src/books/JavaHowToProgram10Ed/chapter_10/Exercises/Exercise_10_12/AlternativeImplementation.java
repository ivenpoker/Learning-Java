package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_12;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltEmployee[] employees = new AltEmployee[4];
        employees[0] = new AltHourlyEmployee("James", "King",
                "111-11-1111", 190, 123, new AltDate(2, 23, 1984));
        employees[1] = new AltSalariedEmployee("Suzanne", "Krook", "222-22-2222",
                590, 180, new AltDate(4, 12, 1992));
        employees[2] = new AltCommissionEmployee("King", "Kong", "333-33-3333",
                    300.0, .4, new AltDate(11, 1, 1990));
        employees[3] = new AltBasePlusCommissionEmployee("James", "Bond", "444-44-4444",
                            300.0, 0.4, 200, new AltDate(1, 1, 1981));

        AltDate currDate = new AltDate(1, 1,1981);

        // Display each employee details
        for (AltEmployee employee : employees) {
            if (employee.getBirthDate().toString().equals(currDate.toString())) {

                if (employee instanceof AltHourlyEmployee) {
                    AltHourlyEmployee coreEmployee = (AltHourlyEmployee) employee;
                    coreEmployee.setWage(coreEmployee.getWage() + 100);

                } else if (employee instanceof AltSalariedEmployee) {
                    AltSalariedEmployee coreEmployee = (AltSalariedEmployee) employee;
                    coreEmployee.setWeeklySalary(coreEmployee.getWeeklySalary() + 100);

                } else  if (employee instanceof AltCommissionEmployee) {
                    AltCommissionEmployee coreEmployee = (AltCommissionEmployee) employee;
                    coreEmployee.setGrossSales(coreEmployee.getGrossSales() + 100);

                } else {
                    AltBasePlusCommissionEmployee coreEmployee = (AltBasePlusCommissionEmployee) employee;
                    coreEmployee.setBaseSalary(coreEmployee.getBaseSalary() + 100);
                }
            }
            System.out.println(employee);
        }

    }

}

abstract class AltEmployee {
    private final String firstName;
    private final String lastName;
    private final String socialSecurityNumber;
    private final AltDate birthDate;

    public AltEmployee(String firstName, String lastName, String socialSecurityNumber, AltDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.birthDate = birthDate;
    }

    // ###################### [GET METHOD] ############################

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public AltDate getBirthDate() {
        return this.birthDate;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("%s %s%nsocial security number: %s",
                this.getFirstName(), this.getLastName(), this.getSocialSecurityNumber());
    }

    public abstract double earnings();
}

class AltSalariedEmployee extends AltEmployee {
    private double weeklySalary;

    public AltSalariedEmployee(String firstName, String lastName,
                               String socialSecurityNumber, int salary, double weeklySalary, AltDate birthDate) {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }
        this.weeklySalary = weeklySalary;
    }

    public void setWeeklySalary(double weeklySalary) {
        if (weeklySalary < 0.0) {
            throw new IllegalArgumentException("Weekly salary must be >= 0.0");
        }
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
        return String.format("salaried employee: %s%n%s: $%,.2f", super.toString(),
                "weekly salary", this.getWeeklySalary());
    }
}

class AltHourlyEmployee extends AltEmployee {
    private double wage;
    private double hours;

    public AltHourlyEmployee(String firstName, String lastName,
                             String socialSecurityNumber, double wage,
                             double hours, AltDate birthDate) {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        if (wage < 0.0) {
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }
        if ((hours < 0.0) || (hours > 168.0)) {
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and 168.0");
        }
        this.wage = wage;
        this.hours = hours;
    }

    public void setWage(double wage) {
        if (wage < 0.0) {
            throw new IllegalArgumentException("Hourly wage must be >= 0.0");
        }
        this.wage = wage;
    }

    public double getWage() {
        return this.wage;
    }

    public void setHours(double hours) {
        if ((hours < 0.0) || (hours > 168.0)) {
            throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");
        }
        this.hours = hours;
    }

    public double getHours() {
        return this.hours;
    }

    @Override
    public double earnings() {
        if (this.getHours() <= 40) {
            return this.getWage() * this.getHours();
        } else {
            return 40 * this.getWage() + (this.getHours() - 40) * this.getWage() * 1.5;
        }
    }

    @Override
    public String toString() {
        return String.format("hourly employee: %s%n%s: $%,.2f; %s: %,.2f",
                super.toString(), "hourly wage", this.getWage(),
                "hours worked", this.getHours());
    }
}

class AltCommissionEmployee extends AltEmployee {
    private double grossSales;
    private double commissionRate;

    public AltCommissionEmployee(String firstName, String lastName,
                                 String socialSecurityNumber, double grossSales,
                                 double commissionRate, AltDate birthDate) {
        super(firstName, lastName, socialSecurityNumber, birthDate);
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must b >= 0.0");
        }
        this.grossSales = grossSales;
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
        this.commissionRate = commissionRate;
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    @Override
    public double earnings() {
        return this.getCommissionRate() * this.getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n%s: $%,.2f; %s: %.2f",
                "commission employee", super.toString(),
                "gross sales", this.getGrossSales(),
                "commission rate", this.getCommissionRate());
    }
}

class AltBasePlusCommissionEmployee extends AltCommissionEmployee {
    private double baseSalary;

    public AltBasePlusCommissionEmployee(String firstName, String lastName,
                                         String socialSecurityNumber, double grossSales,
                                         double commissionRate, double baseSalary, AltDate birthDate) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate, birthDate);
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0");
        }
        this.baseSalary = baseSalary;

    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        }
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    @Override
    public double earnings() {
        return this.getBaseSalary() * super.earnings();
    }

    @Override
    public String toString() {
        return String.format("%s %s; %s: $%,.2f",
                "base-salaried", super.toString(),
                "base salary", this.getBaseSalary());
    }
}

class AltDate {
    private final int month;
    private final int day;
    private final int year;

    private static final int[] daysPerMonth =
            {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public AltDate(int month, int day, int year) {
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(String.format("month (%d) must be 1-12", month));
        }
        if (day <= 0 ||
                (day > daysPerMonth[month] & !(month == 2 && day == 29))) {
            throw new IllegalArgumentException(String.format("day (%d) out-of-range for the specified month and year",
                    day));
        }
        if (month == 2 && day == 29 && !(year % 400 == 0 ||
                (year % 4 == 0 && year % 100 != 0))) {
            throw new IllegalArgumentException(String.format("day (%d) out-of-range for the specified month and year",
                    day));
        }
        this.month = month;
        this.day = day;
        this.year = year;

    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public int getYear() {
        return this.year;
    }

    @Override
    public String toString() {
        return String.format("%d/%d/%d", this.month, this.day, this.year);
    }
}






















































