package com.reto.reto3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.Repository.CrudRepository.PartyroomCrudRepository;
import com.reto.reto3.model.Partyroom;

@Repository
public class PartyroomReposirory {

    @Autowired
    private PartyroomCrudRepository partyroomCrudRepository;

    //Los metodos

    public List<Partyroom> getAll() {
        return (List<Partyroom>)partyroomCrudRepository.findAll();

    }

    public Optional<Partyroom> getPartyroom(int id){
        return partyroomCrudRepository.findById(id);
    }

    public Partyroom save(Partyroom partyroom){
        return partyroomCrudRepository.save(partyroom);

    }

    public void delete(Partyroom partyroom){
        partyroomCrudRepository.delete(partyroom);
    }

    
}
