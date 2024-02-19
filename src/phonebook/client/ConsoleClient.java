package phonebook.client;

import phonebook.core.exception.DataNotFoundException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import phonebook.client.Commands.Command;
import phonebook.core.PhoneBook;

/**
 *
 * @author Alex
 */
public class ConsoleClient implements Runnable {
    
    private final PhoneBook server;
    
    public ConsoleClient(PhoneBook server) {
        this.server = server;
        commands.put("get", Commands::get);
        commands.put("find", Commands::find);
        commands.put("put", Commands::put);
        commands.put("exists", Commands::exists);
        commands.put("service", Commands::service);
        commands.put("quit", Commands::quit);
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
        commands.get(command).execute(Arrays.copyOfRange(words, 1, words.length), server);
    }
    
    Map<String, Command> commands = new HashMap<>();
    
}
