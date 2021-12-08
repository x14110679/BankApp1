
package com.mycompany.bankapp.services;

import com.mycompany.bankapp.models.Account;
import com.mycompany.bankapp.models.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    
    
    // Database (...)

    public static List<Customer> list = new ArrayList<>();
    public static List<Account> accountslist = new ArrayList<>();
    public static boolean init = true;
    
    public CustomerService(){
        if (init) {
            Account acc1 = new Account (1, "One account");
            Account acc2 = new Account (2, "Another account");
            Account acc3 = new Account (3, "And another account");
         
            accountslist.add(acc1);
            accountslist.add(acc2);
            accountslist.add(acc3);
            
            Customer cu1 = new Customer (1, "Manuel", "Fernandez", "JackEmployee", "manuel@gmail.com", "Dublin 1",  accountslist);
            Customer cu2 = new Customer (2, "Jack", "Ryan", "EvaEmployee", "jack@gmail.com", "Dublin 4", accountslist);
            Customer cu3 = new Customer (3, "Emer", "Byrne","JackEmployee", "emer@gmail.com", "Dublin 8", accountslist);
            
                  
            list.add(cu1);
            list.add(cu2);
            list.add(cu3);
            
            init = false;
            
        }
    }


    public List<Customer> getAllCustomers(){
        return list;
    }
    
    public Customer getCustomer(int id){
        return list.get(id-1);                     // -1 because ArrayList count from 0
    }
    
    
     public Customer createCustomer(Customer cu) {
	cu.setId(list.size() + 1);
	list.add(cu);
	System.out.println("201 - resource created with path: /customers/" + String.valueOf(cu.getId()));
        System.out.println("Updated Customer:"+cu.printCustomer());
	return cu;
    }
     
     public List<Customer> getSearchCustomers(String FirstName, String author) {
        List<Customer> matcheslist = new ArrayList<>();
        
        for (Customer q: getAllCustomers()) {
            if ((FirstName == null || q.getFirstName().equals(FirstName)) 
                   && (author == null || q.getAuthor().equals(author))) {
               matcheslist.add(q);
            }
        }
        return matcheslist;
    }
     
     
}

