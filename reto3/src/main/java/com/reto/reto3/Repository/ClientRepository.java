package com.reto.reto3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.Repository.CrudRepository.ClientCrudRepository;
import com.reto.reto3.model.Client;

@Repository
public class ClientRepository {

    @Autowired
    private ClientCrudRepository clientCrudRepository;

    //Los metodos

    public List<Client> getAll() {
        return (List<Client>)clientCrudRepository.findAll();

    }

    public Optional<Client> getClient(int id){
        return clientCrudRepository.findById(id);
    }

    public Client save(Client client){
        return clientCrudRepository.save(client);

    }

    public void delete(Client client){
        clientCrudRepository.delete(client);
    }

    
}
