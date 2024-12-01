package com.uniquindio.ecommerce.backend.infrastructure.adapter;

import com.uniquindio.ecommerce.backend.domain.model.Category;
import com.uniquindio.ecommerce.backend.domain.port.ICategoryRepository;
import com.uniquindio.ecommerce.backend.infrastructure.entity.CategoryEntity;
import com.uniquindio.ecommerce.backend.infrastructure.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/*
La anotación @Repository en Spring es una especialización de
la anotación @Component que indica que la clase marcada actúa como un
repositorio, es decir, una clase que interactúa directamente con la
base de datos o con la capa de persistencia.

Implementamos ICategoryRepository para poder conectarnos con el servicio de esta
clase a nivel de dominio, que es CategoryService.
 */
@Repository
public class CategoryCrudRepositoryImpl implements ICategoryRepository {

    /*
    Inyectamos la interfaces por constructor, ya que esta accede a la BD,ya
    que esta interface utiliza CategoryEntity que es la que se mapea a la BD:
     */
    private final ICategoryCrudRepository iCategoryCrudRepository;
    /*
    Inyectamos la interface por constructor, ya que esta mapea los objetos, es decir,
    me ayuda a cambiar de un objeto tipo Category a uno CategoryEntity y viseversa:
     */
    private final CategoryMapper categoryMapper;

    public CategoryCrudRepositoryImpl(ICategoryCrudRepository iCategoryCrudRepository, CategoryMapper categoryMapper) {
        this.iCategoryCrudRepository = iCategoryCrudRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public Category save(Category category) {
        // 1. Convertir el Category (dominio) a CategoryEntity (persistencia)
        CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(category);
        // 2. Guarda el CategoryEntity en la base de datos usando el CrudRepository
        CategoryEntity saveCategoryEntity = iCategoryCrudRepository.save(categoryEntity);
        // 3. Convierte el CategoryEntity guardado de vuelta a Category (dominio)
        return categoryMapper.toCategory(saveCategoryEntity);
    }

    @Override
    public Iterable<Category> findAll() {
        return categoryMapper.toCategoriesList( iCategoryCrudRepository.findAll());
    }

   /* @Override
    public Category findById(Integer id) {
        return categoryMapper.toCategory(iCategoryCrudRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Categoria con id: " + id + " no existe")
        ));
    }*/

    @Override
    public Category findById(Integer id) {
        Optional<CategoryEntity> optionalCategoryEntity = iCategoryCrudRepository.findById(id);

        if (optionalCategoryEntity.isPresent()) {
            return categoryMapper.toCategory(optionalCategoryEntity.get());//hacemos el mapeo
        } else {
            throw new RuntimeException("Categoria con id: " + id + " no existe");
        }
    }

    @Override
    public void deleteById(Integer id) {
        Optional<CategoryEntity> categoryEntity = iCategoryCrudRepository.findById(id);

        if (!categoryEntity.isPresent()) {
            throw new RuntimeException("Categoria con id: " + id + " no existe");
        }
        //no hacemos mapeo ya que lo elimina directamente de la BD:
        iCategoryCrudRepository.deleteById(id);
    }
}
