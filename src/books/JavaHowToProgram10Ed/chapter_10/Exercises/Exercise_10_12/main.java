package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_12;

public class main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[4];

        employees[0] = new CommissionEmployee("James", "King", "222-22-2222", 300, 0.6, new Date(2, 12,1996));
        employees[1] = new SalariedEmployee("Antoine", "Jakes", "123-45-6789", 900, new Date(4, 16, 2019));
        employees[2] = new BasePlusCommissionEmployee("Veronique", "Sanders", "893-23-8932", 1782, .4, 900, new Date(4, 6, 1990));
        employees[3] = new HourlyEmployee("Lara", "Johnson", "123-12-2893", 123, 100, new Date(7, 24, 1991));

        int tmpMonth = 4;           // let's assume the current month is 4.

        for (Employee emp : employees) {
            if (emp.getDate().getMonth() == tmpMonth) {
                System.out.printf("Adding $100 as bonus to [%s %s]....\n", emp.getFirstName(), emp.getLastName());

                if (emp instanceof CommissionEmployee) {
                    CommissionEmployee comEmp = (CommissionEmployee) emp;
                    comEmp.setGrossSales(comEmp.getGrossSales() + 100.0);
                }
                else if (emp instanceof SalariedEmployee) {
                    SalariedEmployee salEmp = (SalariedEmployee) emp;
                    salEmp.setWeeklySalary(salEmp.getWeeklySalary() + 100.00);
                }
                else if (emp instanceof HourlyEmployee) {
                    HourlyEmployee hourEmp = (HourlyEmployee) emp;
                    hourEmp.setWage(hourEmp.getWage() + 100.00);
                }
                else {
                    BasePlusCommissionEmployee baseCom = (BasePlusCommissionEmployee) emp;
                    baseCom.setBaseSalary(baseCom.getBaseSalary() + 100.00);
                }
            }
            System.out.println(emp);
        }

    }
}
