package com.dreamoval.aml.model.mongo.repositories;

import com.dreamoval.aml.model.mongo.domain.ITransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dreamadmin 
 */
@Repository("ITransactionRepository")
public interface ITransactionRepository extends MongoRepository<ITransaction,Long> {

    /**
     *Abstract method to get the ID of ITransaction, implemented by Spring 
     * @param id given to get a specific ITransaction
     * @return ITransaction
     */
    public ITransaction findById(String id);
}
