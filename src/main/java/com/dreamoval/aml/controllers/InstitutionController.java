/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.controllers;

import com.dreamoval.aml.model.neo4j.nodes.Institution;
import com.dreamoval.aml.model.neo4j.services.NeoRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dreamadmin
 */
@RestController
public class InstitutionController {
    //@Autowired
  private  NeoRestClient neo;
    
    @RequestMapping(value="/fi/all")
    public @ResponseBody Object getInstitutions(){
        return neo.getInstitutions();
    }
    
    @RequestMapping(value="/fi/get", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody Object fetchInstitution(String shortName){
        return neo.getInstitutionByShortName(shortName);
    }
    
    @RequestMapping(value="/fi/create", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody boolean createInstitution(Institution institution){
        return neo.addFinancialInstitution(institution);
    } 
    
    @RequestMapping(value="/fi/accounts", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody Object getInstitutionAccounts(String shortName){
        return neo.getAccountsForInstitution(shortName);
    }
}