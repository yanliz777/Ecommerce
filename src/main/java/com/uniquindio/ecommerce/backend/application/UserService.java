package com.uniquindio.ecommerce.backend.application;

import com.uniquindio.ecommerce.backend.domain.model.User;
import com.uniquindio.ecommerce.backend.domain.port.IUserRepository;
/*
Esta clase no le ponemos la anotación @Service ya que es una clase de dominio, por buenas
practicas, no es bueno inyectar esta anotación de spring. Para que haya la funcionalidad
de servicio, para eso creamos en el paquete de infraestructure un paquete config y allí
creamos una clase en donde poner esta anotación de @Service y así cuidamos esta capa
del dominio.
 */
public class UserService {

    //Inyectamos por constructor la interface IUserRepository para utilizar sus métodos
    private final IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    //guardamos el usuario:
    public User save(User user) {
        return iUserRepository.save(user);
    }

    //Buscamos un usuario por su ID:
    public User findById(Integer id) {
        return iUserRepository.findById(id);
    }
}
