package servicelayer.stockservicelayer;
import domainclasses.stock.Stock;

import  java.util.List;
public interface StockService{
    void buyStock(String username, String stockSymbol, int quantity);
    void sellStock(String username, String stockSymbol, int quantity);
    List<Stock> getAvailableStocks();
}
