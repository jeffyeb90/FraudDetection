package com.dreamoval.aml.model.neo4j.services;

import com.dreamoval.aml.model.Response;
import com.dreamoval.aml.model.neo4j.nodes.Account;
import com.dreamoval.aml.model.neo4j.nodes.Customer;
import com.dreamoval.aml.model.neo4j.nodes.Institution;
import com.dreamoval.aml.model.neo4j.nodes.Transaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by dreamadmin 
 */
@Component
public class NeoRestClient {
    

    String baseUrl = "http://localhost:7474/db/data";
    /**
     *Method to add customer record
     * @param customer given to add customer record
     * @return boolean after action
     */
    public boolean addCustomer(Customer customer) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("CREATE  (:Customer {cid: '%s',name: '%s', kycVerified: %s, riskScore: %d})",customer.getId(), customer.getName(), customer.isKycVerified(), customer.getRiskScore());
            map.add("query", query);

            rest.postForEntity(url, map, Customer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     *Method to return all customers
     * @return customers as type Object
     */
    public Object getCustomers() {
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("query", "MATCH (c:Customer) return c");
            Response result = runQuery(map);

            return responseToCollection(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method to return customer using customer ID
     * @param customerId given to get a specific customer
     * @return specific customer as type Object
     */
    public Object getCustomerById(String customerId) {
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (c:Customer {id: '%s'}) return c", customerId);
            map.add("query", query);

            Response result = runQuery(map);
            return responseToObject(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Method to get accounts of Customers
     * @param customerId given to get customer accounts
     * @return customer accounts as type Object
     */
    public Object getAccountsForCustomer(String customerId) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (c:Customer {id: '%s'})-[:Owns]->(a:Account) return a", customerId);
            map.add("query", query);

            Response result = runQuery(map);
            ArrayList hashMap = (ArrayList) responseToCollection(result);
            if (null != hashMap) {
                return hashMap.get(0);
            }
            return null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method to get customer transactions
     * @param customerId given to get specific transactions for customer
     * @return customer transactions as type Object
     */
    public Object getCustomerTransactions(Long customerId) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (c:Customer {id: %d})-[:Owns]->(:Account)-[:Has]->(t:Transaction) return t");
            map.add("query", query);

            Response result = runQuery(map);
            return responseToCollection(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method to add new customer account
     * @param customer given to create customer details for account
     * @param account given to create account for customer
     * @return boolean after adding
     */
    public boolean addAccount(Customer customer, Account account) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query;
            query = String.format("MATCH (c:Customer {cid: '%s'}) CREATE UNIQUE (c)-[:Owns]->(:Account {accountNumber: '%s',accountType:'%s', balance: 0, dateOpened: %d, status: 'ACTIVE'})", customer.getId(), account.getAccountNumber(), account.getDateOpened().getTime());
            map.add("query", query);

            rest.postForEntity(url, map, Account.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     *Method to get all accounts created
     * @return all accounts
     */
    public Object getAccounts() {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (a:Account) return a");
            map.add("query", query);

            Response result = runQuery(map);
            return responseToCollection(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Method to get specific account using account number
     * @param accountNumber given to get a specific account
     * @return account 
     */
    public Object getAccountByNumber(String accountNumber) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (a:Account {accountNumber: %s}) return a", accountNumber);
            map.add("query", query);

            Response result = runQuery(map);
            return responseToObject(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method to get account transactions
     * @param accountNumber given to get account transactions
     * @return account transactions
     */
    public Object getAccountTransactions(String accountNumber) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (a:Account {accountNumber: '%s'})-[:Has]->(t:Transaction) return t", accountNumber);
            map.add("query", query);

            Response result = runQuery(map);
            return responseToCollection(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method to add new account transaction
     * @param transaction given as Transaction type to add new transaction
     * @param sourceAccount given as the source account information for new transaction
     * @param destinationAccount given as the destination account information for new transaction
     * @return boolean after add
     */
    public boolean addTransaction(Transaction transaction, String sourceAccount, String destinationAccount) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (a:Account {accountNumber: '%s'}) CREATE UNIQUE (a)-[:Has]->(:Transaction {narrative: '%s', type: '%s', source: '%s', destination: '%s', flag: '%s', amount: '%f', date: '%d'})",  transaction.getNarrative(), sourceAccount, destinationAccount, transaction.getFlag(), transaction.getAmount(), transaction.getDate().getTime());
            map.add("query", query);
            rest.postForEntity(url, map, Transaction.class);

            query = String.format("MATCH (b:Account {accountNumber: '%s'}), (t:Transaction {id: %d}) CREATE UNIQUE (b)-[:Has]->(t)", transaction.getDestinationAccount(), transaction.getId());
            map.add("query", query);
            rest.postForEntity(url, map, Account.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     *Method to get all transactions
     * @return all transactions
     */
    public Object getTransactions() {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (t:Transaction) return t");
            map.add("query", query);

            Response result = runQuery(map);
            return responseToCollection(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method to get a specific transaction
     * @param transactionId given as an ID to get a specific transaction
     * @return specific transaction
     */
    public Object getTransactionById(Long transactionId) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (t:Transaction {id: %d}) return t", transactionId);
            map.add("query", query);

            Response result = runQuery(map);
            return responseToObject(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method to add new financial institution
     * @param institution given as institution type to add a new financial institution
     * @return boolean after add
     */
    public boolean addFinancialInstitution(Institution institution) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("CREATE  (:Institution {name: '%s', shortName: '%s', country: '%s'})", institution.getName(), institution.getShortName(), institution.getCountry());
            map.add("query", query);

            rest.postForEntity(url, map, Customer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     *Method to get all institutions
     * @return institutions
     */
    public Object getInstitutions() {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (i:FI) return i");
            map.add("query", query);

            Response result = runQuery(map);
            return responseToCollection(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method get institution using its short name
     * @param shortName given as information get institution
     * @return institution
     */
    public Object getInstitutionByShortName(String shortName) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (i:FI {shortName: '%s'}) return i", shortName);
            map.add("query", query);

            Response result = runQuery(map);
            return responseToObject(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     *Method to get accounts of an institution using its short name
     * @param shortName given as information to get institution accounts
     * @return institution accounts
     */
    public Object getAccountsForInstitution(String shortName) {
        String url = baseUrl + "/node";
      
            RestTemplate rest = new RestTemplate();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            String query = String.format("MATCH (i:FI {shortName: '%s'})-[:Holds]->(a:Account) return a", shortName);
            map.add("query", query);
            Response result = runQuery(map);
            
            return responseToCollection(result);
        
    }

    /**
     *Method to add a new node
     * @param map given as MultiValueMap type with all queries to be executed for a node
     * @return String message
     */
    public String addNode(MultiValueMap<String, String> map) {
        String url = baseUrl + "/node";
        try {
            RestTemplate rest = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//            MultiValueMap<String,String> map = new LinkedMultiValueMap<String, String>();
//            map.add("name","Steve");
//            HttpEntity<String> entity = new HttpEntity<String>(node,headers);

            ResponseEntity<String> result = rest.postForEntity(url, map, String.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Ok";
    }

    /**
     *Method to update transaction information with regards to customer and account details
     * @param id given to update a specific transaction 
     * @return String message
     */
    public String updateNode(String id) {
        String url = baseUrl + "/cypher";
        try {
            RestTemplate rest = new RestTemplate();
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("query", "MATCH (:Transaction {id:" + id + "})<-[:Has]-(:Account)<-[:Owns]-(c:Customer) SET c.riskScore = (c.riskScore + 1) return c");
//            HttpEntity<String> entity = new HttpEntity<String>(node,headers);

            ResponseEntity<String> result = rest.postForEntity(url, map, String.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "ok";
    }

    /**
     *Method to run queries in a map
     * @param map given as multiValue map to serve as a place holder for queries to be executed
     * @return response
     */
    public Response runQuery(MultiValueMap<String, String> map) {
        String url = baseUrl + "/cypher";
       System.out.println("runquery1");
            RestTemplate rest = new RestTemplate();
            ResponseEntity<Response> result = rest.postForEntity(url, map, Response.class);
            return result.getBody();
       
       
        
    }

    /**
     *Method to get information from a response
     * @param result given as a response type to get information
     * @return data as an object type
     */
    public Object responseToObject(Response result) {
        ArrayList list = (ArrayList) result.getData();
        ArrayList records = (ArrayList) list.get(0);
        Map node = (Map) records.get(0);

        return node.get("data");
    }

    /**
     *Method to get information from a collection of responses
     * @param result given as a response type to get information
     * @return information from the collection
     */
    public Object responseToCollection(Response result) {
        ArrayList list = (ArrayList) result.getData();

        List<Map> coll = new ArrayList<Map>();

        for (Object record : list) {
            ArrayList<Map> nodes = (ArrayList<Map>) record;

            for (Map node : nodes) {
                coll.add((Map) node.get("data"));
            }
        }
        return coll;
    }

    /**
     *Method to make a call using the rest template
     * @param rest given as a restTemplate
     * @return String message
     */
    public String call(RestTemplate rest) {

        return "";
    }
}
