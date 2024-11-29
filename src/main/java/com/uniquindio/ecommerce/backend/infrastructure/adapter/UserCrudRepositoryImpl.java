package com.uniquindio.ecommerce.backend.infrastructure.adapter;

import com.uniquindio.ecommerce.backend.domain.model.User;
import com.uniquindio.ecommerce.backend.domain.port.IUserRepository;
import org.springframework.stereotype.Repository;

/*
Hay que tener en cuenta que tenemos un modelo que es diferente a las entidades que
estamos utilizando en el paquete adapter para persistencia,por ejemplo, en el
modelo tenemos una clse User, pero para la persistencia tenemos una clase
llamada UserEntity(que es la que se mapea a la BD) estado sdos clases, User y UserEntity
tienen los mismos atribustos pero sus nombres son diferentes, entonces lo que hacemos
en esta clase UserCrudRepositoryImpl es convertir de un objeto a otro, en este caso,
cuendo en el Front se nos envíe un objetode tipo User para guardar va a venir como User
sin embargo nosotros al utilizar la interface IUserCrudRepository estamos indicando
que vamos a utilizar objetos de tipo UserEntity, entonces aquí debemos hacer un mapeo
para cuando desde el front me envíen un objeto User yo lo pueda transformar a un objeto
de tipo UserEntity y lo pueda guardar en la BD, para esto utilizamos la libreria mapstruct
que esta como dependencia en el archivo pom.xml.
 */
@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    //Inyectamos la Variable por constructor, ya que esta accede a la BD:
    private final IUserCrudRepository userCrudRepository;

    public UserCrudRepositoryImpl(IUserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        return null;
    }
}
