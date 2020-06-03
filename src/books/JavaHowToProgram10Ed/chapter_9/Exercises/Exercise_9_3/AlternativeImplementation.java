package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_3;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltBasePlusCommissionEmployee employee = new AltBasePlusCommissionEmployee("Bob", "Lewis",
                "333-33-3333", 5000, .04, 300);

        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommisionRate());
        System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary());

        employee.setBaseSalary(1000);
        System.out.printf("%s:%n%n%s%n",
                "Updated employee information obtained by toString",
                employee.toString());
    }
}

class AltBasePlusCommissionEmployee {
    private AltCommissionEmployee commissionEmployee;
    private double baseSalary;

    public AltBasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
                                         double grossSales, double commissionRate, double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException(String.format("Invalid base salary (%.2f)", baseSalary));
        }
        this.baseSalary = baseSalary;
        this.commissionEmployee = new AltCommissionEmployee(firstName, lastName, socialSecurityNumber,
                                                grossSales, commissionRate);
    }

    // ################################# [GET METHODS] #################################

    public String getFirstName() {
        return this.commissionEmployee.getFirstName();
    }

    public String getLastName() {
        return this.commissionEmployee.getLastName();
    }

    public String getSocialSecurityNumber() {
        return this.commissionEmployee.getSocialSecurityNumber();
    }

    public double getCommisionRate() {
        return this.commissionEmployee.getCommissionRate();
    }

    public double getGrossSales() {
        return this.commissionEmployee.getGrossSales();
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public double earnings() {
        return this.getBaseSalary() + this.commissionEmployee.earnings();
    }

    // ################################# [SET METHODS] ################################

    public void setFirstName(String firstName) {
        this.commissionEmployee.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
        this.commissionEmployee.setLastName(lastName);
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.commissionEmployee.setSocialSecurityNumber(socialSecurityNumber);
    }

    public void setCommissionRate(double commissionRate) {
        this.commissionEmployee.setCommissionRate(commissionRate);
    }

    public void setGrossSales(double grossSales) {
        this.commissionEmployee.setGrossSales(grossSales);
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0.0) {
            throw new IllegalArgumentException(String.format("Invalid base salary (%.2f). Must be > 0.0",
                    baseSalary));
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f",
                "base-salaried commission employee", this.getFirstName(), this.getLastName(),
                "social security number", this.getSocialSecurityNumber(),
                "gross sales", this.getGrossSales(), "commission rate", this.getCommisionRate(),
                "base salary", this.getBaseSalary());
    }

}

class AltCommissionEmployee {

    private String firstName;
    private String lastName;
    private String socialSecurityNumber;
    private double grossSales;
    private double commissionRate;

    public AltCommissionEmployee(String firstName, String lastName,
                              String socialSecurityNumber, double grossSales,
                              double commissionRate) {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.socialSecurityNumber = socialSecurityNumber;
        this.grossSales = grossSales;
        this.commissionRate = commissionRate;
    }

    // #################### [GET METHODS] ######################

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getSocialSecurityNumber() {
        return this.socialSecurityNumber;
    }

    public double getGrossSales() {
        return this.grossSales;
    }

    public double getCommissionRate() {
        return this.commissionRate;
    }

    // #################### [SET METHODS] ######################

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0) {
            throw new IllegalArgumentException("Gross sales must be >= 0.0");
        }
        this.grossSales = grossSales;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0) {
            throw new IllegalArgumentException("Commission rate must be > 0.0 and 1.0");
        }
        this.commissionRate = commissionRate;
    }

    public double earnings() {
        return this.getCommissionRate() * this.getGrossSales();
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
                "commission employee", this.getFirstName(), this.getLastName(),
                "social security number", this.getSocialSecurityNumber(),
                "gross sales", this.getGrossSales(),
                "commission rate", this.getCommissionRate());

    }
}
