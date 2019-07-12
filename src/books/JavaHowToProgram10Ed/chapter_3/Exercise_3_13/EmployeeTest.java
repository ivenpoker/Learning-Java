// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.13 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_13;

public class EmployeeTest {

    public static void main(String[] args) {
        Employee employee1 = new Employee("Happi", "Yvan", 300000);
        Employee employee2 = new Employee("James", "King", 20000);

        // Display the employees data...
        System.out.printf("\nEmployee1: [name: %s %s] [salary: $%.2f]\n",
                employee1.getFirstName(), employee1.getLastName(), employee1.getMonthlySalary());
        System.out.printf("Employee2: [name: %s %s] [salary: $%.2f]\n\n",
                employee2.getFirstName(), employee2.getLastName(), employee2.getMonthlySalary());

        // Displaying each employee's yearly salary
        System.out.printf("Employee1 yearly salary: $%.2f\n", 12 * employee1.getMonthlySalary());
        System.out.printf("Employee2 yearly salary: $%.2f\n\n", 12 * employee2.getMonthlySalary());

        // Giving each employee a 10% salary raise
        employee1.setMonthlySalary((((0.1) * employee1.getMonthlySalary()) + employee1.getMonthlySalary()));
        employee2.setMonthlySalary(((0.1) * employee2.getMonthlySalary()) + employee2.getMonthlySalary());

        // Displaying each employee's salary (with raise)
        System.out.println("After a 10% salary raise....\n");
        System.out.printf("Employee1 yearly salary: $%.2f\n", 12 * employee1.getMonthlySalary());
        System.out.printf("Employee2 yearly salary: $%.2f\n", 12 * employee2.getMonthlySalary());

    }
}
