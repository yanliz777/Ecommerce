package com.uniquindio.ecommerce.backend.domain.port;

import com.uniquindio.ecommerce.backend.domain.model.Product;

/*
Estas interfaces son los puertos que nos permiten comunicarnos con el exteriror
es decir, para que haya una comunicación entre el modelo/dominio y la parte externa.
Acá creamos todos lo métodos CRUD para nuestra interface producto.
 */
public interface IProductRepository {
    Product save(Product product);
    Iterable<Product> findAll();//para listar todos los productos
    Product findById(Integer id);//Obtenermos un producto por medio de su ID
    void deleteById(Integer id);
}
