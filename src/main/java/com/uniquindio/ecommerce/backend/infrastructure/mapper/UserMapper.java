package com.uniquindio.ecommerce.backend.infrastructure.mapper;

import com.uniquindio.ecommerce.backend.domain.model.User;
import com.uniquindio.ecommerce.backend.infrastructure.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/*
Esta interface nos va a permitir mapear un objeto UserEntity a un objeto User.

Con esto "@Mapper(componentModel = "spring")" indicamos que esta interface se inyecte
en las clases en donde nosotros la necesitemos
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
/*
En "@Mappings" Hay que tener en cuenta que le Mapeo va a depender
de la clase fuente "userEntity", entonces en source de indicamos que
del objeto UserEntity tome un atributo y lo mapee/pase con target al objeto User
que es el que vamos a retornar en el metodo:

 */
    @Mappings(
            {
             // source(UserEntity): es la fuente de donde quiero obtener el valor
             // target(User): en donde quiero poner el valor
                    @Mapping(source = "id" , target = "id"),
                    @Mapping(source = "username" , target = "username"),
                    @Mapping(source = "firstname" , target = "firstname"),
                    @Mapping(source = "lastname" , target = "lastname"),
                    @Mapping(source = "email" , target = "email"),
                    @Mapping(source = "address" , target = "address"),
                    @Mapping(source = "cellphone" , target = "cellphone"),
                    @Mapping(source = "password" , target = "password"),
                    @Mapping(source = "userType" , target = "userType"),
                    @Mapping(source = "dateCreated" , target = "dateCreated"),
                    @Mapping(source = "dateUpdated" , target = "dateUpdated")
            }
    )

    /*
    Metodo para convertir un objeto de Tipo UserEntity
    a un objeto User.
     */
    User toUser(UserEntity userEntity);

    /*
    Metodo para convertir una lista de objetos de Tipo UserEntity
    a una lista de objetos User.
     */
    Iterable<User> toUsers(Iterable<UserEntity> userEntities);

    /*
    Metodo para convertir un objeto de Tipo User
    a un objeto UserEntity .
     */
    @InheritInverseConfiguration//para utilizar el @Mappings a la inversa
    UserEntity toUserEntity(User user);
}

