package com.uniquindio.ecommerce.backend.infrastructure.adapter;

import com.uniquindio.ecommerce.backend.domain.model.Product;
import com.uniquindio.ecommerce.backend.domain.port.IProductRepository;
import com.uniquindio.ecommerce.backend.infrastructure.entity.ProductEntity;
import com.uniquindio.ecommerce.backend.infrastructure.mapper.ProductMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@AllArgsConstructor
@Repository
public class ProductCrudRepositoryImpl implements IProductRepository {

    /*
    Inyectamos estas dos interfaces por constructor haciendo uso de la anotación
    de lombok @AllArgsConstructor, una para mapear de ProductEntity a product
    o viseversa y la otra para comunicarnos con la BD:
     */
    private final IProductCrudRepository iProductCrudRepository;
    private final ProductMapper productMapper;

    @Override
    public Product save(Product product) {
        return productMapper.toProduct(
                iProductCrudRepository.save(productMapper.toProductEntity(product)));
    }

    @Override
    public Iterable<Product> findAll() {
        return productMapper.toProductList(iProductCrudRepository.findAll());
    }

    @Override
    public Product findById(Integer id) {
        Optional<ProductEntity> productEntity = iProductCrudRepository.findById(id);

        if(productEntity.isPresent()){
            return productMapper.toProduct(productEntity.get());
        }else{
            throw new RuntimeException("Producto con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Integer id) {
        Optional<ProductEntity> optionalProduct = iProductCrudRepository.findById(id);

        if (!optionalProduct.isPresent()) {
            throw new RuntimeException("Producto con id: " + id + " no existe");
        }
        // No hacemos mapeo ya que lo elimina directamente de la BD
        iProductCrudRepository.deleteById(id);
    }
}
