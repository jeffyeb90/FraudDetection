package com.dreamoval.aml.model.mongo.domain;

import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * Created by dreamadmin 
 */

public class Rule {
    @Id
    private String id;
    private String query;
    private Date dateCreated;

    /**
     *Method to return the Rule ID
     * @return rule ID
     */
    public String getId() {
        return id;
    }

    /**
     *Method to set the Rule ID
     * @param id given to set the Rule ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *Method to get specific query of a rule
     * @return query information for a rule
     */
    public String getQuery() {
        return query;
    }

    /**
     *Method to set query of a Rule
     * @param query given to set the query of a rule
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     *Method to get the date a rule was created
     * @return the date a rule was created
     */
    public Date getDateCreated() {
        return dateCreated;
    }

    /**
     * Method to set the  date a rule was created
     * @param dateCreated given to set the date a rule was created
     */
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
