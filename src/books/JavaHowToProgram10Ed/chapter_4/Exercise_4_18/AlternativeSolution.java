package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_18;

import java.util.Scanner;

public class AlternativeSolution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter account number [-1 to quit]: ");
        int accountNum = input.nextInt();

        while (accountNum != -1) {
            System.out.print("Enter balance at the beginning of the month: ");
            int balanceAtStart = input.nextInt();

            System.out.print("Enter total of all items charged this month: ");
            int totalChargedThisMonth = input.nextInt();

            System.out.print("Enter total of all credits applied to the customer's account this month: ");
            int totalCreditApplied = input.nextInt();

            System.out.print("Enter allowed credit limit: ");
            int creditLimit = input.nextInt();

            int newBalance = balanceAtStart + totalChargedThisMonth - totalCreditApplied;
            System.out.printf("[=== NEW BALANCE: $%d ===]%n", newBalance);

            if (totalChargedThisMonth > creditLimit) {
                System.out.print("[=== Credit limit exceeded ===]");
            }
            System.out.println("\n");

            System.out.print("Enter account number [-1 to quit]: ");
            accountNum = input.nextInt();
        }
    }
}
