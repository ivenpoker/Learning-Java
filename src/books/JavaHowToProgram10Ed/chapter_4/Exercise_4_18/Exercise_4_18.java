// ####################################################################################
// #                                                                                  #
// #      Program Purpose: Answers the question 4.18 from book.                       #
// #      Program Author : Happi Yvan <ivensteinpoker@gmail.com>                      #
// #      Program Date   : 26/05/2019                                                 #
// #                                                                                  #
// ####################################################################################

package books.JavaHowToProgram10Ed.chapter_4.Exercise_4_18;

import java.util.Scanner;

public class Exercise_4_18 {

    public static void main(String[] args) {
        Customer customer = new Customer("DEF73SD", 200, 12, 5000);

        System.out.printf("Customer ID: %s\n", customer.getAccountNumber());
        System.out.printf("Customer balance: %.2f\n", customer.getInitialBalance());
        System.out.printf("Customer items charged count: %d\n", customer.getItemsChargedCount());
        System.out.printf("Customer allowed credit: $%.2f\n", customer.getAllowedCredit());
        System.out.printf("Customer limit exceeded: %s\n", (customer.getInitialBalance() > customer.getAllowedCredit()) ? "YES" : "NO");

        System.out.printf("----------------------------------\n");
        customer.setNewBalance(100000);
        System.out.printf("Customer limit exceeded: %s\n", (customer.getInitialBalance() > customer.getAllowedCredit()) ? "YES" : "NO");


    }
}
