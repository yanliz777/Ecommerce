package com.uniquindio.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity//Con esto le decimos a spring que esta clase tiene que mapearse a la BD
@Table(name = "categories")//Con esto le indicamos el nombre de la tabla en la BD
@Data//Para generar los getter y setter de esta clase
@NoArgsConstructor//Para generar constructor vacio
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para que me lo genere de forma incremental
    private Integer id;

    private String name;

    @CreationTimestamp //Para que guarde la fecha y hora automaticamente cuando se crea un usuario
    private LocalDateTime dateCreated;//para guardar la fecha y hora de creación del usuario
    @UpdateTimestamp//Para que actualice la fecha y hora automaticamente cuando se crea un usuario
    private LocalDateTime dateUpdated;//Para cuando se actualiza un usuario
}
