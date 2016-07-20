/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.controllers;

import com.dreamoval.aml.model.neo4j.nodes.Account;
import com.dreamoval.aml.model.neo4j.nodes.Transaction;
import com.dreamoval.aml.model.neo4j.services.NeoRestClient;
import com.dreamoval.aml.services.MonitoringService;
import com.dreamoval.aml.util.JSONResponse;
import com.google.gson.Gson;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author malike_st
 */
@RestController
public class TransactionController {

    @Autowired
    private NeoRestClient neo;

    @Autowired
    private MonitoringService service;
/**
 *  Method to create a transaction by sending a request using transactions and account details
 * @param transaction given to represent transaction details needed to create a transaction
 * @param sourceId given as the transaction source to create a transaction
 * @param destinationId given as the transaction destination to create a transaction
 * @param response given to set response type for a request
 * @param request given to set request type 
 * @return JSON response relative to the status of the action
 */
    @RequestMapping(value = "/send/transactions", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public JSONResponse sendTransactions(
            @RequestParam("transaction") String transaction,
            @RequestParam("sourceId") String sourceId,
            @RequestParam("destinationId") String destinationId,
            HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("application/json;charset=UTF-8");
        JSONResponse jSONResponse = new JSONResponse();
        Transaction t = new Gson().fromJson(transaction, Transaction.class);
        t.setDate(new Date());
//        Account s = (Account) neo.getAccountsForCustomer(sourceId);
//        Account d = (Account) neo.getAccountsForCustomer(destinationId);
        neo.addTransaction(t, t.getSource(), t.getDestination());
        jSONResponse.setStatus(true);
        jSONResponse.setMessage("Success");
        return jSONResponse;
    }
/**
 * Method to get all transactions
 * @return all transactions as an object
 */
    @RequestMapping(value = "/transaction/all", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Object getTransactions() {
        return neo.getTransactions();
    }

    /**
     * Method to get a transaction specific to the transaction ID
     * @param transactionId given to get a specific transaction
     * @return a specific transaction
     */
    @RequestMapping(value = "/transaction/get", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Object fetchTransaction(Long transactionId) {
        return neo.getTransactionById(transactionId);
    }

    /**
     *Method to create a new transaction given its source and destination
     * @param transaction given to represent transaction details needed to create new transactions
     * @return boolean to indicate status of  action
     */
    @RequestMapping(value = "/transaction/create", method = RequestMethod.GET, consumes = "application/json")
    public @ResponseBody
    boolean createTransaction(@RequestParam("transaction") String transaction) {
        Transaction t = new Gson().fromJson(transaction, Transaction.class);
        return neo.addTransaction(t, t.getSource(), t.getDestination());
    }
}
