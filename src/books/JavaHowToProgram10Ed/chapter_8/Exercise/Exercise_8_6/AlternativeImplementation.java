package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_6;

public class AlternativeImplementation {

    public static void main(String[] args) {

        AltSavingsAccount saver1 = new AltSavingsAccount(2000);
        AltSavingsAccount saver2 = new AltSavingsAccount(3000);

        // Set annual interest rate to 4% for all Savings Accounts
        AltSavingsAccount.modifyInterestRate(0.04);

        // Calculate the monthly interest for 12 months
        for (int i = 0; i < 12; i++) {
            saver1.setSavingsBalance(saver1.calculateMonthlyInterest());
            saver2.setSavingsBalance(saver1.calculateMonthlyInterest());
        }

        // Display new balances for both saver after computations
        System.out.printf("Saver 1 balance: $%,.2f%n", saver1.getSavingsBalance());
        System.out.printf("Saver 2 balance: $%,.2f%n", saver2.getSavingsBalance());

    }

}

class AltSavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public AltSavingsAccount() {
        this(0.0);
    }

    public AltSavingsAccount(double savingsBalance) {
        this.savingsBalance = savingsBalance;
    }

    public void setSavingsBalance(double newSavingsBalance) {
        this.savingsBalance = newSavingsBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public double calculateMonthlyInterest() {
        return ((this.savingsBalance * annualInterestRate) / 12) + this.savingsBalance;
    }

    public static void modifyInterestRate(double newAnnualInterestRate) {
        annualInterestRate = newAnnualInterestRate;
    }
}