package com.uniquindio.ecommerce.backend.infrastructure.adapter;

import com.uniquindio.ecommerce.backend.domain.model.Order;
import com.uniquindio.ecommerce.backend.domain.port.IOrdenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@AllArgsConstructor
@Repository
public class OrderCrudRepositoryImpl implements IOrdenRepository {

    private final IOrderCrudRepository iOrderCrudRepository;

    @Override
    public Order save(Order order) {
        return null;
    }

    @Override
    public Order findById(Integer id) {
        return null;
    }

    @Override
    public Iterable<Order> findAll() {
        return null;
    }

    @Override
    public Iterable<Order> findByUserId(Integer userId) {
        return null;
    }

    @Override
    public void updateStateByOrderId(Integer orderId, String state) {

    }
}
