// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.4 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_3;

public class CommissionEmployee extends Object {

    private final String _firstName;
    private final String _lastName;
    private final String _socialSecurityNumber;
    private double _grossSales;
    private double _commissionRate;

    public CommissionEmployee(String firstName, String lastName,
                String socialSecurityNumber, double grossSales,
                double commissionRate) {
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross Sales must be >= 0.0");
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

        this._firstName = firstName;
        this._lastName  = lastName;
        this._socialSecurityNumber = socialSecurityNumber;
        this._grossSales = grossSales;
        this._commissionRate = commissionRate;
    }

    public String getFirstName() {
        return this._firstName;
    }

    public String getLastName() {
        return this._lastName;
    }

    public String getSocialSecurityNumber() {
        return this._socialSecurityNumber;
    }

    public void setGrossSales(double grossSales) {
        if (grossSales < 0.0)
            throw new IllegalArgumentException("Gross sales must >= 0.0");
        this._grossSales = grossSales;
    }

    public double getGrossSales() {
        return this._grossSales;
    }

    public double getCommissionRate() {
        return this._commissionRate;
    }

    public void setCommissionRate(double commissionRate) {
        if (commissionRate <= 0.0 || commissionRate >= 1.0)
            throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");
        this._commissionRate = commissionRate;
    }

    public double earnings() {
        return this._commissionRate * this._grossSales;
    }

    @Override
    public String toString() {
        return String.format("%s: %s %s%n%s: %s%n%s: %.2f%n%s: %.2f",
                "commission employee", this._firstName, this._lastName,
                "social security number", this._socialSecurityNumber,
                "gross sales", this._grossSales,
                "commission rate", this._commissionRate);
    }

}
