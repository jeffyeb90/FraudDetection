package com.dreamoval.aml.model.mongo.services;

import com.dreamoval.aml.model.mongo.domain.Rule;
import com.dreamoval.aml.model.mongo.repositories.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by dreamadmin on 10/11/14.
 */
@Service
public class RuleService {

    @Autowired
    RuleRepository queryRepository;

    /**
     *Method to find a rule using its ID
     * @param id given to find a specific rule
     * @return results after search 
     */
    public Rule find(String id) {
        return queryRepository.findById(id);
    }

    /**
     *Method to return all rules in a list
     * @return a list of rules
     */
    public List<Rule> findAll() {
        return queryRepository.findAll();
    }

    /**
     *Method to save a rule
     * @param rule given as a Rule to be saved
     * @return results after save
     */
    public Rule save(Rule rule) {
        return queryRepository.save(rule);
    }

    /**
     *Method to delete a rule
     * @param rule given as a Rule to be deleted
     */
    public void delete(Rule rule) {
        queryRepository.delete(rule);
    }
}
