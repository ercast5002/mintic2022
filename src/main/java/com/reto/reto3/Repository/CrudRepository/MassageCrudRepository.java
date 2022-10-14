package com.reto.reto3.Repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;

import com.reto.reto3.model.Message;

public interface MassageCrudRepository extends CrudRepository<Message, Integer> {
    
}
