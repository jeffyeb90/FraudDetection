package com.dreamoval.aml.model.neo4j.nodes;

import com.dreamoval.aml.model.neo4j.nodes.Account;
import java.util.Date;
import java.util.Set;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**The Class represents the transaction model with respect to its data and relationships
*Modified by dreamadmin on 20/06/16.
*@author dreamadmin
*Transaction  class
*/


/**class is represented as a node */
@NodeEntity
public class Transaction {

   /** the id given to the transaction node*/
    @GraphId
    private String id;
    
    private String narrative;
    private String type;
    private String source;
    private String destination;
    private String flag;
    private Double amount;
    private Date date;
    
    /** creates a relationship between a source account and a transaction */
    @RelatedTo(type = "Has", direction = Direction.INCOMING)
    private @Fetch
    Account sourceAccount;
    
     /** creates a relationship between a destination account and a transaction */
    @RelatedTo(type = "Has", direction = Direction.INCOMING)
    private @Fetch
    Account destinationAccount;

      
    /**Method to return ID of a transaction
     * @return the transaction id
     */
    public String getId() {
        return id;
    }

    /**Method to return the narrative of a transaction
     * @return the transaction's narrative
     */
    public String getNarrative() {
        return narrative;
    }

    /**Method to set the narrative of a transaction
     * @param narrative given as the narrative of the transaction
     */
    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    /**Method to return the type of transaction
     * @return the type of transaction
     */
    public String getType() {
        return type;
    }

    /**Method to set the type of transaction
     * @param type given as the type of transaction
     */
    public void setType(String type) {
        this.type = type;
    }

    /**Method to get the source of the transaction
     * @return the source of the transaction
     */
    public String getSource() {
        return source;
    }

    /**Method to set the source of the transaction
     * @param source given to set the source of transaction
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**Method to get the destination of the transaction
     * @return the destination of the transaction
     */
    public String getDestination() {
        return destination;
    }

    /**Method to set the destinationAccount of the transaction
     * @param destination given to set the destination of the transaction
     */
    public void setDestinationAccount(String destination) {
        this.destination = destination;
    }

    /**Method to get a flag on the transaction
     * @return the flag 
     */
    public String getFlag() {
        return flag;
    }

    /**Method to set the flag of the transaction
     * @param flag given to set the transaction flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**Method to get the amount on the transaction
     * @return the transaction amount
     */
    public Double getAmount() {
        return amount;
    }

    /**Method to set the transaction amount
     * @param amount the amount to set
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**Method to get the date of the transaction
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**Method to set the date of the transaction
     * @param date given as the transaction date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**Method to get the source account of the transaction
     * @return the sourceAccount of the transaction
     */
    public Account getSourceAccount() {
        return sourceAccount;
    }

    /**Method to set the source account of the transaction
     * @param sourceAccount given as the transaction's source account
     */
    public void setSourceAccount(Account sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    /**Method to return the destination account of the transaction
     * @return the destinationAccount
     */
    public Account getDestinationAccount() {
        return destinationAccount;
    }

    /**Method to set the destination account of a transaction
     * @param destinationAccount given as the transaction's destination account
     */
    public void setDestinationAccount(Account destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
