package com.uniquindio.ecommerce.backend.infrastructure.mapper;

import com.uniquindio.ecommerce.backend.domain.model.Product;
import com.uniquindio.ecommerce.backend.infrastructure.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings(
            {
                    // source(ProductEntity): es la fuente de donde quiero obtener el valor
                    // target(Product): en donde quiero poner el valor
                    @Mapping(source = "id" , target = "id"),
                    @Mapping(source = "name" , target = "name"),
                    @Mapping(source = "code" , target = "code"),
                    @Mapping(source = "description" , target = "description"),
                    @Mapping(source = "urlImage" , target = "urlImage"),
                    @Mapping(source = "price" , target = "price"),
                    @Mapping(source = "dateCreated" , target = "dateCreated"),
                    @Mapping(source = "dateUpdated" , target = "dateUpdated"),
                    @Mapping(source = "userEntity.id", target = "userId"),
                    @Mapping(source = "categoryEntity.id", target = "categoryId")
            }
    )

    Product toProduct(ProductEntity productEntity);
    Iterable<Product> toProductList(Iterable<ProductEntity> productEntities);
    @InheritInverseConfiguration//para utilizar el @Mappings a la inversa
    ProductEntity toProductEntity(Product product);
}
