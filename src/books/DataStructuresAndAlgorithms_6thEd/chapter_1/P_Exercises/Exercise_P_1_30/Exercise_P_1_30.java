// #############################################################################
// #                                                                           #
// #      Program purpose: Solution to Exercise P.1.30 in Book                 #
// #      Program author : Happi Yvan <ivensteinpoker@gmail.com>               #
// #      Program Date   : 1/06/2019                                           #
// #                                                                           #
// #############################################################################

package books.DataStructuresAndAlgorithms_6thEd.chapter_1.P_Exercises.Exercise_P_1_30;

import javax.swing.JOptionPane;

public class Exercise_P_1_30 {

    public static CreditCard obtainsUserCreditCardInfo() {
        String customerName = JOptionPane.showInputDialog(null, "Enter your name",
                "Name", JOptionPane.QUESTION_MESSAGE);
        while (customerName.trim().isEmpty())
            customerName = JOptionPane.showInputDialog(null, "Please enter your name",
                    "Name", JOptionPane.ERROR_MESSAGE);

        String bankName = JOptionPane.showInputDialog(null, "Enter bank name",
                "Bank name", JOptionPane.QUESTION_MESSAGE);
        while (bankName.trim().isEmpty())
            bankName = JOptionPane.showInputDialog(null, "Please enter valid bank name",
                    "Bank name", JOptionPane.ERROR_MESSAGE);

        String accountName = JOptionPane.showInputDialog(null, "Enter account name",
                "Account name", JOptionPane.QUESTION_MESSAGE);
        while (accountName.trim().isEmpty())
            accountName = JOptionPane.showInputDialog(null, "Please enter account name",
                    "Account name", JOptionPane.ERROR_MESSAGE);

        int accountLimit = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter account limit",
                "Account limit", JOptionPane.QUESTION_MESSAGE));
        while (accountLimit < 0)
            accountLimit = Integer.parseInt(JOptionPane.showInputDialog(null, "Please enter account limit",
                    "Account limit", JOptionPane.ERROR_MESSAGE));

        double accountInitialBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter account initial balance",
                "Initial balance", JOptionPane.QUESTION_MESSAGE));

        while (accountInitialBalance < 0)
            accountInitialBalance = Double.parseDouble(JOptionPane.showInputDialog(null, "Please account initial balance",
                    "Initial balance", JOptionPane.ERROR_MESSAGE));

        return new CreditCard(customerName, bankName, accountName, accountLimit, accountInitialBalance);
    }

    public static void printCreditCardInfo(CreditCard creditCard) {

        String tmpStr = String.format("Name: %s\n", creditCard.getCustomer()) +
                String.format("Bank name: %s\n", creditCard.getBank()) +
                String.format("Account name: %s\n", creditCard.getAccount()) +
                String.format("Account Limit: %d\n", creditCard.getLimit()) +
                String.format("Account Balance: $%.2f\n", creditCard.getBalance());
        JOptionPane.showMessageDialog(null, tmpStr, "All information",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Credit card program",
                "Credit Card", JOptionPane.INFORMATION_MESSAGE);

        CreditCard userCreditCard = obtainsUserCreditCardInfo();
        printCreditCardInfo(userCreditCard);
    }
}
