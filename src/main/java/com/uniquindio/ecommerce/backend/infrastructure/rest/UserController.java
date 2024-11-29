package com.uniquindio.ecommerce.backend.infrastructure.rest;

import com.uniquindio.ecommerce.backend.application.UserService;
import com.uniquindio.ecommerce.backend.domain.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8085
@RequestMapping("/api/v1/users")
//http://localhost:8085/api/v1/users: para acceder a este controlador
public class UserController {

    //inyectamos por constructor nuestro UserService:
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*
   Con @RequestBody User user, indicamos el Body que envia el cliente en la petición.
   Y lo que hace @RequestBody es convertir un archivo Json a un Objeto java
   */
    @PostMapping("/saveUser")
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    /*
    Con @PathVariable le  indicamos al metodo que cuando
    nos envien una variable mediante la URL se convierta al
    tipo de dato que tengo en los parametros(Integer)
     */
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id ) {
        return userService.findById(id);
    }
}
