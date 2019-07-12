// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 9.3 from book.                        #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 19/06/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_3;

public class Exercise_9_3 {

    public static void main(String[] args) {

        BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Bob", "Lewis",
                "333-33-3333", 5000, 0.04, 300);
        System.out.println("Employee information obtained by get methods:%n");
        System.out.printf("%s %s%n", "First name is", employee.getFirstName());
        System.out.printf("%s %s%n", "Last name is", employee.getLastName());
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber());
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales());
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate());
        System.out.printf("%s %.2f%n", "Base salary is", employee.getBaseSalary());employee.setBaseSalary(1000);
        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", employee.toString());

    }
}
