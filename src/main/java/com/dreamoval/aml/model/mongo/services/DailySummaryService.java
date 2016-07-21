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

/**
 * Created by dreamadmin on 7/24/14.
 */
@Service
public class DailySummaryService {

    @Autowired
    private DailySummaryRepository dailySummaryRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     *
     * @param dailySummary
     * @return
     */
    public DailySummary save(DailySummary dailySummary){
        return this.dailySummaryRepository.save(dailySummary);
    }

    /**
     *
     * @return
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
     *
     * @return
     */
    public List<DailySummary> findMonthlySummary(){
        DateTime beginning = new DateTime().dayOfMonth().withMinimumValue().withTimeAtStartOfDay();
        DateTime end = new DateTime().dayOfMonth().withMaximumValue().withTime(23, 59, 59, 999);
        Query query = new Query();
        query.addCriteria(Criteria.where("dateCreated").gt(beginning).lte(end));

        return mongoTemplate.find(query,DailySummary.class);
    }

    /**
     *
     * @param dailySummary
     */
    public void delete(DailySummary dailySummary){
        this.dailySummaryRepository.delete(dailySummary);
    }

    /** depending on the time the application is started and ends, a query is executed to update flagged
  transactions using mongo operations
  *if the transaction exists, update the date created with the new time
  * if not insert a transaction and date created
     * @param field
     * @param count
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
