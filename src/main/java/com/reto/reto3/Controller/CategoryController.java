package com.reto.reto3.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.reto.reto3.Service.CategoryService;
import com.reto.reto3.model.Category;

@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
    RequestMethod.DELETE })
@RestController
@RequestMapping("/api/Category")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping("/all")
  public List<Category> getAll() {
    return categoryService.getAll();
  }

  @GetMapping("/{id}")
  public Optional<Category> getCategory(@PathVariable("id") int id) {
    return categoryService.getCategory(id);
  }

  @PostMapping("/save")
  @ResponseStatus(HttpStatus.CREATED)
  public Category save(@RequestBody Category category) {
    return categoryService.save(category);
  }

}
