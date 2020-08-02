package books.JavaHowToProgram10Ed.chapter_15.Exercises.Exercise_15_6;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class FileMatch {

    private String masterFileName;
    private String transactionFileName;

    private ArrayList<Account> masterFileAccountsList;
    private ArrayList<TransactionRecord> transactionFileRecordsList;

    private ObjectInputStream inputStream;
    private ObjectOutputStream loggerInputStream;

    private static final String logFileName = "log.ser";
    private static final String newMasterFileName = "newmast.err";

    private enum FileType {MASTER_FILE, TRANSACTION_FILE};

    private static int EXIT_FAILURE = 1;

    public FileMatch(String masterFileNameOrPath, String transFileNameOrPath) {

        if (Objects.isNull(masterFileNameOrPath) || masterFileNameOrPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid master file. Must be a name or path");
        }
        if (Objects.isNull(transFileNameOrPath) || transFileNameOrPath.isEmpty()) {
            throw new IllegalArgumentException("Invalid transaction file. Must be a name or path");
        }
        this.masterFileName = masterFileNameOrPath;
        this.transactionFileName = transFileNameOrPath;

        this.loadFileContents(FileType.MASTER_FILE);
        this.loadFileContents(FileType.TRANSACTION_FILE);

        this.processFilesContent();

    }

    private void processFilesContent() {

        boolean isMatchFound = false;               // flag determines if we've found a match account in both files.
        boolean writeNewMasterFile = false;         // flag determines if we create a 'newmast.ser' file.

        for (Account currMasterAccount : this.masterFileAccountsList) {
            for (TransactionRecord currTransRecord : this.transactionFileRecordsList) {

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

            for (TransactionRecord transRec : this.transactionFileRecordsList) {
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

                // we write accounts (possibly updated) to new master file.
                try {
                    ObjectOutputStream newOutputSream = new ObjectOutputStream(
                            Files.newOutputStream(Paths.get(newMasterFileName)));

                    for (Account newMasterAccount : this.masterFileAccountsList) {
                        try {
                            newOutputSream.writeObject(newMasterAccount);

                        } catch (IOException ioException) {
                            System.err.printf("[ERROR_WRITING_TO_FILE]: Error writing to new master file '%s'. " +
                                    "Terminating.%n", this.masterFileName);
                        }
                    }

                } catch (IOException ioException) {
                    System.err.printf("[ERROR_CREATING_NEW_MASTER_FILE]: Error creating new master file '%s'." +
                            " Terminating%n.", newMasterFileName);
                    System.exit(EXIT_FAILURE);
                }
            }

        }
    }

    private void writeToLog(TransactionRecord transRec) {

        // if the logger formatter hasn't been instantiated (this means, this is
        // the very first log), we instantiate one.

        if (Objects.isNull(this.loggerInputStream)) {
            try {
                this.loggerInputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(logFileName)));

            } catch (IOException ioException) {
                System.err.printf("[LOG_FILE_CREATION_ERROR]: Error creating to log file '%s'. Terminating.", logFileName);
                System.exit(EXIT_FAILURE);
            }
        }
        try {
            this.loggerInputStream.writeObject(transRec);

        } catch (IOException ioException) {
            System.err.printf("[LOG_FILE_WRITE_ERROR]: Error writing to file '%s'. Terminating.", logFileName);
            System.exit(EXIT_FAILURE);
        }

    }

    private void loadFileContents(FileType fileType) {

        if (fileType == FileType.MASTER_FILE) {
            this.masterFileAccountsList = new ArrayList<>();
            try {
                this.inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(masterFileName)));
                try {
                    while (true) {
                        Account currAccount = (Account) this.inputStream.readObject();
                        this.masterFileAccountsList.add(currAccount);
                    }
                } catch (ClassNotFoundException classNotFoundException) {
                    System.err.println("[INVALID_OBJECT]: Invalid object type. Terminating");
                    System.exit(EXIT_FAILURE);

                } catch (EOFException eofException) {
                    // At this stage there is no records available to read. Done reading.

                } catch (IOException ioException) {
                    System.err.printf("[FILE_READING_ERROR]: Error reading from file '%s'. Terminating.",
                            this.masterFileName);
                }

            } catch (IOException ioException) {
                System.err.printf("[FILE_READ_ERROR]: Error opening file '%s'. Terminating.", this.masterFileName);
                System.exit(EXIT_FAILURE);
            }

        } else {
            this.transactionFileRecordsList = new ArrayList<>();
            try {
                this.inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(this.transactionFileName)));
                try {
                    while (true) {
                        TransactionRecord currTransRec = (TransactionRecord) this.inputStream.readObject();
                        this.transactionFileRecordsList.add(currTransRec);
                    }
                } catch (ClassNotFoundException classNotFoundException) {
                    System.err.println("[INVALID_OBJECT]: Invalid object type. Terminating");
                    System.exit(EXIT_FAILURE);

                } catch (EOFException eofException) {
                    // At this stage there is no records available to read. Done reading.

                } catch (IOException ioException) {
                    System.err.printf("[FILE_READ_ERROR]: Error opening file '%s'. Terminating.",
                            this.transactionFileName);
                }

            } catch (IOException ioException) {
                System.err.printf("[FILE_READ_ERROR]: Error opening file '%s'. Terminating.", this.transactionFileName);
                System.exit(EXIT_FAILURE);
            }
        }
    }

}
