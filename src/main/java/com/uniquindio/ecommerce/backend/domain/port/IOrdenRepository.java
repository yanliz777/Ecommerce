package com.uniquindio.ecommerce.backend.domain.port;

import com.uniquindio.ecommerce.backend.domain.model.Order;

public interface IOrdenRepository {

    Order save(Order order);
    Order findById(Integer id);
    Iterable<Order> findAll();
    Iterable<Order> findByUserId(Integer userId);
    void updateStateByOrderId(Integer orderId, String state);
}
