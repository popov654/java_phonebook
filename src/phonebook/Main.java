package phonebook;

import phonebook.storage.HashMapStorage;
import phonebook.client.ConsoleClient;
import phonebook.core.PhoneBookManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alex
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ConsoleClient c = new ConsoleClient(new PhoneBookManager(new HashMapStorage<>()));
            Thread thread = new Thread(c);
            thread.start();
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
