package servicelayer.stockservicelayer;

import datalayer.DataStore;
import domainclasses.stock.Stock;
import domainclasses.transaction.BuyStock;
import domainclasses.transaction.SellStock;
import domainclasses.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockServiceImp implements StockService {
    DataStore db = DataStore.getInstance();
    @Override
    public void buyStock(String username, String stockSymbol, int quantity) {
        User user = db.getUsers().get(username);
        Stock stock = db.getStocks().get(stockSymbol);

        if(user == null ||  stock == null){
            System.out.println("Values entered are invalid please enter correctly");
        }
        else{
            user.addStocksToAccount(stockSymbol, quantity);
            BuyStock transaction = new BuyStock(username, stockSymbol, quantity, new Date());
            db.getTransactions().computeIfAbsent(username, k -> new ArrayList<>()).add(transaction);
        }
    }

    @Override
    public void sellStock(String username, String stockSymbol, int quantity) {
        User user = db.getUsers().get(username);
        Stock stock = db.getStocks().get(stockSymbol);
        if(user == null || stock == null){
            System.out.println("Values entered are invalid please enter correctly");
        }
        else{
            boolean suc = user.removeStockHolding(stockSymbol, quantity);
            if(suc) {
                SellStock transaction = new SellStock(username, stockSymbol, quantity, new Date());
                db.getTransactions().computeIfAbsent(username, k -> new ArrayList<>()).add(transaction);
            }
            else{
                System.out.println("Cant remove you are trying to sell more stocks than u hold 🫡🫡🫡");
            }
        }
    }

    @Override
    public List<Stock> getAvailableStocks() {
        return new ArrayList<>(db.getStocks().values());
    }
}
