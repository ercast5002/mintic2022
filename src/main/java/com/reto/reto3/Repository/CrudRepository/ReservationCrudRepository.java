package com.reto.reto3.Repository.CrudRepository;

import org.springframework.data.repository.CrudRepository;

import com.reto.reto3.model.Reservation;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer> {
    
}
