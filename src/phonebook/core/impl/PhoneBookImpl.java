package phonebook.core.impl;

import phonebook.core.exception.DataNotFoundException;
import java.util.Optional;
import phonebook.core.PhoneBook;
import phonebook.storage.Storage;


/**
 *
 * @author Alex
 */
public class PhoneBookImpl implements PhoneBook {
    
    private final Storage<String> storage;
    
    public final String DEFAULT_SERVICE_NUMBER = "123456789";
    
    public PhoneBookImpl(Storage<String> storage) {
        this.storage = storage;
    }

    @Override
    public Optional<String> findNumberByName(String name) {
        return Optional.ofNullable(storage.get(name));
    }
    
    @Override
    public String getNumberByName(String name) throws DataNotFoundException {
        return findNumberByName(name).orElseThrow(() -> new DataNotFoundException(name));
    }
    
    @Override
    public String getServiceContact() {
        return findNumberByName("Service").orElse(DEFAULT_SERVICE_NUMBER);
    }
    
    @Override
    public void logServiceContact() {
        System.out.println("Service number: " + findNumberByName("Service").orElse("No service contact"));
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
