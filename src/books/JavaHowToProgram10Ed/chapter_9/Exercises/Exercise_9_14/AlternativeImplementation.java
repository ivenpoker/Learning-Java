package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_14;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltCommissionEmployee employee = new AltCommissionEmployee("Sue", "Jones",
                "222-22-2222", 1000, 0.06);

        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());

        employee.setGrossSales(5000);
        employee.setCommissionRate(.1);

        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee);
        System.out.println("\n");

        AltBasePlusCommissionEmployee employee1 = new AltBasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333",
                5000, 0.04, 300);

        // get base-salaried commission employee data
        System.out.println("Employee information obtained by methods:%n");
        System.out.printf("%s %s%n", "First name is", employee1.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee1.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee1.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee1.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee1.getCommissionRate());
        System.out.printf("%s %.2f%n", "Base salary is", employee1.getBaseSalary());

        employee1.setBaseSalary(1000);

        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString()", employee);

    }
}

class AltCommissionEmployee extends AltEmployee {
    private double grossSales;
    private double commissionRate;

    public AltCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                 double grossSales, double commissionRate) {
        super(firstName, lastName, socialSecurityNumber);
        this.setGrossSales(grossSales);
        this.setCommissionRate(commissionRate);
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException(String.format("Invalid gross sales (%.2f). Must be > 0", grossSales));
        }
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate < 0.0) {
            throw new IllegalArgumentException(String.format("Invalid gross sales (%.2f). Must be > 0", commissionRate));
        }
        this.commissionRate = commissionRate;
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    public double earnings() {
        return this.getCommissionRate() * this.getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %.2f%n%s: %.2f%n%s: %.2f%n", super.toString(), "Gross Sales", this.getGrossSales(),
                "Commission Rate", this.getCommissionRate(), "Earnings", this.earnings());
    }
}

class AltBasePlusCommissionEmployee extends AltCommissionEmployee {
    private double baseSalary;

    public AltBasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                         double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException(String.format("Invalid base salary (%.2f). Must be > 0", baseSalary));
        }
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s: %.2f%n", super.toString(), "Base Salary", this.getBaseSalary());
    }
}

class AltEmployee {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;

    public AltEmployee(String firstName, String lastName, String socialSecurityNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n", "Name", this.getFirstName(), this.getLastName(),
                "Social SN", this.getSocialSecurityNumber());
    }
}
