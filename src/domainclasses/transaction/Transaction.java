package domainclasses.transaction;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Transaction {
    protected String username;
    protected String stockSymbol;
    protected int quantity;
    protected Date date;
    protected  String transactionType;
// Constructors, getters, and setters
    public Transaction(String username, String stockSymbol, int quantity, Date date, String transactionType){
        this.username = username;
        this.stockSymbol = stockSymbol;
        this.quantity = quantity;
        this.date = date;

    }

    public Date getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public String getUsername() {
        return username;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return String.format("%s %s %s %d shares on %s",
                username, transactionType, stockSymbol, quantity, sdf.format(date));
    }
}
