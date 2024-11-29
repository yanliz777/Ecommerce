package com.uniquindio.ecommerce.backend.infrastructure.rest;

import com.uniquindio.ecommerce.backend.application.CategoryService;
import com.uniquindio.ecommerce.backend.domain.model.Category;
import com.uniquindio.ecommerce.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8085
@RequestMapping("/api/v1/categories")
//http://localhost:8085/api/v1/users: para acceder a este controlador
public class CategoryController {

    //inyectamos por constructor nuestro servicio CategoryService:
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*
   Con @RequestBody User user, indicamos el Body que envia el cliente en la petición.
   Y lo que hace @RequestBody es convertir un archivo Json a un Objeto java
   */
    @PostMapping("/saveCategory")
    public Category save(@RequestBody Category category) {
        return categoryService.save(category);
    }

    /*
    Con @PathVariable le  indicamos al metodo que cuando
    nos envien una variable mediante la URL se convierta al
    tipo de dato que tengo en los parametros(Integer)
     */
    @GetMapping("/findById/{id}")
    public Category findById(@PathVariable Integer id ) {
        return categoryService.findById(id);
    }

}
