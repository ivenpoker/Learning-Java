// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.13 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_13;

public class Employee {

    private String _firstName;
    private String _lastName;
    private double _monthlySalary;

    public Employee(String _firstName, String _lastName, double _monthlySalary) {
        this._firstName = _firstName;
        this._lastName  = _lastName;

        if (_monthlySalary > 0.0)
            this._monthlySalary = _monthlySalary;
    }
    public void setFirstName(String _newFirstName) {
        this._firstName  =_firstName;
    }
    public void setLastName(String _newLastName) {
        this._lastName = _lastName;
    }
    public void setMonthlySalary(double _newMonthlySalary) {
        if (_newMonthlySalary > 0.0)
            this._monthlySalary = _newMonthlySalary;
    }
    public String getFirstName() {
        return this._firstName;
    }
    public String getLastName() {
        return this._lastName;
    }
    public double getMonthlySalary() {
        return this._monthlySalary;
    }
}
