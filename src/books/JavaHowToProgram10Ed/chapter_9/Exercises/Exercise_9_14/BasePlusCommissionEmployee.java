// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.14 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_14;

public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber,
         double grossSales, double commissionRate, double baseSalary) {
        super(firstName, lastName, socialSecurityNumber, grossSales, commissionRate);
        if (baseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return this.baseSalary;
    }

    public void setBaseSalary(double newBaseSalary) {
        if (newBaseSalary < 0.0)
            throw new IllegalArgumentException("Base salary must be >= 0.0");
        this.baseSalary = newBaseSalary;
    }

    @Override
    public double earnings() {
        return this.baseSalary + super.earnings();
    }

    public String toString() {
        return String.format(
                "%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f%n%s: %.2f",
                "base-salaried commission employee" , super.getFirstName(), super.getLastName(),
                "social security number", super.getSocialSecurityNumber(),
                "gross sales", super.getGrossSales(), "commission rate", super.getCommissionRate(),
                "base salary", this.getBaseSalary() );
    }


}
