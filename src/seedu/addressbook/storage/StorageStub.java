package seedu.addressbook.storage;

import seedu.addressbook.data.AddressBook;

public class StorageStub extends Storage {

    public StorageStub(String storageFilePath) {
    }

    @Override
    public void save(AddressBook addressBook) throws StorageOperationException {
    }

    @Override
    public AddressBook load() throws StorageOperationException {
        return new AddressBook();
    }

    @Override
    public String getPath() {
        return null;
    }

}
