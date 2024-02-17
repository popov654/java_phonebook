package phonebook.core;

/**
 *
 * @author Alex
 */
public class DataNotFoundException extends Exception {
    
    public String key;
    
    public DataNotFoundException(String key) {
        this.key = key;
    }
    
    @Override
    public String getMessage() {
        return "Data for key \"" + this.key + "\" not found";
    }
}
