package com.reto.reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto.reto3.Repository.ClientRepository;
import com.reto.reto3.model.Client;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    // creamos los servicios

    public List<Client> getAll() {
        return (List<Client>) clientRepository.getAll();

    }

    public Optional<Client> getClient(int id) {
        return clientRepository.getClient(id);
    }

    // Guardas datos
    public Client save(Client client) {
        if (client.getIdClient() == null) {
            return clientRepository.save(client);

        } else {
            Optional<Client> clientEncontrado = clientRepository.getClient(client.getIdClient());
            if (clientEncontrado.isEmpty()) {
                return clientRepository.save(client);

            } else {
                return client;
            }
        }
    }

    public Client update(Client client){

        if(client.getIdClient() != null){
            Optional<Client> clientEncontrado = clientRepository.getClient(client.getIdClient());
            if(!clientEncontrado.isEmpty()){
                clientEncontrado.get().setName(client.getName());
            }
            if(client.getAge() != null){
                clientEncontrado.get().setAge(client.getAge());
            }
            if(client.getPassword() != null){
                clientEncontrado.get().setPassword(client.getPassword());
            }
            return clientRepository.save(clientEncontrado.get());
        }
        return client;
    }   
    
    public boolean delete(int id){
        Boolean respuesta = getClient(id).map(elemento ->{
            clientRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }

}
