package com.dreamoval.aml.model.mongo.repositories;

import com.dreamoval.aml.model.mongo.domain.ITransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dreamadmin on 10/11/14.
 */
@Repository("ITransactionRepository")
public interface ITransactionRepository extends MongoRepository<ITransaction,Long> {

    public ITransaction findById(Long id);
}
