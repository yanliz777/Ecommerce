package com.uniquindio.ecommerce.backend.infrastructure.adapter;

import com.uniquindio.ecommerce.backend.domain.model.Order;
import com.uniquindio.ecommerce.backend.domain.model.enums.OrderState;
import com.uniquindio.ecommerce.backend.domain.port.IOrdenRepository;
import com.uniquindio.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.uniquindio.ecommerce.backend.infrastructure.entity.OrderProductEntity;
import com.uniquindio.ecommerce.backend.infrastructure.entity.UserEntity;
import com.uniquindio.ecommerce.backend.infrastructure.mapper.IOrderMapper;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class OrderCrudRepositoryImpl implements IOrdenRepository {

    private final IOrderCrudRepository iOrderCrudRepository;
    private final IOrderMapper iOrderMapper;

    public OrderCrudRepositoryImpl(IOrderCrudRepository iOrderCrudRepository, IOrderMapper iOrderMapper) {
        this.iOrderCrudRepository = iOrderCrudRepository;
        this.iOrderMapper = iOrderMapper;
    }


   /* @Override
    public Order save(Order order) {
        OrderEntity orderEntity = iOrderMapper.toOrderEntity(order);
        /*
        Cuando guardamos una Orden(orderEntity) también guardamos
        los detalles(OrderProductEntity) de esa orden:

        orderEntity.getOrderProducts().forEach(
                orderProductEntity -> {
                    orderProductEntity.setOrderEntity(orderEntity);
                }
        );

        return iOrderMapper.toOrder(iOrderCrudRepository.save(orderEntity));
    }*/

    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = iOrderMapper.toOrderEntity(order);
        /*
        Cuando guardamos una Orden(orderEntity) también guardamos
        los detalles(OrderProductEntity) de esa orden.

        Establecemos la relación entre la orden y sus productos:
         */
        for (OrderProductEntity orderProductEntity : orderEntity.getOrderProducts()) {
            orderProductEntity.setOrderEntity(orderEntity);
        }

        return iOrderMapper.toOrder(iOrderCrudRepository.save(orderEntity));
    }

    @Override
    public Order findById(Integer id) {
        Optional<OrderEntity> ordertEntity = iOrderCrudRepository.findById(id);

        if(ordertEntity.isPresent()){
            return iOrderMapper.toOrder(ordertEntity.get());
        }else{
            throw new RuntimeException("Orden con id: " + id + " no existe");
        }
    }

    @Override
    public Iterable<Order> findAll() {
        return iOrderMapper.toOrderList(iOrderCrudRepository.findAll());
    }

    @Override
    public Iterable<Order> findByUserId(Integer userId) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);

        return iOrderMapper.toOrderList(iOrderCrudRepository.findByUserEntity(userEntity));
    }

    @Override
    public void updateStateByOrderId(Integer orderId, String state) {
        if (state.equals(OrderState.CANCELLED)){
            iOrderCrudRepository.updateStateByOrderId(orderId,OrderState.CANCELLED);
        }else {
            iOrderCrudRepository.updateStateByOrderId(orderId,OrderState.CONFIRMED);
        }
    }
}
