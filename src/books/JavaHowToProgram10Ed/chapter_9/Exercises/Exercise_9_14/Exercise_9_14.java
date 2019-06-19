package books.JavaHowToProgram10Ed.chapter_9.Exercises.Exercise_9_14;

public class Exercise_9_14 {

    public static void main(String[] args) {

        CommissionEmployee employee = new CommissionEmployee("Sue", "Jones", "222-22-2222", 10000, .06);

        System.out.println("Employee information obtained by get methods:");
        System.out.printf("%n%s %s%n", "First name is", employee.getFirstName() );
        System.out.printf("%s %s%n", "Last name is", employee.getLastName() );
        System.out.printf("%s %s%n", "Social security number is", employee.getSocialSecurityNumber() );
        System.out.printf("%s %.2f%n", "Gross sales is", employee.getGrossSales() );
        System.out.printf("%s %.2f%n", "Commission rate is", employee.getCommissionRate() );employee.setGrossSales(5000);employee.setCommissionRate(.1);
        System.out.printf("%n%s:%n%n %s %n", "Updated employee information obtained by toString", employee);

        System.out.println("\n#############################################\n\n");

        // instantiate BasePlusCommissionEmployee object
        BasePlusCommissionEmployee baseEmploye = new BasePlusCommissionEmployee("Bob", "Lewis", "333-33-3333", 5000, .04, 300);

        System.out.println("Employee information obtained by get methods:%n");
        System.out.printf("%s %s%n", "First name is", baseEmploye.getFirstName());
        System.out.printf("%s %s%n", "Last name is", baseEmploye.getLastName() );
        System.out.printf("%s %s%n", "Social security number is", baseEmploye.getSocialSecurityNumber() );
        System.out.printf("%s %.2f%n", "Gross sales is", baseEmploye.getGrossSales() );
        System.out.printf("%s %.2f%n", "Commission rate is", baseEmploye.getCommissionRate() );
        System.out.printf("%s %.2f%n", "Base salary is", baseEmploye.getBaseSalary());baseEmploye.setBaseSalary(1000);
        System.out.printf("%n%s:%n%n%s%n", "Updated employee information obtained by toString", baseEmploye.toString());
    }
}
