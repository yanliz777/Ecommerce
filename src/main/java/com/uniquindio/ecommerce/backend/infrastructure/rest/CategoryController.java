package com.uniquindio.ecommerce.backend.infrastructure.rest;

import com.uniquindio.ecommerce.backend.application.CategoryService;
import com.uniquindio.ecommerce.backend.domain.model.Category;
import com.uniquindio.ecommerce.backend.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8085
@RequestMapping("/api/v1/admin/categories")
//http://localhost:8085/api/v1/users: para acceder a este controlador
@Slf4j
public class CategoryController {

    //inyectamos por constructor nuestro servicio CategoryService:
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    /*
   Con @RequestBody Category category, indicamos el Body/cuerpo que envia el cliente en la petición.
   Y lo que hace @RequestBody es convertir un archivo Json a un Objeto java.

    ResponseEntity<> proporciona un control completo sobre la respuesta HTTP que se envía
    al cliente, permitiendo incluir tanto el cuerpo de los datos como un estado HTTP adecuado.

    El metodo devuelve una respuesta HTTP con:
    El objeto Category guardado en el cuerpo de la respuesta "categoryService.save(category)".
    Un estado HTTP de 201 Created, que informa al cliente que la operación
    fue exitosa y que un nuevo recurso ha sido creado.
     */
    @PostMapping("/saveCategory")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @GetMapping("/findAllCategories")
    public ResponseEntity<Iterable<Category>> findAllCategories(){
        return new ResponseEntity(categoryService.findAll(), HttpStatus.OK);
    }

    /*
   Con @PathVariable le  indicamos al metodo que cuando
   nos envien una variable mediante la URL se convierta al
   tipo de dato que tengo en los parametros(Integer)
    */
    @GetMapping("/findById/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id){
        return ResponseEntity.ok(categoryService.findById(id));
    }


    @DeleteMapping("/deleteCategoryById/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok().build();
    }
}
