package com.uniquindio.ecommerce.backend.application;

import com.uniquindio.ecommerce.backend.domain.model.Order;
import com.uniquindio.ecommerce.backend.domain.port.IOrdenRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderService {

    //Inyectamos por constructor la interface/puerto
    private final IOrdenRepository iOrdenRepository;

    public Order save(Order order) {
        return iOrdenRepository.save(order);
    }

    public Order findById(Integer id) {
        return iOrdenRepository.findById(id);
    }

    public Iterable<Order> findAll() {
        return iOrdenRepository.findAll();
    }

    public Iterable<Order> findByUserId(Integer id) {
        return iOrdenRepository.findByUserId(id);
    }

    public void updateStateByOrderId(Integer id, String state) {
        this.iOrdenRepository.updateStateByOrderId(id,state);
    }

}
