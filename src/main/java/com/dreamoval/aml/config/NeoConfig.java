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
class ApplicationConfig extends Neo4jConfiguration {

	public ApplicationConfig() {
		setBasePackage("com.dreamoval.aml");
	}

	@Bean
	GraphDatabaseService graphDatabaseService() {
		return new GraphDatabaseFactory().newEmbeddedDatabase("/Users/JeffreyTakyi-Yeboah/Documents/Neo4j/default.graphdb");
	}
}