package com.uniquindio.ecommerce.backend.infrastructure.config;

import com.uniquindio.ecommerce.backend.application.CategoryService;
import com.uniquindio.ecommerce.backend.application.OrderService;
import com.uniquindio.ecommerce.backend.application.ProductService;
import com.uniquindio.ecommerce.backend.application.UserService;
import com.uniquindio.ecommerce.backend.domain.port.ICategoryRepository;
import com.uniquindio.ecommerce.backend.domain.port.IOrdenRepository;
import com.uniquindio.ecommerce.backend.domain.port.IProductRepository;
import com.uniquindio.ecommerce.backend.domain.port.IUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
En esta clase vamos a declarar varios beans.
¿qué es un bean?
Un bean en Spring es un objeto que es administrado por el contenedor
de Spring. Los beans representan los componentes clave de una aplicación y son
instancias de clases configuradas, creadas y gestionadas por
el Spring IoC (Inversion of Control) Container.

Qué hace un bean?
Un bean permite centralizar la creación, configuración, inicialización y
destrucción de objetos dentro del contenedor de Spring. En lugar de que tú te encargues de
crear manualmente instancias de clases (usando new), el contenedor de Spring lo hace por ti.
 */
@Configuration
public class BeanConfiguration {

    /*
    En este metodo indicamos que la clase UserService,CategoryService sean un @Bean para que
    spring lo gestione. Cabe recordar que a esta clase "UserService" se le inyecta
    la interface "IUserRepository"  y lo mismo pasa con CategoryService que se le
    inyecta ICategoryRepository, por eso lo enviamos por parametro en ests metodos. De esta
    maenra conectamos la clase UserService que esta en la clase de aplicación con la
    con la clase que implemneta los métodos CRUD especificos para la BD(UserCrudRepositoryImpl,
    CategoryCrudRepositoryImpl).

    En Este caso específico, esta clase se asegura de que la clase UserService,
    CategoryService (que es parte de la capa de aplicación) estén disponibles
    como un bean gestionado por Spring, para que pueda ser inyectada en
    otras partes de la aplicación, como el controlador (UserController, CategoryController).
     */
    @Bean
    public UserService userService(IUserRepository iUserRepository) {
        return new UserService(iUserRepository);
    }

    @Bean
    public CategoryService categoryService(ICategoryRepository iCategoryRepository) {
        return new CategoryService(iCategoryRepository);
    }

    @Bean
    public ProductService productService(IProductRepository iProductRepository) {
        return new ProductService(iProductRepository);
    }

    @Bean
    public OrderService orderService(IOrdenRepository iOrdenRepository){
        return new OrderService(iOrdenRepository);
    }
}
