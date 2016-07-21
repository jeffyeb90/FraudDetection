package com.dreamoval.aml.model.mongo.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by dreamadmin 
 */

public class ITransaction {
    @Id
    private String id;
    private String narrative;
    private String type;
    private String source;
    private String destination;
    private String flag;
    private Double amount;
    private Date date;
    private String sourceAccount;
    private String destinationAccount;

    /**
     * Method to get ID of ITransaction
     * @return ID
     */
    public String getId() {
        return id;
    }
/**
 * Method to set ID of ITransaction
 * @param id given to set ID of the ITransaction
 */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *Method to get description of the ITransaction
     * @return narrative as a description of the ITransaction
     */
    public String getNarrative() {
        return narrative;
    }

    /**
     * Method to set the description of the ITransaction
     * @param narrative given to set the description of the ITransaction
     */
    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    /**
     * Method to get type of the ITransaction
     * @return type of ITransaction
     */
    public String getType() {
        return type;
    }

    /**
     * Method to set type of ITransaction
     * @param type given to set type of ITransaction
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *Method to get source information of  ITransaction
     * @return source information of a specific ITransaction
     */
    public String getSource() {
        return source;
    }

    /**
     *Method to set source information of the ITransaction
     * @param source given to to set the source of ITransaction
     */
    public void setSource(String source) {
        this.source = source;
    }

    /**
     * Method to get the destination information of ITransaction
     * @return destination information
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Method to set the destination information of ITransaction
     * @param destination given to set the destination information of ITransaction
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     *Method to return a flag on the ITransaction
     * @return flag information
     */
    public String getFlag() {
        return flag;
    }

    /**
     *Method to set flag for the ITransaction
     * @param flag given to set flag information for the ITransaction
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     *Method to get amount on the ITransaction
     * @return specific amount relative to the ITransaction
     */
    public Double getAmount() {
        return amount;
    }

    /**
      Method to set amount for the ITransaction
     * @param amount given to set the ITransaction amount
     */
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    /**
     *Method to get the date of the ITransaction 
     * @return date as a date instance
     */
    public Date getDate() {
        return date;
    }

    /**
     *Method to set the date of the ITransaction
     * @param date given to set date of the ITransaction
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Method to get source account information for ITransaction
     * @return source account information
     */
    public String getSourceAccount() {
        return sourceAccount;
    }

    /**
     *Method to set source account information for ITransaction
     * @param sourceAccount given to set the source account information
     */
    public void setSourceAccount(String sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    /**
     *Method to get the destination account information for ITransaction
     * @return the destination account information
     */
    public String getDestinationAccount() {
        return destinationAccount;
    }

    /**
     * method to set the destination account information for ITransaction
     * @param destinationAccount given to set the destination account information of the ITransaction
     */
    public void setDestinationAccount(String destinationAccount) {
        this.destinationAccount = destinationAccount;
    }
}
