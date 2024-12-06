package com.uniquindio.ecommerce.backend.infrastructure.adapter;

import com.uniquindio.ecommerce.backend.domain.model.enums.OrderState;
import com.uniquindio.ecommerce.backend.infrastructure.entity.OrderEntity;
import com.uniquindio.ecommerce.backend.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface IOrderCrudRepository extends CrudRepository<OrderEntity, Integer> {

    //consulta para el metodo updateStateByOrderId:
    @Transactional
    @Modifying
    @Query("UPDATE OrderEntity o SET o.state = :state WHERE o.id = :id")
    void updateStateByOrderId(Integer id, OrderState state);

    Iterable<OrderEntity> findByUserEntity(UserEntity userEntity);
}
