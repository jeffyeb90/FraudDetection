package com.dreamoval.aml.model.neo4j.nodes;

import com.dreamoval.aml.model.neo4j.nodes.Account;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**The Class represents the customer model with respect to its relationships and data 
*Modified by dreamadmin on 20/06/16.
*@author dreamadmin
*Customer  class
*/

/**class is represented as a node */
@NodeEntity
public class Customer {
 /** the id given to the customer node*/
    @GraphId
    private String id;
    
    private String name;
    private boolean kycVerified;
    private int riskScore;
    @JsonIgnoreProperties
    
    @RelatedTo(type = "Owns", direction = Direction.OUTGOING)
    public @Fetch
    Set<Account> accounts;


     /**Method to return customer ID
     * @return the customer id
     */ 
    public String getId() {
        return id;
    }
    /**Method to return customer name
     * @return the customer name
     */
    public String getName() {
        return name;
    }
 
     /**Method to set customer name
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**Method to check if customer details are verified
     * @return boolean if customer details are verified 
     */
    public boolean isKycVerified() {
        return kycVerified;
    }

    /**Method to set boolean for the customer's verification
     * @param kycVerified the boolean to confirm customer verification
     */
    public void setKycVerified(boolean kycVerified) {
        this.kycVerified = kycVerified;
    }

     /**Method to get risk score for customer
     * @return riskScore based on customer activities
     */
    public int getRiskScore() {
        return riskScore;
    }
    /**Method to set risk score for a customer
     * @param riskScore the riskScore to set for customer, based on activities
     */
    public void setRiskScore(int riskScore) {
        this.riskScore = riskScore;
    }
    
    /**
     * Method for string conversion
     * @return results after string conversion
     */
    @Override
    public String toString() {
        String results = name + "'s accounts are";
        if (accounts != null) {
            for (Account account : accounts) {
                results += "\t- " + account.getAccountNumber() + "\n";
            }
        }
        return results;
    }
}
