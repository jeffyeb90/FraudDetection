package com.dreamoval.aml.model.neo4j.repositories;

import com.dreamoval.aml.model.neo4j.nodes.Customer;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dreamadmin on 10/10/14.
 */
@Repository
public interface CustomerRepository extends GraphRepository<Customer> {
}
