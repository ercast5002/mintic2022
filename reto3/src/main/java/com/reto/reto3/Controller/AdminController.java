package com.reto.reto3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto.reto3.Service.AdminService;
import com.reto.reto3.model.Admin;


@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping("api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
            public List<Admin> getAll() {
            return adminService.getAll();
            
        }

    @GetMapping("/{id}")
           public Optional<Admin> getAdmin (@PathVariable("id") int id){
           return adminService.getAdmin(id);
}

@GetMapping("/save")
@ResponseStatus(HttpStatus.CREATED)
           public Admin save (@RequestBody Admin admin){
           return adminService.save(admin);


}
}


