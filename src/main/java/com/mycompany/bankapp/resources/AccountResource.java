package com.mycompany.bankapp.resources;

import com.mycompany.bankapp.models.Account;
import com.mycompany.bankapp.services.AccountService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/accounts")
@Consumes (MediaType.APPLICATION_JSON)
@Produces (MediaType.APPLICATION_JSON)
public class AccountResource {
    
    private AccountService AccountService = new AccountService();
    
    @GET
    public List<Account> getAccounts (@PathParam("customerID") int cu_id) {
        System.out.println("getAllAccountsForCustomer..." + cu_id);
        return AccountService.getAllAccountsByCustomer(cu_id);  // we separate two types od resources: 
                                                                                      //customers and accounts
    }
    
    @GET
    @Path("/{accountID}")
    public Account getAccount (@PathParam("accountID") int acc_id,@PathParam("customerID") int cu_id){
        System.out.println("getAccountByID..." +acc_id + " for CustomerID " +cu_id);
        return AccountService.getAccountByID(cu_id,acc_id);
    }
            
}




