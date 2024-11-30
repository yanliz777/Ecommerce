package com.uniquindio.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity//Con esto le decimos a spring que esta clase tiene que mapearse a la BD
@Table(name = "products")//Con esto le indicamos el nombre de la tabla en la BD
@Data//Para generar los getter y setter de esta clase con la libreria Lombok
@NoArgsConstructor//Para generar constructor vacio
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para que me lo genere de forma incremental
    private Integer id;
    private String name;
    private String code;
    private String description;
    private String urlImage;
    private BigDecimal price;

    @CreationTimestamp //Para que guarde la fecha y hora automaticamente cuando se crea un producto
    private LocalDateTime dateCreated;//para guardar la fecha y hora de creación del usuario
    @UpdateTimestamp//Para que actualice la fecha y hora automaticamente cuando se crea un producto
    private LocalDateTime dateUpdated;//Para cuando se actualiza un usuario

    /*
    Llaves Foraneas para relacionar esta clase con un UserEntity y una CategoryEntity
    Agregamos las cardinalidades:
    (User - Products)Muchos productos van a tener a un Usuario y Un usuario puede tener muchos productos.
    (Category - Products)Una Categoria puede tener muchos productos y muchos productos pueden estar en una categoria

    Esto significa que muchos objetos (o registros)
    de la entidad actual(ProductEntity) están relacionados con un solo usuario(UserEntity):
     */
    @ManyToOne
    private UserEntity userEntity;
    /*
     Esto significa que muchos objetos (o registros) de
    la entidad actualProductEntity) están relacionados con una sola categoría(CategoryEntity):
     */
    @ManyToOne
    private CategoryEntity categoryEntity;

}
