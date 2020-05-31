package books.JavaHowToProgram10Ed.chapter_8.Exercise.Exercise_8_18;

import java.math.BigDecimal;
import java.util.Scanner;

public class Exercise_8_18 {

    private static void displayAccounts(Account... accounts) {
        for (Account account : accounts) {
            System.out.printf("%s balance: $%.2f%n", account.getName(), account.getBalance());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("John Blue", -7.53);

        // display initial balance of each object
        displayAccounts(account1, account2);

        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();
        System.out.printf("%nAdding %.2f to account1 balance%n%n", depositAmount);
        account1.deposit(depositAmount);

        // display accounts
        displayAccounts(account1, account2);

        System.out.print("Enter deposit amount for account2: ");
        depositAmount = input.nextDouble();
        System.out.printf("%nAdding %.2f to account2 balance%n%n", depositAmount);
        account2.deposit(depositAmount);

        // display balances
        displayAccounts(account1, account2);
    }
}

class Account {

    private String name;
    private BigDecimal balance;

    public Account(String name, double balance) {
        this.name = name;
        if (balance < 0) {
            this.balance = new BigDecimal(0);
        } else {
            this.balance = new BigDecimal(balance);
        }
    }

    public void deposit(double depositAmount) {
        if (depositAmount > 0.0) {
            this.balance = this.balance.add(new BigDecimal(depositAmount));
        }
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return this.name;
    }

    public double getBalance() {
        return this.balance.doubleValue();
    }
}
