package com.uniquindio.ecommerce.backend.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private Integer id;
    private String name;
    private LocalDateTime dateCreated;//para guardar la fecha y hora de creación de la categoria
    private LocalDateTime dateUpdated;//Para cuando se actualiza unacategoria
}
