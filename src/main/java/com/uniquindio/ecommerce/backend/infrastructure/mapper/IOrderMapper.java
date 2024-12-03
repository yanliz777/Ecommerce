package com.uniquindio.ecommerce.backend.infrastructure.mapper;

import com.uniquindio.ecommerce.backend.domain.model.Order;
import com.uniquindio.ecommerce.backend.infrastructure.entity.OrderEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {IOrderProductMapper.class})
public interface IOrderMapper {

    @Mappings(
            {
                    // source(ProductEntity): es la fuente de donde quiero obtener el valor
                    // target(Product): en donde quiero poner el valor
                    @Mapping(source = "id" , target = "id"),
                    @Mapping(source = "dateCreated" , target = "dateCreated"),
                    @Mapping(source = "orderProducts" , target = "orderProducts"),
                    @Mapping(source = "state" , target = "state"),
                    @Mapping(source = "userEntity.id", target = "userId")
            }
    )
    Order toOrder(OrderEntity orderEntity);
    Iterable<Order> toOrderList(Iterable<OrderEntity> orderEntities);
    @InheritInverseConfiguration
    OrderEntity toOrderEntity(Order order);
}
