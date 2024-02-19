package phonebook.client;

import java.util.Optional;
import phonebook.core.PhoneBook;

/**
 *
 * @author Alex
 */
public class Commands {
    
    @FunctionalInterface
    public interface Command {
        void execute(String[] command, PhoneBook server);
    }
    
    public static void get(String[] args, PhoneBook server) {
        try {
            if (args.length > 0) {
                System.out.println(server.getNumberByName(args[0]));
            } else {
                System.err.println("Invalid command. Usage: get [name]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void find(String[] args, PhoneBook server) {
        try {
            if (args.length > 0) {
                Optional<String> number = server.findNumberByName(args[0]);
                System.out.println(number.orElse("Not found"));
            } else {
                System.err.println("Invalid command. Usage: find [name]");
            }  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void put(String[] args, PhoneBook server) {
        try {
            if (args.length > 1) {
                server.putNumber(args[0].trim(), args[1].trim());
            } else {
                System.err.println("Invalid command. Usage: put [name] [number]");
            }
            System.out.println("Number was saved successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void exists(String[] args, PhoneBook server) {
        try {
            if (args.length > 0) {
                System.out.println(server.numberExists(args[0].trim()) ? "yes" : "no");
            } else {
                System.err.println("Invalid command. Usage: exists [name]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void service(String[] args, PhoneBook server) {
        try {
            System.out.println(server.getServiceContact());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void quit(Object... args) {
        System.exit(0);
    }
}
