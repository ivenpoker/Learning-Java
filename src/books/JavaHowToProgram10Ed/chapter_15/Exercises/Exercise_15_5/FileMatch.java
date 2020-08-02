package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class FileMatch {

    private String masterFileName;
    private String transactionFileName;

    private ArrayList<Account> masterFileAccountsList;
    private ArrayList<TransactionRecord> transactionFileAccountsList;

    private Formatter logOutput;

    private static Scanner input;
    private static int EXIT_FAILURE = 1;


    private enum FileType {
        MASTER_FILE("Master File"),
        TRANSACTION_FILE("Transaction File");

        private String fileTypeName;

        private FileType(String fileTypeName) {
            this.fileTypeName = fileTypeName;
        }

        @Override
        public String toString() {
            return this.fileTypeName;
        }
    }

    public FileMatch(String masterFileNameOrPath, String transFileNameOrPath) {

        if (Objects.isNull(masterFileNameOrPath) || masterFileNameOrPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid master file. Must be a name or path");
        }
        if (Objects.isNull(transFileNameOrPath) || transFileNameOrPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid transaction file. Must be a name or path");
        }
        this.masterFileName = masterFileNameOrPath;
        this.transactionFileName = transFileNameOrPath;

        this.loadFileContents(FileType.MASTER_FILE);            // load master file contents
        this.loadFileContents(FileType.TRANSACTION_FILE);       // load transaction file contents.

        this.processFilesContent();

        // Close log formatter if opened
        if (!Objects.isNull(this.logOutput)) {
            this.logOutput.close();
        }
    }

    private void processFilesContent() {

        boolean isMatchFound = false;               // flat determines if we've found a match account in both files.
        boolean writeNewMasterFile = false;         // flag determines if we create a 'newmast.txt' file.

        for (Account currMasterAccount : this.masterFileAccountsList) {
            for (TransactionRecord currTransRecord : this.transactionFileAccountsList) {

                // If both records have the same account number, we add the dollar amount
                // of the transaction record to that in the master record.

                if (currMasterAccount.getAccount() == currTransRecord.getAccountNumber()) {
                    currMasterAccount.combine(currTransRecord);

                    // we've found a match.
                    if (!isMatchFound) {
                        isMatchFound = true;
                    }

                    // Since this master account has been updated, we
                    // need to create a new master file for to reflect updates.
                    // So we raise flag for new master file creation.

                    if (!writeNewMasterFile) {
                        writeNewMasterFile = true;
                    }
                    break;
                }
            }

            // if the previous 'for' loop didn't update the 'writeNewMasterFile' flag,
            // that means the current account was found in the transaction record, hence we
            // write re-write the contents of master file to a new file.

            if (!writeNewMasterFile) {
                writeNewMasterFile = true;
            }
        }

        // Search for all those transaction records that are NOT in the master
        // record. Search is based on account number. If any found, we log in
        // log-file.

        for (TransactionRecord transRec : this.transactionFileAccountsList) {
            boolean found = false;
            for (Account mastAcc : this.masterFileAccountsList) {
                if (transRec.getAccountNumber() == mastAcc.getAccount()) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                this.writeToLog(transRec);
            }
        }

        if (writeNewMasterFile) {

            String newFileName = "newmaster.txt";

            // we write accounts (possibly updated) to 'newmast.txt' file.
            try {
                Formatter newMasterOutput = new Formatter(newFileName);
                for (Account masterAccount : this.masterFileAccountsList) {
                    newMasterOutput.format("%-10s%-15s%-15s%n", String.format("%d", masterAccount.getAccount()),
                            String.format("%s %s", masterAccount.getFirstName(), masterAccount.getLastName()),
                            String.format("%.2f", masterAccount.getBalance()));
                }

                // close formatter
                newMasterOutput.close();

            } catch (SecurityException securityException) {
                System.err.printf("Write permission denied [for '%s']. Terminating.", newFileName);
                System.exit(EXIT_FAILURE);

            } catch (FileNotFoundException fileNotFoundException) {
                System.err.printf("Error opening file [for '%s']. Terminating.", newFileName);
                System.exit(EXIT_FAILURE);
            }

        }
    }

    private void writeToLog(TransactionRecord transRec) {

        // if the logger formatter hasn't been instantiated (this means, this is
        // the very first log), we instantiate one.

        if (Objects.isNull(this.logOutput)) {
            try {
                this.logOutput = new Formatter("log.txt");
                this.logOutput.format("Unmatched transaction record for account number %d (balance: %.2f)%n",
                        transRec.getAccountNumber(), transRec.getTransactionAmount());

            } catch (SecurityException securityException) {
                System.err.println("Write permission denied. Terminating.");
                System.exit(EXIT_FAILURE);

            } catch (FileNotFoundException securityException) {
                System.err.println("Error opening file. Terminating.");
                System.exit(EXIT_FAILURE);
            }
        } else {
            this.logOutput.format("Unmatched transaction record for account number %d (balance: %.2f)%n",
                    transRec.getAccountNumber(), transRec.getTransactionAmount());
        }

    }

    private void loadFileContents(FileType fileType) {

        if (fileType == FileType.MASTER_FILE) {
            this.masterFileAccountsList = new ArrayList<>();
            try {
                input = new Scanner(Paths.get(this.masterFileName));
                try {

                    // Read all accounts from the MASTER file and load them
                    // into list data structure.

                    while (input.hasNext()) {
                        int accountNum   = input.nextInt();
                        String firstName = input.next();
                        String lastName  = input.next();
                        double balance   = input.nextDouble();

                        this.masterFileAccountsList.add(new Account(accountNum, firstName,
                                lastName, balance));
                    }
                } catch (NoSuchElementException elementException) {
                    System.err.printf("File '%s' improperly formed. Terminating.%n", this.masterFileName);
                    System.exit(EXIT_FAILURE);

                } catch (IllegalStateException stateException) {
                    System.err.printf("Error reading from file '%s'. Terminating.%n", this.masterFileName);
                    System.exit(EXIT_FAILURE);
                }

            } catch (IOException ioException) {
                System.err.println("Error opening file. Terminating.");
                System.exit(EXIT_FAILURE);
            }
        } else {
            this.transactionFileAccountsList = new ArrayList<>();
            try {
                input = new Scanner(Paths.get(this.transactionFileName));
                try {

                    // Read all data in transaction file and load them
                    // into list data structure.

                    while (input.hasNext()) {
                        int accountNum = input.nextInt();
                        double transAmount = input.nextDouble();

                        this.transactionFileAccountsList.add(new TransactionRecord(accountNum, transAmount));
                    }
                } catch (NoSuchElementException elementException) {
                    System.err.println("File improperly formed. Terminating.");

                } catch (IllegalStateException stateException) {
                    System.err.println("Error reading from file. Terminating.");
                }

            } catch (IOException ioException) {
                System.err.println("Error opening file. Terminating.");
                System.exit(EXIT_FAILURE);
            }
        }
    }
}
