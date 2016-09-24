package seedu.addressbook.storage;

import java.nio.file.Path;

import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.storage.Storage.StorageOperationException;

public abstract class Storage {

    /** Default file path used if the user doesn't provide the file name. */
    public static final String DEFAULT_STORAGE_FILEPATH = "addressbook.txt";

    /* Note: Note the use of nested classes below.
     * More info https://docs.oracle.com/javase/tutorial/java/javaOO/nested.html
     */

    /**
     * Signals that the given file path does not fulfill the storage filepath constraints.
     */
    public static class InvalidStorageFilePathException extends IllegalValueException {
        public InvalidStorageFilePathException(String message) {
            super(message);
        }
    }

    /**
     * Signals that some error has occured while trying to convert and read/write data between the application
     * and the storage file.
     */
    public static class StorageOperationException extends Exception {
        public StorageOperationException(String message) {
            super(message);
        }
    }
    
    /**
     * Returns true if the given path is acceptable as a storage file.
     * The file path is considered acceptable if it ends with '.txt'
     */
    protected static boolean isValidPath(Path filePath) {
        return filePath.toString().endsWith(".txt");
    }
    
    /**
     * Saves all data to this storage file.
     * @throws StorageOperationException if there were errors converting and/or storing data to file.
     */   
    public abstract void save(AddressBook addressBook) throws StorageOperationException;

    /**
     * Loads data from this storage file.
     * @throws StorageOperationException if there were errors reading and/or converting data from file.
     */
    public abstract AddressBook load() throws StorageOperationException;
    
    public abstract String getPath();
}
