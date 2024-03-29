package phonebook;

import phonebook.storage.impl.HashMapStorage;
import phonebook.client.ConsoleClient;
import phonebook.core.impl.PhoneBookImpl;
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
            ConsoleClient c = new ConsoleClient(new PhoneBookImpl(new HashMapStorage<>()));
            Thread thread = new Thread(c);
            thread.start();
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
