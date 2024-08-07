package servicelayer.accountservice;
import domainclasses.transaction.Transaction;

import java.util.List;

public interface AccountService {
    void createAccount(String username);
    List<Transaction> getTransactionHistory(String username);
}
