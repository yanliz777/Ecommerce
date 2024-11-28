package com.uniquindio.ecommerce.backend.application;

import com.uniquindio.ecommerce.backend.domain.model.Product;
import com.uniquindio.ecommerce.backend.domain.port.IProductRepository;

public class ProductService {

    //Inyectamos por constructor la interface IProductRepository para utilizar sus métodos
    private final IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    //Guardamos un producto:
    public Product save(Product product) {
        return iProductRepository.save(product);
    }

    //Listamos los productos:
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    //Buscamos un producto por su ID:
    public Product findById(Integer id) {
        return iProductRepository.findById(id);
    }

    //Eliminamos un producto por con ID:
    public void delete(Integer id) {
        iProductRepository.deleteById(id);
    }

}
