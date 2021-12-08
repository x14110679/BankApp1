package com.mycompany.bankapp.models;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
    
    private int id;
    private String account;
    
    public Account(){}                  // blank constructor
                                                // no-argument constructor in addition to the default constructor
    
    public Account(int id, String account){
        this.id = id;
        this.account= account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
    
    public  String printAccount() {                        // extra method 
        String str = this.getId() + this.getAccount();
        return str;
        
    }
}
