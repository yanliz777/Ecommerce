package com.uniquindio.ecommerce.backend.infrastructure.mapper;

import com.uniquindio.ecommerce.backend.domain.model.Category;
import com.uniquindio.ecommerce.backend.infrastructure.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/*
Esta interface nos va a permitir mapear un objeto CategoryEntity a un objeto Category y viseversa.

Con esto "@Mapper(componentModel = "spring")" indicamos que esta interface se inyecte(instancie)
en las clases en donde nosotros la necesitemos.
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings(
            {
                    @Mapping(source = "id", target = "id"),
                    @Mapping(source = "name", target = "name"),
                    @Mapping(source = "dateCreated", target = "dateCreated"),
                    @Mapping(source = "dateUpdated", target = "dateUpdated")

            }
    )

    //pasa de un objeto CategoryEntity a Category y lo retorna
    Category toCategory(CategoryEntity categoryEntity);
    //pasa de una lista de objetos de CategoryEntity a una lista de objetos Category y lo retorna
    Iterable<Category> toCategoriesList(Iterable<CategoryEntity> categoryEntities);

    //pasa de un objeto Category a CategoryEntity y lo retorna:
    @InheritInverseConfiguration//para utilizar el @Mappings a la inversa
    CategoryEntity toCategoryEntity(Category category);

}
