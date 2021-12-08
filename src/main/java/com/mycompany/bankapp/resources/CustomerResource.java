
package com.mycompany.bankapp.resources;

import com.mycompany.bankapp.models.Customer;
import com.mycompany.bankapp.services.CustomerService;
import java.util.List;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerResource {
    
    CustomerService customerService = new CustomerService();
    
    /*
    If using POSTMAN as client, remember setting a Header
    "Accept:application/json" for retrieving JSON format
   */
    
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomerJSON() {
        return customerService.getAllCustomers();
    }
    
    
    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomerJSON(@PathParam("customerId") int id) {
        return customerService.getCustomer(id);
    }
    
    /*
    * When using POSTMAN remember to include in Headers: Content-type : application/json
    * and include in the body of the request in RAW format the object in JSON notation
    e.g. 
    {"author":"Emer","created":"2018-10-27T00:39:57.726","customer":"This is a test message"} 
    
    */
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Customer postCustomer(Customer cu) {
        return customerService.createCustomer (cu);
        
    }
    @Path("/{customerID}/accounts")
    public AccountResource getAccountsResource() {
        System.out.println("Getting accounts subresources...");
        return new AccountResource();                         // connection between two java classes: 
                                                                         // CustomerResources.java and 
                                                                         // AccountResource.java
           
   /* Search for a Customer  
   GET http://localhost:49000/api/customers?author=Emer&message=this+is+a+test+customer      by @QueryParam customer content and by @QueryParam author     
   GET http://localhost:49000/api/customers?author=Emer      by @QueryParam author only
    */  
 
   /* 
   @GET 
   @Produces(MediaType.APPLICATION_JSON)
   
   public List<Customer> getFilteredCustomers(@QueryParam("customer") String customer, @QueryParam("author") String author) 
   { 
     if ((customer != null) || (author != null)) 
      {        
          return customerService.getSearchCustomers(customer, author); 
      } 
    return customerService.getAllCustomers();    
 }  
    */
    
    
    } 
}
