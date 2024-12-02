package com.uniquindio.ecommerce.backend.domain.model;

import com.uniquindio.ecommerce.backend.domain.model.enums.OrderState;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
Aqui se utiliza una estrcutura maestro detalle, en donde
una Orden es la cabecera y los detalles son OrderProduct.

Maestro(cabecera): Order
Representa una orden completa que contiene información general sobre la transacción.

Relación Maestro-Detalle
La cabecera (Order) contiene una lista de detalles (OrderProduct).
Cada orden puede incluir uno o más productos (relación de uno a muchos).
En el código, esta relación se refleja mediante el atributo:
private List<OrderProduct> ordenProducts;
 */
@Data
public class Order {
    private Integer id;
    private LocalDateTime dateCreated;
    private List<OrderProduct> ordenProducts;//Relacionamos OrderProducts con Order
    private OrderState orderState;
    private Integer userId;//Realcionamos Order con User por medio de su Id

    public Order(){
        ordenProducts = new ArrayList<>();
    }

    //Metodo que nos calcula el total de todos los productos comprados:
    public BigDecimal getTotalOrderPrice(){
        return this.ordenProducts.stream().map(ordenProduct ->
                ordenProduct.getTotalItem()).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Metodo que nos calcula el total de todos los productos comprados:
    public BigDecimal getTotalOrderPrice1() {
        BigDecimal totalPrice = BigDecimal.ZERO; // Inicializamos el total en 0

        for (OrderProduct ordenProduct : this.ordenProducts) {// Recorremos la lista de productos

            if (ordenProduct != null && ordenProduct.getTotalItem() != null) {
                totalPrice = totalPrice.add(ordenProduct.getTotalItem()); // Sumamos el total de cada producto
            }
        }

        return totalPrice; // Retornamos el total calculado
    }

}
