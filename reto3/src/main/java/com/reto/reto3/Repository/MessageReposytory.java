package com.reto.reto3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.Repository.CrudRepository.MassageCrudRepository;
import com.reto.reto3.model.Message;

@Repository
public class MessageReposytory {

    @Autowired
    private MassageCrudRepository messageCrudRepository;

    //Los metodos

    public List<Message> getAll() {
        return (List<Message>)messageCrudRepository.findAll();

    }

    public Optional<Message> getMessage(int id){
        return messageCrudRepository.findById(id);
    }

    public Message save(Message message){
        return messageCrudRepository.save(message);

    }

    public void delete(Message message){
        messageCrudRepository.delete(message);
    }

    
}
