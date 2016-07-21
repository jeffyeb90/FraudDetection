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
     *
     * @param id
     * @return
     */
    public Rule find(String id) {
        return queryRepository.findById(id);
    }

    /**
     *
     * @return
     */
    public List<Rule> findAll() {
        return queryRepository.findAll();
    }

    /**
     *
     * @param rule
     * @return
     */
    public Rule save(Rule rule) {
        return queryRepository.save(rule);
    }

    /**
     *
     * @param rule
     */
    public void delete(Rule rule) {
        queryRepository.delete(rule);
    }
}
