/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.controllers;

import com.dreamoval.aml.model.nodes.Account;
import com.dreamoval.aml.model.nodes.Transaction;
import com.dreamoval.aml.neo4j.NeoRestClient;
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

/**
 *
 * @author malike_st
 */
@Controller
public class TransactionController {

    @Autowired
    private NeoRestClient neo;

    @Autowired
    private MonitoringService service;

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

    @RequestMapping(value = "/transaction/all", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Object getTransactions() {
        return neo.getTransactions();
    }

    @RequestMapping(value = "/transaction/get", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Object fetchTransaction(Long transactionId) {
        return neo.getTransactionById(transactionId);
    }

    @RequestMapping(value = "/transaction/create", method = RequestMethod.GET, consumes = "application/json")
    public @ResponseBody
    boolean createTransaction(@RequestParam("transaction") String transaction) {
        Transaction t = new Gson().fromJson(transaction, Transaction.class);
        return neo.addTransaction(t, t.getSource(), t.getDestination());
    }
}
