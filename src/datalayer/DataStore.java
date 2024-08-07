package datalayer;

import domainclasses.stock.Stock;
import domainclasses.transaction.Transaction;
import domainclasses.user.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// singleton class
public class DataStore {
    private static DataStore instance;
    private final Map<String, User> users;
    private final Map<String, Stock> stocks;
    private final Map<String, List<Transaction>> transactions;
    private DataStore() {
        users = new HashMap<>();
        stocks = new HashMap<>();
        transactions = new HashMap<>();

        stocks.put("mrf", new Stock("mrf", 1500.00));
        stocks.put("sony", new Stock("sony", 9650.00));
        stocks.put("sun", new Stock("sun", 4525.00));
        stocks.put("dukh", new Stock("dukh", 68420.00));
        stocks.put("sukh", new Stock("sukh", 10000.00));
        stocks.put("ewww", new Stock("ewww", 10.428));
        stocks.put("lalala", new Stock("lalala", 9.00));
        stocks.put("annaw", new Stock("annaw", 1000.557));
    }
    // making sure singleton class present anytime.
    public static synchronized DataStore getInstance() {
        if (instance == null) {
            System.out.println("New Instance created");
            instance = new DataStore();
        }
        System.out.println("Instance sent to you");
        return instance;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<String, Stock> getStocks() {
        return stocks;
    }

    public Map<String, List<Transaction>> getTransactions() {
        return transactions;
    }

    public void addNewUser(User userObj) {
        String username = userObj.getUsername();

        // Check if user already exists
        if (users.containsKey(username)) {
            System.out.println("User with username '" + username + "' already exists.");
            return; // Exit the method without adding the user
        }

        // Add new user
        System.out.println("New user added to database");
        users.put(username, userObj);
    }
}
