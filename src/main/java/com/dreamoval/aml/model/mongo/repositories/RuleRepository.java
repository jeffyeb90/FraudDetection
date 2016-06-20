package com.dreamoval.aml.model.mongo.repositories;

import com.dreamoval.aml.model.mongo.domain.Rule;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by dreamadmin on 10/11/14.
 */
public interface RuleRepository extends MongoRepository<Rule, String> {

    public Rule findById(String id);
}
