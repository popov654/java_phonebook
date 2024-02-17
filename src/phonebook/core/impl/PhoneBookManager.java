package phonebook.core.impl;

import phonebook.core.exception.DataNotFoundException;
import java.util.Optional;
import phonebook.core.PhoneBook;
import phonebook.storage.Storage;


/**
 *
 * @author Alex
 */
public class PhoneBookManager implements PhoneBook {
    
    public Storage<String> storage;
    
    public PhoneBookManager(Storage<String> storage) {
        this.storage = storage;
    }

    @Override
    public Optional<String> findNumberByName(String name) {
        return Optional.ofNullable(storage.get(name));
    }

    @Override
    public String getServiceContact() {
        return storage.get("Service");
    }

    @Override
    public String getNumberByName(String name) throws DataNotFoundException {
        String number = storage.get(name);
        if (number == null) {
            throw new DataNotFoundException(name);
        }
        return number;
    }

    @Override
    public boolean numberExists(String name) {
        return storage.contains(name);
    }

    @Override
    public void putNumber(String name, String number) {
        storage.put(name, number);
    }
}
