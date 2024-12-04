package com.uniquindio.ecommerce.backend.infrastructure.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity//Con esto le decimos a spring que esta clase tiene que mapearse a la BD
@Table(name = "Order_Products")//Con esto le indicamos el nombre de la tabla en la BD
@Data//Para generar los getter y setter de esta clase con la libreria Lombok
@NoArgsConstructor//Para generar constructor vacio
public class OrderProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para que me lo genere de forma incremental
    private Integer id;

    private BigDecimal quantity;
    private BigDecimal price;
    private Integer productId;//Realcionamos Orden con Producto por medio de su Id.
    /*
    Many: Esta claseEntidad(OrderProductEntity)
    One: Del atributo(OrderEntity), entonces
    Muchas OrderProductEntity(detalles) pertenecen a una OrderEntity(Maestro) y
    Una OrderEntity puede pertenecer a Muchas OrderProductEntity
     */
    @ManyToOne
    private OrderEntity orderEntity;//para saber a que OrderEntity pertenece
}
