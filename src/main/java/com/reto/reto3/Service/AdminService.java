package com.reto.reto3.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.reto3.Repository.AdminRepository;
import com.reto.reto3.model.Admin;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // creamos los servicios 
    public List<Admin> getAll() {
        return (List<Admin>)adminRepository.getAll();

    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    // metodo post o guardar
    public Admin save (Admin admin){
        if(admin.getIdAdmin()== null){
            return adminRepository.save(admin);
      
        }else{
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(admin.getIdAdmin());
            if(adminEncontrado.isEmpty()){
                return adminRepository.save(admin);

            }else{
                return admin;
            }
        }

    }

    // Actualizar datos
    public Admin update(Admin admin){
        if(admin.getIdAdmin() !=null){
            Optional<Admin> adminEncontrado = adminRepository.getAdmin(admin.getIdAdmin());
            if(!adminEncontrado.isEmpty()){
                if(admin.getPassword() !=null){
                    adminEncontrado.get().setPassword(admin.getPassword());
                }
                
                return adminRepository.save(adminEncontrado.get());
            }
        }
        return admin;
    }

    // Metodo eliminar

    public boolean deleteAdmin(int adminId){
        Boolean resultado = getAdmin(adminId).map(adminPorEliminar ->{
            adminRepository.delete(adminPorEliminar);
            return true ;
        }).orElse(false);
        return resultado;
    }

    

    
}
