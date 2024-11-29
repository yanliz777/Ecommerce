package com.uniquindio.ecommerce.backend.infrastructure.adapter;

import com.uniquindio.ecommerce.backend.domain.model.User;
import com.uniquindio.ecommerce.backend.domain.port.IUserRepository;
import com.uniquindio.ecommerce.backend.infrastructure.entity.UserEntity;
import com.uniquindio.ecommerce.backend.infrastructure.mapper.UserMapper;
import org.springframework.stereotype.Repository;

/*
Hay que tener en cuenta que tenemos un modelo que es diferente a las entidades que
estamos utilizando en el paquete adapter para persistencia,por ejemplo, en el
modelo tenemos una clase User, pero para la persistencia tenemos una clase
llamada UserEntity(que es la que se mapea a la BD) estas dos clases, User y UserEntity
tienen los mismos atribustos pero sus nombres son diferentes, entonces lo que hacemos
en esta clase UserCrudRepositoryImpl es convertir de un objeto a otro(usando las clases Mapper),
en este caso, cuando en el Front se nos envíe un objeto de tipo User para guardar va a venir
como User sin embargo nosotros al utilizar la interface IUserCrudRepository estamos indicando
que vamos a utilizar objetos de tipo UserEntity, entonces aquí debemos hacer un mapeo
para cuando desde el front me envíen un objeto User yo lo pueda transformar a un objeto
de tipo UserEntity y lo pueda guardar en la BD, para esto utilizamos la libreria mapstruct
que esta como dependencia en el archivo pom.xml.

Acá se implemneta la interface del dominio "IUserRepository" para tener acceso a los metodos
CRUD y de esta manera nos comunicamos con la capa del dominio, por eso se les llama puerto
a estas interfaces por que son el canal de comunicación entres las distintas capas. Admeás se
hace uso de una variable de tipo IUserCrudRepository que es la interface que extiende de
CrudRepository y esta es la que permite hacer los CRUD en la BD porque usa UserEntity
 */
@Repository
public class UserCrudRepositoryImpl implements IUserRepository {

    /*
    Inyectamos la interface por constructor, ya que esta accede a la BD,ya
    que esta interface utiliza UserEntity que es la que se mapea a la BD:
     */
    private final IUserCrudRepository userCrudRepository;
    /*
    Inyectamos la interface por constructor, ya que esta mapea los objetos, es decir,
    me ayuda a cambiar de un objeto tipo User a uno UserEntity y viseversa:
     */
    private final UserMapper userMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository userCrudRepository, UserMapper userMapper) {
        this.userCrudRepository = userCrudRepository;
        this.userMapper = userMapper;
    }

   /* @Override
    public User save(User user) {
        return userMapper.toUser(userCrudRepository.save(userMapper.toUserEntity(user)));
    }*/

   @Override
   public User save(User user) {
       // 1. Convertir el User (dominio) a UserEntity (persistencia)
       UserEntity userEntity = userMapper.toUserEntity(user);

       // 2. Guardar el UserEntity en la base de datos usando el CrudRepository
       UserEntity savedEntity = userCrudRepository.save(userEntity);

       // 3. Convertir el UserEntity guardado de vuelta a User (dominio)
       return userMapper.toUser(savedEntity);
   }

    @Override
    public User findByEmail(String email) {
        return null;
    }

    @Override
    public User findById(Integer id) {
        /*
        tenemos que get() porque esto "userCrudRepository.findById(id)" nos
        devuelve un objeto de Tipo Optional<>
         */
        return userMapper.toUser(userCrudRepository.findById(id).get());
    }
}
