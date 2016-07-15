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

    //@Autowired
    ITransactionRepository repository;

    public ITransaction save(ITransaction transaction){
        return this.repository.save(transaction);
    }
    public void delete(ITransaction transaction){
        this.repository.delete(transaction);
    }

    public ITransaction findById(Long id){
        return this.repository.findById(id);
    }
    public List<ITransaction> findAll(){
        return this.repository.findAll();
    }
}
