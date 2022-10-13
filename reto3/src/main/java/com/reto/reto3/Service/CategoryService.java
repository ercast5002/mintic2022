package com.reto.reto3.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reto.reto3.Repository.CategoryRepository;
import com.reto.reto3.model.Category;

@Service
public class CategoryService {
    
    @Autowired
    private  CategoryRepository categoryRepository;

    // creamos los servicios 
    public List<Category> getAll() {
        return (List<Category>)categoryRepository.getAll();

    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    // metodo post o guardar
    public Category save (Category category){
        if(category.getId()== null){
            return categoryRepository.save(category);
      
        }else{
            Optional<Category> categoryEncontrado = categoryRepository.getCategory(category.getId());
            if(categoryEncontrado.isEmpty()){
                return categoryRepository.save(category);

            }else{
                return category;
            }
        }

    }

    // Actualizar datos
    public Category update(Category category){
        if(category.getId() !=null){
            Optional<Category> categoryEncontrado = categoryRepository.getCategory(category.getId());
            if(!categoryEncontrado.isEmpty()){
                if(category.getDescription() !=null){
                    categoryEncontrado.get().setDescription(category.getDescription());
                }
                if(category.getName() != null){
                    categoryEncontrado.get().setName(category.getName());
                }

                return categoryRepository.save(categoryEncontrado.get());
            }
        }
        return category;
    }

    // Metodo eliminar

    public boolean deleteCategory(int categoryId){
        Boolean resultado = getCategory(categoryId).map(categoryPorEliminar ->{
            categoryRepository.delete(categoryPorEliminar);
            return true ;
        }).orElse(false);
        return resultado;
    }

}
