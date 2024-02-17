package phonebook.storage.impl;

import java.util.HashMap;
import phonebook.storage.Storage;


/**
 *
 * @author Alex
 * @param <T>
 */
public class HashMapStorage<T> implements Storage<T> {
    
    private final HashMap<String, T> storage = new HashMap<>();

    @Override
    public T get(String key) {
        return storage.get(key);
    }

    @Override
    public void put(String key, T value) {
        storage.put(key, value);
    }

    @Override
    public boolean contains(String key) {
        return storage.containsKey(key);
    }

}
