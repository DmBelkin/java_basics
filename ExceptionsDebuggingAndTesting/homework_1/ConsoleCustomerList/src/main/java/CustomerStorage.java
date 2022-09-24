import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    private final String phoneRegex = "[+][7,8]{1}[0-9]{10}";

    private final String emailRegex = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";


    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if (components.length != 4) {
            throw new IllegalArgumentException("java.lang.ArrayIndexOutOfBoundsException:" +
                    " Index 3 out of bounds for length 3");
        }
        if (!components[INDEX_EMAIL].matches(emailRegex)) {
            throw new IllegalArgumentException("Wrong email format");
        }
        if (!components[INDEX_PHONE].matches(phoneRegex)) {
            throw new IllegalArgumentException("Wrong phone format");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }
}