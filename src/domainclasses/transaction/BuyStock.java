package domainclasses.transaction;

import java.util.Date;
public class BuyStock extends Transaction {
    public BuyStock(String username, String stockSymbol, int quantity, Date date) {
        super(username, stockSymbol, quantity, date, "buy");
    }

    @Override
    public String toString() {
        return "BuyTransaction{" +
                "username='" + username + '\'' +
                ", stockSymbol='" + stockSymbol + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
