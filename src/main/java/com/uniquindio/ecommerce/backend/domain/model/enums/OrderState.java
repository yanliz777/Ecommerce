package com.uniquindio.ecommerce.backend.domain.model.enums;

public enum OrderState {
    CANCELLED,//cuando el usuario añade los productos al carrito y NO hace el pago
    CONFIRMED;//cuando el usuario añade los productos al carrito y SI hace el pago
}
