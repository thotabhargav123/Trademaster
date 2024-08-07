package domainclasses.transaction;

import java.util.Date;

public class SellStock extends Transaction {
    public SellStock(String username, String stockSymbol, int quantity, Date date) {
        super(username, stockSymbol, quantity, date, "Sell");
    }

    @Override
    public String toString() {
        return "SellTransaction{" +
                "username='" + username + '\'' +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
