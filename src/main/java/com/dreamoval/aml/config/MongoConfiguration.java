/**
package com.dreamoval.aml.config;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages = "com.dreamoval.aml.mongo")
public class MongoConfiguration extends AbstractMongoConfiguration {
*/
    /**
     * A method to return the database name
     * @return Database name
     *
    @Bean
    protected String getDatabaseName() {
        return "aml-admin";
    }*/

    /**
     * Method to return Mongo object
     * @return Mongo object
     * @throws Exception given as exception while creating Mongo instance
     *
    @Bean
    public Mongo mongo() throws Exception {
        return new Mongo();
    }
}
*/