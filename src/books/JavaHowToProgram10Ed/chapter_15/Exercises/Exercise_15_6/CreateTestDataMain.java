package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_6;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class CreateTestDataMain {

    public static void main(String[] args) {
        
        String masterFileName = "oldmast.ser"; 
        String transFileName = "trans.ser"; 
        
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(new Account(300, "Mary", "Smith", 27.19));
        accountList.add(new Account(700, "Suzy", "Green", -14.22));
        accountList.add(new Account(100, "Alan", "Jones", 348.17));
        accountList.add(new Account(500, "Sam", "Sharp", 0.00));

        CreateMasterFile masterFile = new CreateMasterFile(masterFileName);
        masterFile.addAccounts(accountList);        // write all accounts to file.
        masterFile.closeMasterFile();               // close file for writing accounts to.
        
        ArrayList<TransactionRecord> transRecList = new ArrayList<>();
        transRecList.add(new TransactionRecord(400, 100.56));
        transRecList.add(new TransactionRecord(300, 62.11));
        transRecList.add(new TransactionRecord(900, 82.17));
        transRecList.add(new TransactionRecord(100, 27.14));
        transRecList.add(new TransactionRecord(300, 83.89));
        transRecList.add(new TransactionRecord(700, 80.78));
        transRecList.add(new TransactionRecord(700, 1.53));

        CreateTransactionFile transactionFile = new CreateTransactionFile(transFileName);
        transactionFile.addTransactions(transRecList);
        transactionFile.closeTransactionFile();

        FileMatch fileMatch = new FileMatch(masterFileName, transFileName);

    }
}

class CreateTransactionFile {

    private ObjectOutputStream output;
    private static final int EXIT_FAILURE = 1;

    public CreateTransactionFile(String fileNameOrPath) {
        if (Objects.isNull(fileNameOrPath) || fileNameOrPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid specified filename. Must be a valid name or path");
        }
        this.openFile(fileNameOrPath);
    }

    private void openFile(String fileNameOrPath) {
        try {
            this.output = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileNameOrPath)));

        } catch (IOException ioException) {
            System.err.printf("[FILE_CREATION_ERROR]: Error opening file '%s'. Terminating.%n", fileNameOrPath);
            System.exit(EXIT_FAILURE);
        }
    }

    public void addTransaction(TransactionRecord transRec) {
        ArrayList<TransactionRecord> transRecordList = new ArrayList<>();
        transRecordList.add(transRec);

    }

    public void addTransactions(ArrayList<TransactionRecord> transRecordList) {
        if (Objects.isNull(transRecordList) || transRecordList.isEmpty()) {
            return;
        }
        // Sort transactions record list based on transaction numbers
        Collections.sort(transRecordList);

        for (TransactionRecord transRec : transRecordList) {
            try {
                this.output.writeObject(transRec);

            } catch (IOException ioException) {
                System.err.printf("[TRANSACTION_WRITE_ERROR]: File writing failed for: %s%n", transRec);
                System.exit(EXIT_FAILURE);
            }
        }
    }

    public void closeTransactionFile() {
        if (!Objects.isNull(this.output)) {
            try {
                this.output.close();

            } catch (IOException ioException) {
                System.err.println("[FILE_CLOSE_ERROR]: Error closing transaction file.");
                System.exit(EXIT_FAILURE);
            }
        }
    }

}

class CreateMasterFile {

    private ObjectOutputStream output;
    private static final int EXIT_FAILURE = 1;

    public CreateMasterFile(String fileNameOrPath) {
        if (Objects.isNull(fileNameOrPath) || fileNameOrPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid specified filename. Must be a valid name or path");
        }
        this.openFile(fileNameOrPath);
    }

    private void openFile(String fileNameOrPath) {
        try {
            this.output = new ObjectOutputStream(Files.newOutputStream(Paths.get(fileNameOrPath)));

        } catch (IOException ioException) {
            System.err.printf("[FILE_ERROR]: Error opening file '%s'. Terminating.%n", fileNameOrPath);
            System.exit(EXIT_FAILURE);
        }
    }

    public void addAccount(Account anAccount) {
        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(anAccount);
    }

    public void addAccounts(ArrayList<Account> accountsList) {
        if (Objects.isNull(accountsList) || accountsList.isEmpty()) {
            return;
        }
        // Sort accounts based on their account numbers
        Collections.sort(accountsList);

        // Write all information to file.
        for (Account currAccount : accountsList) {
            try {
                this.output.writeObject(currAccount);
                
            } catch (IOException ioException) {
                
                System.err.printf("[ACCOUNT_WRITE_ERROR]: File writing failed for: %s", currAccount);
                System.exit(EXIT_FAILURE);
            }
        }
    }
    
    public void closeMasterFile() {
        if (!Objects.isNull(this.output)) {
            try {
                this.output.close();
                
            } catch (IOException ioException) {
                
                System.err.printf("[FILE_CLOSE_ERROR]: Error closing file. Terminating.%n");
                System.exit(EXIT_FAILURE);
            }
        }
    }

}