/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.controllers;

import com.dreamoval.aml.Application;
import com.dreamoval.aml.model.neo4j.nodes.Account;
import com.dreamoval.aml.model.neo4j.services.NeoRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dreamadmin
 */
@Controller
public class AccountController {
    
   @Autowired
    NeoRestClient neo;
   
     @RequestMapping(value="/home")
    public @ResponseBody String home(){
        return "Welcome";
    }
    
   /**
    * A method to get all accounts as a web request. 
    * @return all accounts as object using the neoRestClient
    */
    @RequestMapping(value="/account/all", method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Object getAccounts(){
        return neo.getAccounts();
    }
    
    /**
     * method to fetch specific account details using the account number
     * @param accountNumber provided to get specific account details
     * @return specific account details using account number
     */
    @RequestMapping(value="/account/get", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody Object fetchAccount(@RequestBody String accountNumber){
        return neo.getAccountByNumber(accountNumber);
    }
    
    /**
     * Method to create accounts given the customer and account 
     * @param account given to create account for a customer 
     * @param customerNo given to create account for a specific customer
     * @return boolean for the classified result
     */
    @RequestMapping(value="/account/create", method=RequestMethod.POST, consumes="application/json")
    public boolean createAccount(@RequestBody Account account, String customerNo){
        return neo.addAccount(account.getCustomer(), account);
    }
    
    /**
     * Method to get account transactions using the account number
     * @param accountNumber given to return all transactions specific to an account
     * @return account transactions as an object 
     */
    @RequestMapping(value="/account/transactions", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody Object getAccountTransactions(@RequestBody String accountNumber){
        return neo.getAccountTransactions(accountNumber);
    }
    
   
}
