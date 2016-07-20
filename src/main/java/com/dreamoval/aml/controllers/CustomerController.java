/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.controllers;

import com.dreamoval.aml.model.neo4j.nodes.Account;
import com.dreamoval.aml.model.neo4j.nodes.Customer;
import com.dreamoval.aml.model.neo4j.nodes.Institution;
import com.dreamoval.aml.model.neo4j.services.NeoRestClient;
import com.dreamoval.aml.util.JSONResponse;
import com.google.gson.Gson;
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
 * @RequestMapping(value="/customer/get", method=RequestMethod.POST,
 * consumes="application/json") public
 * @ResponseBody Customer fetchCustomer(Long customerId){ return
 * neo.getCustomerById(customerId); }
 *
 *
 * @author dreamadmin
 */
@RestController
public class CustomerController {

    @Autowired
   private NeoRestClient neo;

    /**
     *
     * @return
     */
    @RequestMapping(value = "/customer/all")
    public @ResponseBody
    Object getCustomers() {
        return neo.getCustomers();
    }

    /**
     *
     * @param customerId
     * @return
     */
    @RequestMapping(value = "/customer/get", method = RequestMethod.POST)
    public @ResponseBody
    Object fetchCustomer(@RequestParam(value="customerId") String customerId) {
        return neo.getCustomerById(customerId);
    }

    /**
     *Method to create a new customer given its relationship with account and financial institutions
     * @param customer given as a String to represent details of customer
     * @param account given as a String to represent account details for new customer
     * @param fi  given as a String to represent financial institution for new customer
     * @param response given to set response type relative to the request
     * @param request given to set request type
     * @return JSON message to indicate status of the action
     */
    @RequestMapping(value = "/customer/create", method = RequestMethod.GET)
    @ResponseBody
    public JSONResponse createCustomer(
            @RequestParam("customer") String customer,
            @RequestParam("account") String account,
            @RequestParam("fi") String fi,
            HttpServletResponse response, HttpServletRequest request) {
        response.setContentType("application/json;charset=UTF-8");
        JSONResponse jSONResponse = new JSONResponse();
        Customer c = new Gson().fromJson(customer, Customer.class);
        Account a = new Gson().fromJson(account, Account.class);
        Institution i = new Gson().fromJson(account, Institution.class);
        neo.addCustomer(c);
        neo.addAccount(c, a);
        neo.addFinancialInstitution(i);
        jSONResponse.setStatus(true);
        jSONResponse.setMessage("Success");
        return jSONResponse;
    }

    /**
     * Method to get accounts specific to a customer ID
     * @param customerId given to get the account details for a specific customer
     * @return specific accounts for customers
     */
    @RequestMapping(value = "/customer/accounts", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Object getCustomerAccounts(String customerId) {
        return neo.getAccountsForCustomer(customerId);
    }

    /**
     *Method to get specific customer transactions
     * @param customerId given to return transactions specific to a customer
     * @return customer transactions
     */
    @RequestMapping(value = "/customer/transactions", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody
    Object getCustomerTransactions(Long customerId) {
        return neo.getCustomerTransactions(customerId);
    }
}
