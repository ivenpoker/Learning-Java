// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.3 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_3;

public class BasePlusCommissionEmployee {

    private final CommissionEmployee _commissionEmployee;
    private double _baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName,
                                      String socialSecurityNumber, double grossSales,
                                      double commissionRate, double baseSalary) {
        this._commissionEmployee = new CommissionEmployee(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        this._baseSalary = baseSalary;
    }

    public String getFirstName() {
        return this._commissionEmployee.getFirstName();
    }

    public String getLastName() {
        return this._commissionEmployee.getLastName();
    }

    public String getSocialSecurityNumber() {
        return this._commissionEmployee.getSocialSecurityNumber();
    }

    public void setGrossSales(double grossSales) {
        this._commissionEmployee.setGrossSales(grossSales);
    }

    public double getGrossSales() {
        return this._commissionEmployee.getGrossSales();
    }

    public void setCommissionRate(double commissionRate) {
        this._commissionEmployee.setCommissionRate(commissionRate);
    }

    public double getCommissionRate() {
        return this._commissionEmployee.getCommissionRate();
    }

    public void setBaseSalary(double newBaseSalary) {
        if (newBaseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        this._baseSalary = newBaseSalary;
    }

    public double getBaseSalary() {
        return this._baseSalary;
    }

    public double earnings() {
        return this._baseSalary + (this._commissionEmployee.getCommissionRate() *
                this._commissionEmployee.getGrossSales());
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f",
                "base-salaried commission employee", this.getFirstName(), this.getLastName(),
                "social security number", this.getSocialSecurityNumber(),
                "gross sales", this.getGrossSales(), "commission rate", this.getCommissionRate(),
                "base salary", this.getBaseSalary());
    }
}
