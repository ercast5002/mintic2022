package com.reto.reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto.reto3.Repository.MessageReposytory;
import com.reto.reto3.model.Message;

@Service
public class MessageService {
    @Autowired
    private MessageReposytory messageReposytory;

    // creamos los servicios 
    public List<Message> getAll() {
        return (List<Message>)messageReposytory.getAll();

    }

    public Optional<Message> getMessage(int id){
        return messageReposytory.getMessage(id);
    }

    // metodo post o guardar
    public Message save (Message message){
        if(message.getIdMessage()== null){
            return messageReposytory.save(message);
      
        }else{
            Optional<Message> messageEncontrado = messageReposytory.getMessage(message.getIdMessage());
            if(messageEncontrado.isEmpty()){
                return messageReposytory.save(message);

            }else{
                return message;
            }
        }

    }

    // Actualizar datos
    public Message update(Message message){
        if(message.getIdMessage() !=null){
            Optional<Message> messageEncontrado = messageReposytory.getMessage(message.getIdMessage());
            if(!messageEncontrado.isEmpty()){
                if(message.getMessegeText() !=null){
                    messageEncontrado.get().setMessegeText(message.getMessegeText());
                }
                
                return messageReposytory.save(messageEncontrado.get());
            }
        }
        return message;
    }

    // Metodo eliminar

    public boolean delete(int Id){
        Boolean resultado = getMessage(Id).map(messagePorEliminar ->{
            messageReposytory.delete(messagePorEliminar);
            return true ;
        }).orElse(false);
        return resultado;
    }

    
}
