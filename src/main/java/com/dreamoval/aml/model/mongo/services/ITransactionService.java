package com.dreamoval.aml.model.mongo.services;

import com.dreamoval.aml.model.mongo.domain.ITransaction;
import com.dreamoval.aml.model.mongo.repositories.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Created by dreamadmin on 10/11/14.
 */
@Service
public class ITransactionService {

    @Autowired
    ITransactionRepository repository;

    /**
     *
     * @param transaction
     * @return
     */
    public ITransaction save(ITransaction transaction){
        return this.repository.save(transaction);
    }

    /**
     *
     * @param transaction
     */
    public void delete(ITransaction transaction){
        this.repository.delete(transaction);
    }

    /**
     *
     * @param id
     * @return
     */
    public ITransaction findById(Long id){
        return this.repository.findById(id);
    }

    /**
     *
     * @return
     */
    public List<ITransaction> findAll(){
        return this.repository.findAll();
    }
}
