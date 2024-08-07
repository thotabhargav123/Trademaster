package domainclasses.user;

import java.util.HashMap;
import java.util.Map;

public class User {
    private String username;
    private Map<String,Integer> stocksHolding; // stock and quantity
// Constructors, getters, and setters
    public User(String username){
        this.username = username;
        stocksHolding = new HashMap<>();
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }

    public void addStocksToAccount(String stockSymbol, int quantity){
        stocksHolding.put(stockSymbol,stocksHolding.getOrDefault(stockSymbol, 0)+quantity);
    }

    public boolean removeStockHolding(String stockSymbol, int quantity){
        int currentQuantity = stocksHolding.getOrDefault(stockSymbol, 0);
        if (currentQuantity >= quantity) {
            stocksHolding.put(stockSymbol, currentQuantity - quantity);
            if (stocksHolding.get(stockSymbol) == 0) {
                stocksHolding.remove(stockSymbol);
            }
            return true;
        } else {
            return false;
        }
    }

    public void showAllStocksHolding() {
        if (stocksHolding.isEmpty()) {
            System.out.println(username + " does not hold any stocks.");
        } else {
            System.out.println("Stocks held by " + username + ":");
            for (Map.Entry<String, Integer> entry : stocksHolding.entrySet()) {
                System.out.println("Stock symbol: " + entry.getKey() + ", Quantity: " + entry.getValue());
            }
        }
    }
}
