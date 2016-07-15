/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.services;

import com.dreamoval.aml.model.mongo.domain.Rule;
import com.dreamoval.aml.model.mongo.services.RuleService;
import com.dreamoval.aml.model.neo4j.services.NeoRestClient;
import java.util.ArrayList;
import java.util.List;
//import static org.apache.coyote.ajp.Constants.a;
import org.springframework.beans.factory.annotation.Autowired;
 
/*
 * @author JeffreyTakyi-Yeboah
 */
public abstract class RuleClient implements List<Rule> {
    
    //@Autowired
    NeoRestClient rest1;

  //s@Autowired
    RuleService ruleService1;


    public List<Rule> useRules(){
     Rule nx = new Rule();
 
     nx.setQuery("");
         //ruleService1.save(nx);
   List<Rule> rules = new ArrayList<Rule>();
    // rules.save(nx);
   rules.add(nx);
       // rules = ruleService1.findAll();
        return rules;
    }
//get  private Object ruleService;
}
