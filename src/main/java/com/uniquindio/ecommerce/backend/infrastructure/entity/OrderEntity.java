package com.uniquindio.ecommerce.backend.infrastructure.entity;

import com.uniquindio.ecommerce.backend.domain.model.enums.OrderState;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
@Data
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//para que me lo genere de forma incremental
    private Integer id;
    @CreationTimestamp
    private LocalDateTime dateCreated;
    @Enumerated(value = EnumType.STRING)
    private OrderState state;

    /*
    Many: Esta claseEntidad(OrderEntity)
    One: Del atributo(userEntity), entonces
    Un UserEntity puede tener muchas OrderEntity  y muchas OrderEntity
    see asocian a un solo UserEntity.
    Siempre se pone la llave foranea en el lado de muchos:
     */
    @ManyToOne
    private UserEntity userEntity;
    /*
    One: Esta claseEntidad(OrderEntity)
    Many: Del atributo(userEntity), entonces
    Una ordenEntity puede tener muchos objetos de tipo OrderProductEntity y
    Muchos OrderProductEntity pueden pertenecer a una sola OrderEntity.

    Ponemos mappedBy = "orderEntity" para saber con cual atributo de OrderProductEntity
    se relaciona(foranea). Esto hace que la relación sea bidireccional, es decir, Si tienes
    una orden (OrderEntity) que contiene varios productos (OrderProductEntity),
    la relación bidireccional significa que:
    Desde un objeto OrderEntity, puedes acceder a los productos asociados.
    Desde un objeto OrderProductEntity, puedes acceder a la orden a la que pertenece.

    y cascade = CascadeType.PERSIST significa que
    cuando se guarda (persist) un objeto de OrderEntity, automáticamente
    se guardarán también sus OrderProductEntity asociados.:
     */
    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.PERSIST)
    private List<OrderProductEntity> orderProducts;

}
