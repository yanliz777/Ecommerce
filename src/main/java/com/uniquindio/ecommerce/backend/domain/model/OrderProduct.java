package com.uniquindio.ecommerce.backend.domain.model;

import lombok.Data;
import java.math.BigDecimal;
/*
Detalle: OrderProduct
Representa los productos individuales dentro de la orden y
contiene detalles específicos de cada producto:
 */
@Data
public class OrderProduct {
    private Integer id;
    private BigDecimal quantity;
    private BigDecimal price;
    private Integer productId;//Realcionamos Orden con Producto por medio de su Id.

    /*
    Metodo para calcular el precion de un producto cuando lleva más de uno.
    Es decir, calcula si un usuario compra más de una unidad del mismo producto:
     */
    public BigDecimal getTotalItem(){
        //return  this.price.multiply(quantity);
        return this.quantity.multiply(price);
    }

}
