package com.reto.reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto.reto3.Repository.PartyroomReposirory;
import com.reto.reto3.model.Partyroom;

@Service
public class PartyroomService {
    @Autowired
    private PartyroomReposirory partyroomRepository;

    // creamos los servicios

    public List<Partyroom> getAll() {
        return (List<Partyroom>) partyroomRepository.getAll();

    }

    public Optional<Partyroom> getPartyroom(int id) {
        return partyroomRepository.getPartyroom(id);
    }
    
    // Guardas datos
    public Partyroom save(Partyroom partyroom) {
        if (partyroom.getId() == null) {
            return partyroomRepository.save(partyroom);

        } else {
            Optional<Partyroom> partyroomEncontrado = partyroomRepository.getPartyroom(partyroom.getId());
            if (partyroomEncontrado.isEmpty()) {
                return partyroomRepository.save(partyroom);

            } else {
                return partyroom;
            }
        }
    }

    public Partyroom update(Partyroom partyroom){

        if(partyroom.getId() != null){
            Optional<Partyroom> partyroomEncontrado = partyroomRepository.getPartyroom(partyroom.getId());
            if(!partyroomEncontrado.isEmpty()){
                partyroomEncontrado.get().setName(partyroom.getName());
            }
            if(partyroom.getOwner() != null){
                partyroomEncontrado.get().setOwner(partyroom.getOwner());
            }
            if(partyroom.getCapacity() != null){
                partyroomEncontrado.get().setCapacity(partyroom.getCapacity());
            }
            
            if(partyroom.getDescription() != null){
                partyroomEncontrado.get().setDescription(partyroom.getDescription());
            }
            if(partyroom.getCategory() != null){
                partyroomEncontrado.get().setCategory(partyroom.getCategory());
            }
            return partyroomRepository.save(partyroomEncontrado.get());
        }
        
        return partyroom;
    }   
    
    public boolean delete(int id){
        Boolean respuesta = getPartyroom(id).map(elemento ->{
            partyroomRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
