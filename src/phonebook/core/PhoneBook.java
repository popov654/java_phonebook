package phonebook.core;

import java.util.Optional;

/**
 *
 * @author Alex
 */
public interface PhoneBook {
    
    Optional<String> findNumberByName(String name);
    
    String getServiceContact();
    
    String getNumberByName(String name) throws DataNotFoundException;
    
    boolean numberExists(String name);
    
    void putNumber(String name, String value);
}
