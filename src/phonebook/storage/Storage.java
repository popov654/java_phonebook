package phonebook.storage;

/**
 *
 * @author Alex
 * @param <T>
 */
public interface Storage<T> {
    
    public T get(String key);
    
    public void put(String key, T value);
    
    public boolean contains(String key);
    
}
