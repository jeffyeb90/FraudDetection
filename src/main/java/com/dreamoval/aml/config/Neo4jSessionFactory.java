/**
package com.dreamoval.aml.config;

import com.dreamoval.aml.model.neo4j.repositories;
import com.dreamoval.aml.model.neo4j.nodes;
import org.eclipse.jetty.server.session.JDBCSessionManager.Session;
/**
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
import  org.neo4j.ogm.session.Session;
/**
 * Created by dreamadmin on 10/10/14.
 *

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.rest.SpringRestGraphDatabase;
*/
/**
@Configuration
public class Neo4jSessionFactory {

    private final static SessionFactory sessionFactory = new SessionFactory("school.domain");
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }

    private Neo4jSessionFactory() {
    }

    public Session getNeo4jSession() {
        return sessionFactory.openSession();
    }
}*/