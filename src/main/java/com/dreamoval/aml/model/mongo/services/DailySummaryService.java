package com.dreamoval.aml.model.mongo.services;


import com.dreamoval.aml.model.mongo.domain.DailySummary;
import com.dreamoval.aml.model.mongo.repositories.DailySummaryRepository;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Created by dreamadmin
 */

@Service
public class DailySummaryService {

    
   
    @Autowired
     DailySummaryRepository dailySummaryRepository;

    @Autowired
     MongoTemplate mongoTemplate;
    

    /**
     * Method to save daily summary 
     * @param dailySummary given as a daily summary to be saved
     * @return results after a save
     */
    public DailySummary save(DailySummary dailySummary){
        return this.dailySummaryRepository.save(dailySummary);
    }

    /**
     *Method to find a daily summary 
     * @return a daily summary with details 
     */
    public DailySummary findDailySummary(){
        DateTime beginning = new DateTime();
        beginning = beginning.withTimeAtStartOfDay();

        DateTime end = new DateTime();
        end = end.withTime(23, 59, 59, 999);

        Query query = new Query();
        query.addCriteria(Criteria.where("dateCreated").gt(beginning).lte(end));

        return mongoTemplate.findOne(query,DailySummary.class);
    }

    /**
     *Method to find a list of monthly summaries
     * @return a list of monthly summaries
     */
    public List<DailySummary> findMonthlySummary(){
        DateTime beginning = new DateTime().dayOfMonth().withMinimumValue().withTimeAtStartOfDay();
        DateTime end = new DateTime().dayOfMonth().withMaximumValue().withTime(23, 59, 59, 999);
        Query query = new Query();
        query.addCriteria(Criteria.where("dateCreated").gt(beginning).lte(end));

        return mongoTemplate.find(query,DailySummary.class);
    }

    /**
     *Method to delete a daily summary
     * @param dailySummary given as a daily summary to be deleted
     */
    public void delete(DailySummary dailySummary){
        this.dailySummaryRepository.delete(dailySummary);
    }

  /**depending on the time the application is started and ends, a query is executed to update flagged
  transactions using mongo operations
  * if the transaction exists, update the date created with the new time
  * if not insert a transaction details and date created
  * Method to update details of a transaction with respect to time
     * @param field given to update the summary of specific transaction
     * @param count given to represent the count of a specific type of transaction
  */
    public void updateSummary(String field, int count){
        DateTime beginning = new DateTime();
        beginning = beginning.withTimeAtStartOfDay();

        DateTime end = new DateTime();
        end = end.withTime(23, 59, 59, 999);

        Query query = new Query();
        query.addCriteria(Criteria.where("dateCreated").gt(beginning).lte(end));
        Update update = new Update().inc(field,count).set("dateCreated",new DateTime());

        mongoTemplate.upsert(query,update,DailySummary.class);
    }
}
