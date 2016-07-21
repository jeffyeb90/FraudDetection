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
     *Method to save the ITransaction
     * @param transaction given as the ITransaction to be saved
     * @return results after save
     */
    public ITransaction save(ITransaction transaction){
        return this.repository.save(transaction);
    }

    /**
     * Method to delete the ITransaction
     * @param transaction given as the ITransaction to be deleted
     */
    public void delete(ITransaction transaction){
        this.repository.delete(transaction);
    }

    /**
     *Method to find a specific ITransaction using an ID
     * @param id given to find a specific ITransaction
     * @return results after search
     */
    public ITransaction findById(String id){
        return this.repository.findById(id);
    }

    /**
     *Method to find all ITransactions in a list
     * @return a list of ITransactions
     */
    public List<ITransaction> findAll(){
        return this.repository.findAll();
    }
}
