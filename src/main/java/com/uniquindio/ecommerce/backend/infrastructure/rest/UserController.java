package com.uniquindio.ecommerce.backend.infrastructure.rest;

import com.uniquindio.ecommerce.backend.application.UserService;
import com.uniquindio.ecommerce.backend.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//http://localhost:8085
@RequestMapping("/api/v1/users")
//http://localhost:8085/api/v1/users: para acceder a este controlador
@Slf4j//para mostrar los logs
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
    public ResponseEntity<User> save(@RequestBody User user) {
        log.info("Nombre User: {}", user.getFirstname());
        return  new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    /*
    Con @PathVariable le  indicamos al metodo que cuando
    nos envien una variable mediante la URL se convierta al
    tipo de dato que tengo en los parametros(Integer)
     */
    @GetMapping("/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id ) {
        return ResponseEntity.ok(userService.findById(id));
    }
}
