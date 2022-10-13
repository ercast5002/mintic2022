package com.reto.reto3.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.Repository.CrudRepository.AdminCrudRepository;
import com.reto.reto3.model.Admin;

@Repository
public class AdminRepository {
    @Autowired
    private AdminCrudRepository adminCrudRepository;
    //Metodos del repository
    public List<Admin> getAll() {
        return (List<Admin>)adminCrudRepository.findAll();

    }

    public Optional<Admin> getAdmin(int id){
        return adminCrudRepository.findById(id);
    }

    public Admin save(Admin admin){
        return adminCrudRepository.save(admin);

    }

    public void delete(Admin admin){
        adminCrudRepository.delete(admin);
    }


}
