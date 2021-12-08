
package com.mycompany.bankapp.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Customer {
    private int id;
    private String FirstName;
    private String SecondName;
    private Date created;
    private String author;
    private String email;
    private String address;
    
    private List<Account> accounts = new ArrayList<>();

    public Customer(){}        // no-argument constructor in addition to the default constructor
    
    public Customer (int id, String FirstName, String SecondName, String author, String email, 
            String address, List<Account> accounts){
        this.id = id;
        this.FirstName = FirstName;
        this.SecondName = SecondName;
        this.author = author;
        this.created = new Date();
        this.email = email;
        this.address = address;
        this.accounts = accounts;
        
    
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    
    public String getSecondName(){
        return SecondName;
    }
     public void setSecondName(String SecondName){
         this.SecondName = SecondName;
     }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
   public String getEmail(){
       return email;
   }
   public void setEmail(String email){
       this.email = email;
   }
   
   public String getAddress(){
       return address;
   }
   public void setAddress(String address){
       this.address = address;
   }
   
  
    public List<Account> getAccounts(){
        return accounts;
    }
    
    public void setAccounts(List<Account> accounts){
        this.accounts = accounts;
    }
    public void addAccountToMsg(Account account){
        (this.accounts).add(account);
    }
    
    

    public String printCustomer() {
        String str = this.getId()+" "+this.getAuthor()+ " "+this.getFirstName()+ " " + this.getSecondName()+
                " " +this.getEmail()+   " "+this.getAddress()+ " ";
        return str;
    }
    
    public String printAllAccounts() {                 // this extra method create string with a spece between 
        String allacc = " ";                                    //  each account
        for ( int i=0; i<accounts.size(); i++)
            allacc = allacc+accounts.get(i).printAccount() +" ";
        return allacc;
    }
    
    
}

