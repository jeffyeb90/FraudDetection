
package com.dreamoval.aml.model.neo4j.nodes;

import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

import java.util.Date;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**The Class represents the account model with respect to its data and relationships
*Modified by dreamadmin on 20/06/16.
*@author dreamadmin
*Account  class
*/


/**class is represented as a node */
@NodeEntity
public class Account {

/** the id given to the account node*/
    @GraphId
    private String id;
        
    private String accountNumber;
    private Double balance;
    private Date dateOpened;
    private String accountType;
    private String status;
    
/**creates a relationship between the customer and the account  */    
    @RelatedTo(type = "Owns", direction = Direction.INCOMING)
    private @Fetch
    Customer customer;
  
 /**creates a relationship between the customer and the account  */ 
    @RelatedTo(type = "Holds", direction = Direction.INCOMING)
    private @Fetch
    Institution institution;
    
/**creates relationship between account and a transaction  */
    @RelatedTo(type = "has", direction = Direction.OUTGOING)
    public @Fetch
    Transaction transaction;
    
/**this method returns the id of the account 
@return the account id
*/
    public String getId() {
        return id;
    }

/**this method returns the balance on the account 
@return the account balance
*/
    public Double getBalance() {
        return balance;
    }
/**this method sets the balance on the account 
 *@param balance is passed to set balance on account
@return nothing
*/
    public void setBalance(Double balance) {
        this.balance = balance;
    }



/**this method sets the account status
*@return the account status
*/ 
    public String getStatus() {
        return status;
    }

/**this method sets the account status
 *@param status is passed to set the account status 
@return the account status
*/  
    public void setStatus(String status) {
        this.status = status;
    }

 /** This  method returns a customer
  * @return the customer
 */
    public Customer getCustomer() {
        return customer;
    }

/*
 * @param customer the customer to set
 */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

/**
* @return the institution
*/
    public Institution getInstitution() {
        return institution;
    }

/**
 * @param institution the institution to set
 */
    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

/**this method returns the account number 
@return the account number
*/
    public String getAccountNumber() {
        return accountNumber;
    }
/**this method sets the account number of a user
@param accountNumber is passed to set the account number
*@return nothing
*/
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
/**this method returns the opening date of account 
@return the opening date of account 
*/
    public Date getDateOpened() {
        return dateOpened;
    }

/**this method sets the opening date of account
 *@param dateOpened passes the date on which the account was opened
@return the account balance
*/
    public void setDateOpened(Date dateOpened) {
        this.dateOpened = dateOpened;
    }

/**this method returns the account type
@return the account type
*/ 
    public String getAccountType() {
        return accountType;
    }
/**this method sets the account type
 *@param accountType is passed to set the account type 
@return nothing
*/ 
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
