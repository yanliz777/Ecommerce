package com.uniquindio.ecommerce.backend.domain.port;

import com.uniquindio.ecommerce.backend.domain.model.Category;

public interface ICategoryRepository {
    Category save(Category category);
    Iterable<Category> findAll();//para obtener todas la categorias
    Category findById(Integer id);
    void deleteById(Integer id);
}
