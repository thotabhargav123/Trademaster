package servicelayer.accountservice;

import datalayer.DataStore;
import domainclasses.transaction.Transaction;
import domainclasses.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountServiceImp implements AccountService {
    private final DataStore db = DataStore.getInstance();
    @Override
    public void createAccount(String username) {
        if(Objects.equals(username, "")){
            System.out.println("Empty values are sent Please send valid name.");
        }
        else {
            User newUser = new User(username);
            db.addNewUser(newUser);
        }
    }

    @Override
    public List<Transaction> getTransactionHistory(String username) {
        List<Transaction> transactions = db.getTransactions().getOrDefault(username, new ArrayList<>());
        if (transactions.isEmpty()) {
            System.out.println("No transaction history found for username: " + username);
        }
        return transactions;
    }
}
