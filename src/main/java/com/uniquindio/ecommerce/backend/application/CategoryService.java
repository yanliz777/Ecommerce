package com.uniquindio.ecommerce.backend.application;

import com.uniquindio.ecommerce.backend.domain.model.Category;
import com.uniquindio.ecommerce.backend.domain.port.ICategoryRepository;

public class CategoryService {

    //Inyectamos por constructor la interface ICategoryRepository para utilizar sus métodos
    private final ICategoryRepository icategoryRepository;

    //constructor:
    public CategoryService(ICategoryRepository icategoryRepository) {
        this.icategoryRepository = icategoryRepository;
    }

    //Para guardar la categoría
    public Category save(Category category) {
        return icategoryRepository.save(category);
    }

    //listamos todas la categorias:
    public Iterable<Category> findAll() {
        return icategoryRepository.findAll();
    }

    //obtenemos una categoria por su id:
    public Category findById(Integer id) {
        return icategoryRepository.findById(id);
    }

    //Eliminamos una categoría por su id:
    public void delete(Integer id) {
        icategoryRepository.deleteById(id);
    }

}
