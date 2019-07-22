package books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_16;

import books.JavaHowToProgram10Ed.chapter_10.Exercises.Exercise_10_15.Invoice;

public class PayableInterfaceTest {

    public static void main(String[] args) {
        Payable[] payableObjects = new Payable[2];

        payableObjects[0] = new SalariedEmployee("John", "Smith", "111-11-1111", 800.00);
        payableObjects[1] = new SalariedEmployee("Lisa", "Barnes", "888-88-8888", 1200.00);

        System.out.println("Invoices and Employees processed polymorphically");

        for (Payable currentPayable : payableObjects) {
            System.out.printf("%n%s %n%s: $%,.2f%n", currentPayable.toString(),
                    "payment due", currentPayable.getPaymentAmount());
        }

        System.out.println("Object class: " + payableObjects[0].getClass());
    }
}
