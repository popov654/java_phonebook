package phonebook.client;

import phonebook.core.exception.DataNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Optional;
import phonebook.core.PhoneBook;

/**
 *
 * @author Alex
 */
public class ConsoleClient implements Runnable {
    
    private final PhoneBook server;
    
    public ConsoleClient(PhoneBook server) {
        this.server = server;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) { 
            while (true) {
                System.out.print("Enter your command (\"get\", \"put\", \"find\", \"exists\", \"service\") or \"quit\" to exit: > ");
                String line = reader.readLine();
                executeCommand(line);
            }
        } catch (DataNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    private void executeCommand(String commandWithArgs) throws DataNotFoundException {
        String[] words = commandWithArgs.split("\\s+");
        String command = words[0].toLowerCase();
        switch (command) {
            case "get":
                if (words.length > 1) {
                    System.out.println(server.getNumberByName(words[1]));
                } else {
                    System.err.println("Invalid command. Usage: get [name]");
                }
                break;

            case "find":
                if (words.length > 1) {
                    Optional<String> number = server.findNumberByName(words[1]);
                    System.out.println(number.orElse("Not found"));
                } else {
                    System.err.println("Invalid command. Usage: find [name]");
                }
                break;    

            case "put":
                if (words.length > 2) {
                    server.putNumber(words[1].trim(), words[2].trim());
                } else {
                    System.err.println("Invalid command. Usage: put [name] [number]");
                }
                System.out.println("Number was saved successfully");
                break;
            case "exists":
                if (words.length > 1) {
                    System.out.println(server.numberExists(words[1].trim()) ? "yes" : "no");
                } else {
                    System.err.println("Invalid command. Usage: exists [name]");
                }
                break;
            case "service":
                System.out.println(server.getServiceContact());
                break; 
            case "quit":
                System.exit(0);
        }
    }
    
}
