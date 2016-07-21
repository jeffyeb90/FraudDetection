package com.dreamoval.aml.model.mongo.repositories;

import com.dreamoval.aml.model.mongo.domain.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by dreamadmin 
 */
public interface RuleRepository extends MongoRepository<Rule, String> {

    /**
     *Abstract method to get the ID of ITransaction, implemented by Spring
     * @param id given to get a specific rule
     * @return rule
     */
    public Rule findById(String id);
}
