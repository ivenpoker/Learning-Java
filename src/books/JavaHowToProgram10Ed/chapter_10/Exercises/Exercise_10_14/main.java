package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_14;

public class main {

    public static void main(String[] args) {
        Employee[] employees = new Employee[5];

        employees[0] = new CommissionEmployee("James", "King", "222-22-2222", 300, 0.6, new Date(2, 12,1996));
        employees[1] = new SalariedEmployee("Antoine", "Jakes", "123-45-6789", 900, new Date(4, 16, 2019));
        employees[2] = new BasePlusCommissionEmployee("Veronique", "Sanders", "893-23-8932", 1782, .4, 900, new Date(4, 6, 1990));
        employees[3] = new HourlyEmployee("Lara", "Johnson", "123-12-2893", 123, 100, new Date(7, 24, 1991));
        employees[4] = new PieceWorker("Happi", "Yvan", "123-78-8444", 100, 200, new Date(5, 5, 1990));

        for (Employee employee : employees)
            System.out.printf("%s%nEarnings: $%.2f%n",
                    employee.toString(), employee.getPaymentAmount());

    }
}
