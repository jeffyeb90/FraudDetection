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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dreamadmin
 */
@RestController
public class AccountController {
    
   @Autowired
  private  NeoRestClient neo;
    
    @RequestMapping(value="/account/all")
    public @ResponseBody Object getAccounts(){
        return neo.getAccounts();
    }
    
    @RequestMapping(value="/account/get", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody Object fetchAccount(String accountNumber){
        return neo.getAccountByNumber(accountNumber);
    }
    
    @RequestMapping(value="/account/create", method=RequestMethod.POST, consumes="application/json")
    public boolean createAccount(Account account, String customerNo){
        return neo.addAccount(account.getCustomer(), account);
    }
    
    @RequestMapping(value="/account/transactions", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody Object getAccountTransactions(String accountNumber){
        return neo.getAccountTransactions(accountNumber);
    }
    
   
}
