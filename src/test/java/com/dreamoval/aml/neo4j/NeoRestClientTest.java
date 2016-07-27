package com.dreamoval.aml.neo4j;

import com.dreamoval.aml.model.neo4j.services.NeoRestClient;
import com.dreamoval.aml.Application;
import com.dreamoval.aml.model.Response;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class NeoRestClientTest {

    @Autowired
    NeoRestClient rest;

    @Test
    public void testAddNode() throws Exception {
//        rest.addNode("{\"name\":\"Stephen\"}");
        System.out.println("test1");
        MultiValueMap<String,String> map = new LinkedMultiValueMap<String, String>();
         System.out.println("test2");
        map.add("query","MATCH (n:`Account`)<-[:Owns]-(c:Customer {id:'005'}) RETURN n LIMIT 25");
         System.out.println("test3");
        //Gson gson = new Gson();
        Response result = rest.runQuery(map);
    System.out.println("test4");
        System.out.println(result.getData());
        System.out.println("test5");
//        Response response = gson.fromJson(result,Response.class);

    }
}
