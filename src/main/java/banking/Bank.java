package banking;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

/**
 * The Bank implementation.
 */
public class Bank implements BankInterface {
    private LinkedHashMap<Long, Account> accounts;

    public Bank() {
        accounts= new LinkedHashMap<>();
    }

    private Account getAccount(Long accountNumber) {
       try{
            
            return accounts.get(accountNumber);
       } catch (Exception e) {
            throw new RuntimeException("TODO");
       }
    }

    public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
        
        try {
            long accountNumber  = new Random().nextLong();
            CommercialAccount commercialAccount = new CommercialAccount(company,accountNumber , pin, startingDeposit);
            accounts.put(accountNumber, commercialAccount);
            return commercialAccount.getAccountNumber();
        } catch (Exception e) {
            throw new RuntimeException("TODO1");
        }
    
    }

    public Long openConsumerAccount(Person person, int pin, double startingDeposit) {
            long accountNumber  = new Random().nextLong();
            ConsumerAccount consumerAccount = new ConsumerAccount(person, accountNumber, pin, startingDeposit);
            
            accounts.put(accountNumber, consumerAccount);
            return consumerAccount.getAccountNumber();
         
    }

    public double getBalance(Long accountNumber) {
        
        return this.getAccount(accountNumber).getBalance();
        
    }

    public void credit(Long accountNumber, double amount) {
        
        this.getAccount(accountNumber).creditAccount(amount);
        
    }

    public boolean debit(Long accountNumber, double amount) {
        return this.getAccount(accountNumber).debitAccount(amount);
    }

    public boolean authenticateUser(Long accountNumber, int pin) {
        return this.getAccount(accountNumber).validatePin(pin);
    }
    
    public void addAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        CommercialAccount commercialAccount =(CommercialAccount) this.getAccount(accountNumber);
        commercialAccount.addAuthorizedUser(authorizedPerson);
    }

    public boolean checkAuthorizedUser(Long accountNumber, Person authorizedPerson) {
        if(accountNumber==null)
            return false;
        CommercialAccount commercialAccount =(CommercialAccount) this.getAccount(accountNumber);
        return commercialAccount.isAuthorizedUser(authorizedPerson);
    }

    public Map<String, Double> getAverageBalanceReport() {
        // TODO: complete the method
        throw new RuntimeException("TODO");
    }
}
