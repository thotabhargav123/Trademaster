import datalayer.DataStore;
import domainclasses.user.User;
import servicelayer.accountservice.AccountServiceImp;
import servicelayer.stockservicelayer.StockServiceImp;

import java.io.IOException;
import java.util.Scanner;

public class TradeMasterApp {
    private static AccountServiceImp accountService = new AccountServiceImp();
    private static StockServiceImp stockService = new StockServiceImp();
    public static void main(String[] args) {
// Initialize services and start console interface
        boolean appRunning = true;
        while(appRunning){
            ConsoleUtils.clearConsole(); // Clear console before displaying menu
            displayMenu();
            appRunning = handleUserInput();
        }
    }
    private static void displayMenu() {
// Display menu options to the user
        System.out.println("Welcome to World best stock exchange world TradeMaster");
        System.out.println("Enter 1 to create your account");
        System.out.println("Enter 2 to see all available stocks");
        System.out.println("Enter 3 to sell stocks ");
        System.out.println("Enter 4 to buy stocks 💸💸💸");
        System.out.println("Enter 5 to see your transaction history 💵💵💵");
        System.out.println("Enter 6 to see all your stocks");
        System.out.println("Enter 7 to exit 🥲🥲🥲");
    }
    private static boolean handleUserInput() {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        switch (input) {
            case 1:
                System.out.println("Welcome to Account creation portal");
                System.out.print("Enter username: ");
                String username1 = sc.nextLine();
                accountService.createAccount(username1);
                System.out.println("User added successfully");
                break;

            case 2:
                System.out.println("Printing all available stocks");
                stockService.getAvailableStocks().forEach(stock ->
                        System.out.println(stock.getSymbol() + " : $" + stock.getPrice()));
                break;

            case 3:
                System.out.print("Enter username: ");
                String username3 = sc.nextLine();
                System.out.print("Enter stock symbol: ");
                String sellSymbol = sc.nextLine();
                System.out.print("Enter quantity: ");
                int sellQuantity = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline
                stockService.sellStock(username3, sellSymbol, sellQuantity);
                break;

            case 4:
                System.out.print("Enter username: ");
                String username4 = sc.nextLine();
                System.out.print("Enter stock symbol: ");
                String buySymbol = sc.nextLine();
                System.out.print("Enter quantity: ");
                int buyQuantity = sc.nextInt();
                sc.nextLine(); // Consume the leftover newline
                stockService.buyStock(username4, buySymbol, buyQuantity);
                break;

            case 5:
                System.out.print("Enter username: ");
                String username5 = sc.nextLine();
                System.out.println("Transaction History:");
                accountService.getTransactionHistory(username5).forEach(transaction ->
                        System.out.println(transaction));
                break;

            case 6:

                System.out.print("Enter username: ");
                String username6 = sc.nextLine();
                System.out.println("Retrieved username: " + username6); // Debug print
                User user = DataStore.getInstance().getUsers().get(username6);
                if (user != null) {
                    user.showAllStocksHolding();
                } else {
                    System.out.println("User not found.");
                }
                break;

            case 7:
                System.out.println("Bye Bye");
                return false;

            default:
                System.out.println("Why are entering wrong input 😡😡 ??");
                break;
        }
        return true;
    }

    public class ConsoleUtils {
        public static void clearConsole() {
            try {
                if (System.getProperty("os.name").toLowerCase().contains("win")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    // ANSI escape code for other OS
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}