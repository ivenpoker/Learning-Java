package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_4;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {

        String masterFileName = "oldmast.txt";
        String transFileName  = "trans.txt";

        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(new Account(300, "Mary", "Smith", 27.19));
        accountList.add(new Account(700, "Suzy", "Green", -14.22));
        accountList.add(new Account(100, "Alan", "Jones", 348.17));
        accountList.add(new Account(500, "Sam", "Sharp", 0.00));

        CreateMasterFile masterFile = new CreateMasterFile(masterFileName);
        masterFile.addAccounts(accountList);              // write all accounts to file.
        masterFile.closeMasterFile();                // close file for writing accounts to.

        ArrayList<TransactionRecord> transRecList = new ArrayList<>();
        transRecList.add(new TransactionRecord(400, 100.56));
        transRecList.add(new TransactionRecord(300, 62.11));
        transRecList.add(new TransactionRecord(900, 82.17));
        transRecList.add(new TransactionRecord(100, 27.14));

        CreateTransactionFile transactionFile =  new CreateTransactionFile(transFileName);
        transactionFile.addTransactions(transRecList);
        transactionFile.closeTransactionFile();

        // Hand File match processing by creating an object of 'FileMatch'
        FileMatch newFileMatch = new FileMatch(masterFileName, transFileName);

    }

}

class CreateTransactionFile {

    private Formatter output;
    private static final int EXIT_FAILURE = 1;

    public CreateTransactionFile(String fileNameOrPath) {
        if (Objects.isNull(fileNameOrPath) || fileNameOrPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid specified filename. Must be a valid name or path");
        }
        this.openFile(fileNameOrPath);
    }

    private void openFile(String fileNameOrPath) {
        try {
            this.output = new Formatter(fileNameOrPath);

        } catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating program.");
            System.exit(EXIT_FAILURE);

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file. Terminating program.");
            System.exit(EXIT_FAILURE);
        }
    }

    public void addTransactions(TransactionRecord transRec) {
        ArrayList<TransactionRecord> transRecList = new ArrayList<>();
        transRecList.add(transRec);

    }

    public void addTransactions(ArrayList<TransactionRecord> transRecList) {
        if (Objects.isNull(transRecList) || transRecList.isEmpty()) {
            return;
        }
        // Sort transaction record list based on transaction numbers
        Collections.sort(transRecList);

        for (TransactionRecord transRec : transRecList) {
            this.output.format("%-10s%-15s%n", String.format("%d", transRec.getAccountNumber()),
                    String.format("%.2f", transRec.getTransactionAmount()));
        }
    }

    public void closeTransactionFile() {
        if (!Objects.isNull(this.output)) {
            this.output.close();
        }
    }

}

class CreateMasterFile {

    private Formatter output;
    private static final int EXIT_FAILURE = 1;

    public CreateMasterFile(String fileNameOrPath) {
        if (Objects.isNull(fileNameOrPath) || fileNameOrPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid specified filename. Must be a valid name or path");
        }
        this.openFile(fileNameOrPath);
    }

    private void openFile(String fileNameOrPath) {
        try {
            this.output = new Formatter(fileNameOrPath);

        } catch (SecurityException securityException) {
            System.err.println("Write permission denied. Terminating program.");
            System.exit(EXIT_FAILURE);

        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("Error opening file. Terminating program.");
            System.exit(EXIT_FAILURE);
        }
    }

    public void addAccounts(Account anAccount) {
        ArrayList<Account> accountsList = new ArrayList<>();
        this.addAccounts(accountsList);
    }

    public void addAccounts(ArrayList<Account> accountsList) {
        if (Objects.isNull(accountsList) || accountsList.isEmpty()) {
            return;
        }
        // Sort accounts based on their account numbers.
        Collections.sort(accountsList);

        // Write all information to file.
        for (Account account : accountsList) {
            this.output.format("%-10s%-15s%-15s%n", String.format("%d", account.getAccount()),
                    String.format("%s %s", account.getFirstName(), account.getLastName()),
                    String.format("%.2f", account.getBalance()));
        }
    }

    public void closeMasterFile() {
        if (!Objects.isNull(this.output)) {
            this.output.close();
        }
    }

}