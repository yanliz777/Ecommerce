package com.uniquindio.ecommerce.backend.domain.model;

import com.uniquindio.ecommerce.backend.domain.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data//Para generar los getter y setter de esta clase
@AllArgsConstructor//Para generar constructor con todos los atributos
@NoArgsConstructor//Para generar constructor vacio
public class User {
    private Integer id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String address;
    private String cellphone;
    private String password;
    private UserType userType;
    private LocalDateTime dateCreated;//para guardar la fecha y hora de creación del usuario
    private LocalDateTime dateUpdated;
}
