package com.uniquindio.ecommerce.backend.infrastructure.adapter;

import com.uniquindio.ecommerce.backend.domain.model.Product;
import com.uniquindio.ecommerce.backend.domain.port.IProductRepository;
import com.uniquindio.ecommerce.backend.infrastructure.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductCrudRepositoryImpl implements IProductRepository {

    //Inyectamos estas dos interfaces por constructor:
    private final IProductCrudRepository iProductCrudRepository;
    private final ProductMapper productMapper;

    public ProductCrudRepositoryImpl(IProductCrudRepository iProductCrudRepository, ProductMapper productMapper) {
        this.iProductCrudRepository = iProductCrudRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Product save(Product product) {
        return null;
    }

    @Override
    public Iterable<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Integer id) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
