package com.mycompany.bankapp.services;

import com.mycompany.bankapp.databases.Database;
import com.mycompany.bankapp.models.Account;
import com.mycompany.bankapp.models.Customer;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    
   
   //  Database (..)
    
    
    
    public static List<Customer> list = new ArrayList<>();             // list of Customer objects
    public static List<Account> accountslist= new ArrayList<>();    // list of Accounts objects     
    public static boolean init = true;
    
    // class constructors here
    public AccountService() {
        
        if(init) {
            Account acc1 = new Account (1, "One account");
            Account acc2 = new Account (2, "Another account");
            Account acc3 = new Account (3, "And another account more");
            
            accountslist.add(acc1);
            accountslist.add(acc2);
            accountslist.add(acc3);
            
            Customer cu1 = new Customer (1, "Manuel", "Fernandez","JackEmployee", "manuel@gmail.com","Dublin 1", accountslist);
            Customer cu2 = new Customer (2, "Jack", "Ryan","EvaEmployee", "jack@gmail.com","Dublin 4", accountslist);
            Customer cu3 = new Customer (3, "Emer", "Byrne","JackEmployee", "emer@gmail.com", "Dublin 8", accountslist);
            
            
            list.add(cu1);
            list.add(cu2);
            list.add(cu3);
            init = false;
        }
    }
   
 
    public List<Account> getAllAccountsByCustomer(int CustomerID) {
        return list.get(CustomerID-1).getAccounts();                 // -1 because ArrayList count from 0
    }
    
    public Account getAccountByID(int CustomerID, int AccountID) {
        return list.get(CustomerID-1).getAccounts().get(AccountID-1);  // get a customer object with a given customer id,
                                                                           // on that object get all that accounts from the accounts list
                                                                           //  and from the accounts list  get the account with a given id              
    }
    
    
    
}
