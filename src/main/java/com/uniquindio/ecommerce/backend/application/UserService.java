package com.uniquindio.ecommerce.backend.application;

import com.uniquindio.ecommerce.backend.domain.model.User;
import com.uniquindio.ecommerce.backend.domain.port.IUserRepository;

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
