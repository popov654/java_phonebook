package phonebook.core;

import phonebook.core.exception.DataNotFoundException;
import java.util.Optional;

/**
 *
 * @author Alex
 */
public interface PhoneBook {
    
    Optional<String> findNumberByName(String name);
    
    String getNumberByName(String name) throws DataNotFoundException;
    
    Optional<String> getServiceContact();
    
    void logServiceContact();
    
    boolean numberExists(String name);
    
    void putNumber(String name, String value);
}
