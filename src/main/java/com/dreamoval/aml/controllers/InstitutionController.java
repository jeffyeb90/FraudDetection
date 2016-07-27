/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dreamoval.aml.controllers;

import com.dreamoval.aml.model.neo4j.nodes.Institution;
import com.dreamoval.aml.model.neo4j.services.NeoRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dreamadmin
 */
@Controller
public class InstitutionController {
    
    @Autowired
    NeoRestClient neo;
    
    /**
     *Method to get all institutions
     * @return all institutions as an object
     */
    @RequestMapping(value="/fi/all")
    public @ResponseBody Object getInstitutions(){
        return neo.getInstitutions();
    }
    
    /**
     * Method to get specific institution using their short name
     * @param shortName given to get specific institutions using their short name
     * @return specific institution as an object
     */
    @RequestMapping(value="/fi/get", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody Object fetchInstitution(@RequestBody String shortName){
        return neo.getInstitutionByShortName(shortName);
    }
    
    /**
     * Method to create new institution
     * @param institution details given to create an institution
     * @return boolean for the classified status of the action
     */
    @RequestMapping(value="/fi/create", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody boolean createInstitution(@RequestBody Institution institution){
        return neo.addFinancialInstitution(institution);
    } 
    
    /**
     * Method to  get accounts specific to an institution
     * @param shortName given to get accounts of an institution
     * @return institution accounts as an object
     */
    @RequestMapping(value="/fi/accounts", method=RequestMethod.POST, consumes="application/json")
    public @ResponseBody Object getInstitutionAccounts(@RequestBody String shortName){
        return neo.getAccountsForInstitution(shortName);
    }
}
