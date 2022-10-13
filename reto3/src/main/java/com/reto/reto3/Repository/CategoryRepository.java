package com.reto.reto3.Repository;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.reto.reto3.Repository.CrudRepository.CategoryCrudRepository;
import com.reto.reto3.model.Category;

@Repository
public class CategoryRepository {
    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    //Los metodos

    public List<Category> getAll() {
        return (List<Category>)categoryCrudRepository.findAll();

    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category category){
        return categoryCrudRepository.save(category);

    }

    public void delete(Category category){
        categoryCrudRepository.delete(category);
    }

    
}
