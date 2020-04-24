// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 3.15 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 24/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_3.Exercise_3_15;

import java.util.Scanner;

public class AccountTest {

    public static void displayAccount(Account accountToDisplay) {
        System.out.printf("%s balance: $%.2f%n", accountToDisplay.getName(), accountToDisplay.getBalance());
    }
    
    public static void main(String[] args) {
        Account account1 = new Account("Jane Green", 50.00);
        Account account2 = new Account("Jane Blue", -7.53);

        // display initial balance of each object
        displayAccount(account1);
        displayAccount(account2);

        // Create a Scanner to obtain input from the command window
        Scanner input = new Scanner(System.in);

        System.out.print("Enter deposit amount for account1: ");
        double depositAmount = input.nextDouble();

        System.out.printf("%nAdding %.2f to account1 balance%n%n", depositAmount);

        // display balances
        displayAccount(account1);
        displayAccount(account2);

        System.out.print("Enter deposit amount for account2: ");
        depositAmount = input.nextDouble();
        System.out.printf("%nAdding %.2f to account2 balance%n%n", depositAmount);
        account2.deposit(depositAmount);

        // display balances
        displayAccount(account1);
        displayAccount(account2);

    }
}
