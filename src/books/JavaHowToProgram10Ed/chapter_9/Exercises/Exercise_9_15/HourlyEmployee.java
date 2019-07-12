// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.15 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_15;

import books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_14.Employee;

public class HourlyEmployee extends Employee {

    private double hours;
    private double wage;

    public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber,
           double hourlyWage, double hoursWorked) {
        super(firstName, lastName, socialSecurityNumber);
        if (hourlyWage < 0.0)
            throw new IllegalArgumentException("Invalid hourly wage");
        if (hoursWorked < 0 || hoursWorked > 168)
            throw new IllegalArgumentException("Invalid hours worked");
        this.hours = hoursWorked;
        this.wage  = hourlyWage;
    }

    public void setHourlyWage(double newHourlyWage) {
        if (newHourlyWage < 0.0 || newHourlyWage > 168)
            throw new IllegalArgumentException("Invalid hourly wage");
        this.hours = newHourlyWage;
    }

    public double getHourlyWage() {
        return this.wage;
    }

    public void setHoursWorked(double newNumberOfHoursWorked) {
        if (newNumberOfHoursWorked < 0)
            throw new IllegalArgumentException("Invalid number of hours worked");
        this.hours = newNumberOfHoursWorked;
    }

    public double getHoursWorked() {
        return this.hours;
    }

    public double earnings() {
        return this.getHourlyWage() * 1.5 * this.getHoursWorked();
    }

    @Override
    public String toString() {
        return String.format("%s\nHourly wage: $%.2f\nHours worked: %.2f",
                super.toString(), this.getHourlyWage(), this.getHoursWorked());
    }
}
