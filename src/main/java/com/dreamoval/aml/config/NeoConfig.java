package com.dreamoval.aml.config;

//import com.dreamoval.aml.model.neo4j.repositories;
//import com.dreamoval.aml.model.neo4j.nodes;
//import org.eclipse.jetty.server.session.JDBCSessionManager.Session;

//import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
//import  org.neo4j.ogm.session.Session;
/**
 * Created by dreamadmin on 10/10/14.
 */

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;


@Configuration
@EnableNeo4jRepositories
public class NeoConfig extends Neo4jConfiguration {

    /**
     * Method to set base package for neo4j configuration
     */
	public  NeoConfig() {
		setBasePackage("com.dreamoval.aml");
	}
/**
 * creates new graph database
 * @return  database in the given location
 */
	@Bean
	GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase("/Users/JeffreyTakyi-Yeboah/Documents/Neo4j/default.graphdb");
	}
}