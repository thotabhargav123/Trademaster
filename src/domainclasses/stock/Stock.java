package domainclasses.stock;

public class Stock {
    private String symbol;
    private double price;
// Constructors, getters, and setters
    public Stock(String symbol, double price){
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return this.symbol;
    }
    public double getPrice(){
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "symbol='" + symbol + '\'' +
                ", price=" + price +
                '}';
    }
}
