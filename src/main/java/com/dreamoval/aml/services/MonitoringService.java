package com.dreamoval.aml.services;

import com.dreamoval.aml.model.Response;
import com.dreamoval.aml.model.neo4j.nodes.Transaction;
import com.dreamoval.aml.model.mongo.domain.DailySummary;
import com.dreamoval.aml.model.mongo.domain.ITransaction;
import com.dreamoval.aml.model.mongo.domain.Rule;
import com.dreamoval.aml.model.mongo.services.DailySummaryService;
import com.dreamoval.aml.model.mongo.services.ITransactionService;
import com.dreamoval.aml.model.mongo.services.RuleService;
import com.dreamoval.aml.model.neo4j.services.NeoRestClient;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
/**pass transactions and based on rules find details of customers*/
/**
 * Created by dreamadmin on 10/11/14.
 */
@Component
public class MonitoringService {

    @Autowired
    NeoRestClient rest;

    @Autowired
    RuleService ruleService;

    @Autowired
    ITransactionService transactionService;

    @Autowired
    DailySummaryService dailySummary;
    
    @Autowired
    RuleClient ruleclient;
    //run query
    public String runQueries(Transaction transaction){
        
        /**takes a transaction, set the details and save
         *find  the rule
         *for each of the rules,update the transaction as flagged ,replace 'key' objects(customer and account)
         * with string rep ,  get the rule query and add to map
         *so for each rule, find the results based on the customer id and account id
         * get the transaction id based on the results for both source and destination account,tag either accounts and increment risk scoere
         * 
         * 
         */
        ITransaction tx = new ITransaction(); 

        tx.setAmount(transaction.getAmount());
        tx.setDate(transaction.getDate());
        tx.setDestination(transaction.getDestination());
        tx.setSource(transaction.getSource());
        tx.setId(transaction.getId());
        tx.setDestinationAccount(transaction.getDestinationAccount().getAccountNumber());
        tx.setSourceAccount(transaction.getSourceAccount().getAccountNumber());
        tx.setNarrative(transaction.getNarrative());
        tx.setType(transaction.getType());
        tx.setFlag(transaction.getFlag());

        transactionService.save(tx);
        
       
        List<Rule> rules = ruleclient.useRules();

        //for each query
        for(Rule rule:rules){  
            MultiValueMap<String,String> map = new LinkedMultiValueMap<String, String>();
          

            //run for source
            map.add("query",parseQuery(rule.getQuery(), transaction.getSourceAccount().getCustomer().getId(),
                    transaction.getSourceAccount().getId()));
            Gson gson = new Gson();
            Response result = rest.runQuery(map);
            if(result.getData().size()>0){
                  dailySummary.updateSummary("flaggedTransactions",1);
                //get query for for updating customer
                rest.updateNode(String.valueOf(transaction.getSourceAccount().getId()));
                //run query

                //send notification
                
            }

            //run for destination
            map.clear();
            map.add("query",parseQuery(rule.getQuery(),transaction.getSourceAccount().getCustomer().getId(),
                    transaction.getDestinationAccount().getId()));
            result = rest.runQuery(map);

            if(result.getData().size()>0){
                dailySummary.updateSummary("flaggedTransactions",1);

                //get query for for updating customer
                rest.updateNode(String.valueOf(transaction.getDestinationAccount().getId()));
                //run query

                //send notification
            }



        }




        return "done";
    }
/** changed  string declaration to object , value of ,gives string rep */
    public String parseQuery(String query,String customer, String accountId){
        query = query.replaceAll("<cust_id >",customer);
        query = query.replaceAll("<account_no>",accountId);
        return query;
    }

}
