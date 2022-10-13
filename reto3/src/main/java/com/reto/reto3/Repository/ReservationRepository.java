package com.reto.reto3.Repository;




import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.Repository.CrudRepository.ReservationCrudRepository;
import com.reto.reto3.model.Reservation;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    //Los metodos

    public List<Reservation> getAll() {
        return (List<Reservation>)reservationCrudRepository.findAll();

    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);

    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }
    
    
}
