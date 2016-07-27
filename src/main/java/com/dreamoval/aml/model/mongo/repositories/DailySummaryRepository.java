package com.dreamoval.aml.model.mongo.repositories;


import com.dreamoval.aml.model.mongo.domain.DailySummary;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by dreamadmin 
 */
@Repository
public interface DailySummaryRepository extends MongoRepository<DailySummary, Serializable> {
   
    /**
     *Abstract method to get the ID of a daily summary,implemented by Spring
     * @param id given to get a specific daily summary
     * @return daily summary
     */
    public DailySummary findById(String id);
}
