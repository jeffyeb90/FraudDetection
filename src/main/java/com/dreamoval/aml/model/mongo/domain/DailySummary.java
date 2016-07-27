package com.dreamoval.aml.model.mongo.domain;

import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.UUID;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by dreamadmin 
 */

@Document(collection="daily_summary")
public class DailySummary {


    @Id
    private String id;
    private int transactionCount;
    private int flaggedTransactions;
    private DateTime dateCreated;
    @LastModifiedDate
    private DateTime lastModified;

    /**
     * Method to create a new date time instance
     */
    public DailySummary(){
        this.id = UUID.randomUUID().toString();
        dateCreated = new DateTime();
    }

    /**
     * Method to get number of transactions
     * @return the number of transactions
     */
    public int getTransactionCount() {
        return transactionCount;
    }

    /**
     * Method to set the specific transaction count
     * @param transactionCount given to set number of transactions
     */
    public void setTransactionCount(int transactionCount) {
        this.transactionCount = transactionCount;
    }

    /**
     * Method to get number of flagged transactions
     * @return number of flagged transactions
     */
    public int getFlaggedTransactions() {
        return flaggedTransactions;
    }

    /**
     * Method to set the number of flagged transactions
     * @param flaggedTransactions given to set the number of flagged transactions 
     */
    public void setFlaggedTransactions(int flaggedTransactions) {
        this.flaggedTransactions = flaggedTransactions;
    }

    /**
     * Method to return the id of the daily summary
     * @return the ID
     */
    public String getId() {
        return id;
    }

    /**
     * Method to get the date a daily summary was created
     * @return the date created as  date time instance
     */
    public DateTime getDateCreated() {
        return dateCreated;
    }

    /**
     * Method to set the date a daily summary was created
     * @param dateCreated  instance of dateTime to set the date a daily summary was created
     */
    public void setDateCreated(DateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * Method to get an instance of the dateTime a dailySummary was last modified
     * @return date for last modified summary
     */
    public DateTime getLastModified() {
        return lastModified;
    }


}
