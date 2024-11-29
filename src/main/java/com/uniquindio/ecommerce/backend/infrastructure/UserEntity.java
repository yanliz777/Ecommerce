package com.uniquindio.ecommerce.backend.infrastructure;

import com.uniquindio.ecommerce.backend.domain.model.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
/*
Esta clase se va a mapear como una tabla en el BD, esta tabla se va a llamar users
 */

@Entity//Con esto le decimos a spring que esta clase tiene que mapearse a la BD
@Table(name = "users")//Con esto le indicamos el nombre de la tabla en la BD
@Data//Para generar los getter y setter de esta clase
@NoArgsConstructor//Para generar constructor vacio
public class UserEntity {

    @Id//Para que sepa que este atributo es un id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para que me lo genere de forma incremental
    private Integer id;

    private String username;
    private String firstname;
    private String lastname;

    @Column(unique = true)//Para que este campo sea único
    private String email;

    private String address;
    private String cellphone;
    private String password;

    @Enumerated(EnumType.STRING)//Para mapear el Enum como un String en la BD
    private UserType userType;//se guarda si es un admin o usuario

    @CreationTimestamp //Para que guarde la fecha y hora automaticamente cuando se crea un usuario
    private LocalDateTime dateCreated;//para guardar la fecha y hora de creación del usuario
    @UpdateTimestamp//Para que actualice la fecha y hora automaticamente cuando se crea un usuario
    private LocalDateTime dateUpdated;//Para cuando se actualiza un usuario
}
